package UnitTests;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.example.springboot.grpc.CamelHTTP2Route;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Our first unit test using the Mock component
 */
public class MockHttp2Route extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new CamelHTTP2Route();
    }

    @Test
    public void testEndPoint() throws Exception {
        // get the mock endpoint
        MockEndpoint end = getMockEndpoint("mock:end");
        // set expectations such as 1 message should arrive

        //end.allMessages().body().convertTo(String.class).contains("name: \"Camel\"\n" +"city: \"London\"");
        end.expectedMessageCount(1);

        // verify the result
        end.assertIsSatisfied();
        List<Exchange> list = end.getReceivedExchanges();
        String body = list.get(0).getIn().getBody(String.class);
        System.out.println("body : \n" + body);
    }

}