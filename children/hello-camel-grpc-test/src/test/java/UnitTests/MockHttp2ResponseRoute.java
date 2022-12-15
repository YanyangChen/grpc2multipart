package UnitTests;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.example.springboot.grpc.CamelHTTP2RouteResponse;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Test;

import java.util.List;


/**
 * Our first unit test using the Mock component
 */
@UseAdviceWith
public class MockHttp2ResponseRoute extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new CamelHTTP2RouteResponse();
    }

    @Test
    public void testEndPoint() throws Exception {
        // get the mock endpoint
        MockEndpoint end = getMockEndpoint("mock:endRes");
        // set expectations such as 1 message should arrive

        //end.allMessages().body().convertTo(String.class).contains("name: \"Camel\"\n" +"city: \"London\"");
        end.expectedMessageCount(1);

        // verify the result
        end.assertIsSatisfied();
        List<Exchange> list = end.getReceivedExchanges();
        String body = list.get(0).getIn().getBody(String.class);
        String headers = String.valueOf(list.get(0).getIn().getHeaders());
        System.out.println("body : \n" + body);
        System.out.println("headers : \n" + headers);
        String outbody = list.get(0).getOut().getBody(String.class);
        String ourheaders = String.valueOf(list.get(0).getOut().getHeaders());
        System.out.println("outbody : \n" + outbody);
        System.out.println("ourheaders : \n" + ourheaders);
    }

}
