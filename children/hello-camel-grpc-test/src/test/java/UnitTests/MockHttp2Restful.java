package UnitTests;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.example.springboot.grpc.HTTP2NettyRoute;
import org.apache.camel.example.springboot.grpc.HTTP2NettyRouteSeda;
import org.apache.camel.example.springboot.grpc.RestfulEntryRoute;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class MockHttp2Restful extends CamelTestSupport {

    @EndpointInject("mock:restfulStart")
    protected MockEndpoint mockRestfulStart;

    @EndpointInject("mock:restfulEnd")
    protected MockEndpoint mockRestfulEnd;



    @Override
    protected  RouteBuilder[] createRouteBuilders() {
        RouteBuilder[] rbs = {new HTTP2NettyRoute(), new RestfulEntryRoute()};
        return rbs;
    }

    @Test
    public void testEndPoint() throws Exception {
        AdviceWith.adviceWith(context, "restStartRoute", routeBuilder ->{
            routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to("netty-http:http://0.0.0.0:9501/middle");
            routeBuilder.weaveAddLast().to(mockRestfulStart);

        });
        // mockRestfulStart.expectedMinimumMessageCount(1);

        AdviceWith.adviceWith(context, "nettyStart", routeBuilder ->{
            //routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to(mockRestfulEnd);

        });
        mockRestfulEnd.expectedMinimumMessageCount(1);

        context.start();
        template.sendBodyAndHeader("direct:mockStart", "testing_body", "test", "Restful Header");
        mockRestfulStart.assertIsSatisfied();
        mockRestfulEnd.assertIsSatisfied();
    }

}
