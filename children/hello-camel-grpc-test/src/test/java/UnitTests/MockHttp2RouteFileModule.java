package UnitTests;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.example.springboot.grpc.FileEntryRoute;
import org.apache.camel.example.springboot.grpc.HTTP2NettyRoute;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

/**
 * Our first unit test using the Mock component
 */
public class MockHttp2RouteFileModule extends CamelTestSupport {

    @EndpointInject("mock:grpcStart")
    protected MockEndpoint mockGrpcStart;

    @Override
    protected RouteBuilder[] createRouteBuilders() throws Exception {
        RouteBuilder[] rbs = { new FileEntryRoute(), new HTTP2NettyRoute()};
        return rbs;
    }

    @Test
    public void testEndPoint() throws Exception {
        // get the mock endpoint
        MockEndpoint end = getMockEndpoint("mock:end");
        // set expectations such as 1 message should arrive

        AdviceWith.adviceWith(context, "httpFIleRoute", routeBuilder ->{
            //routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to("netty-http:http://0.0.0.0:9501/middle");
            //routeBuilder.weaveAddLast().wireTap(mockGrpcStart);

        });

        AdviceWith.adviceWith(context, "nettyStart", routeBuilder ->{
            //routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to(end);

        });


        //end.allMessages().body().convertTo(String.class).contains("name: \"Camel\"\n" +"city: \"London\"");
        end.expectedMessageCount(1);
        // verify the result
        end.assertIsSatisfied();


    }

}
