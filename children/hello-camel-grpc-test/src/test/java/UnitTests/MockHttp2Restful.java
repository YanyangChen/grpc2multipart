package UnitTests;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.example.springboot.grpc.CamelHTTP2RestfulRoute;
import org.apache.camel.example.springboot.grpc.CamelHTTP2RouteResponse;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MockHttp2Restful extends CamelTestSupport {

    @EndpointInject("mock:restfulStart")
    protected MockEndpoint mockRestfulStart;

    @EndpointInject("mock:restfulEnd")
    protected MockEndpoint mockRestfulEnd;

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new CamelHTTP2RestfulRoute();
    }

    @Test
    public void testEndPoint() throws Exception {
        AdviceWith.adviceWith(context, "restStartRoute", routeBuilder ->{
            routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to(mockRestfulStart);

        });
        // mockRestfulStart.expectedMinimumMessageCount(1);

        AdviceWith.adviceWith(context, "http2restfulEnd", routeBuilder ->{
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
