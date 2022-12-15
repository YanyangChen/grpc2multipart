package TestExamples.AdviceExamples;

import org.apache.camel.EndpointInject;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

/**
 * Unit test demonstrating various functionality of using advice-with
 * https://github.com/camelinaction/camelinaction2/blob/9921df2acbe6e3c1d825f4455668097db0205841/chapter9/advicewith/src/test/java/camelinaction/AdviceWithMockEndpointsTest.java
 */
public class AdviceWithMockEndpointsTest extends CamelTestSupport {

    @EndpointInject("mock:seda:camel")
    protected MockEndpoint camelPoint;

    @EndpointInject("mock:seda:other")
    protected MockEndpoint otherPoint;




    @Test
    public void testMockEndpoints() throws Exception {

        // must start Camel after we are done using advice-with
        AdviceWith.adviceWith(context, "quotes", routeBuilder ->{
            routeBuilder.weaveByToUri("seda:camel").replace().to(camelPoint);
            routeBuilder.weaveByToUri("seda:other").replace().to(otherPoint);


        });
        context.start();

        camelPoint.expectedBodiesReceived("Camel rocks");
        otherPoint.expectedBodiesReceived("Bad donkey");

        template.sendBody("seda:quotes", "Camel rocks");
        template.sendBody("seda:quotes", "Bad donkey");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("seda:quotes").routeId("quotes")
                        .choice()
                        .when(simple("${body} contains 'Camel'"))
                        .to("seda:camel")
                        .otherwise()
                        .to("seda:other");
            }
        };
    }
}
