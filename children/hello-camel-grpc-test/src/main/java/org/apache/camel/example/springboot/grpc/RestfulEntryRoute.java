package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class RestfulEntryRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").host("0.0.0.0").port(8080).bindingMode(RestBindingMode.json).enableCORS(true);
        from("direct:start")
                .to("rest:get:hello/{test}");
        from("rest:get:hello/{test}")
                .transform().simple("Hi ${header.test} + ${body}")
                .routeId("restStartRoute")
                .log("Message body in rest: ${body}")
                .log("Message headers in rest: ${headers}")

                //.convertBodyTo(String.class)

                .to("log:org.apache.camel.example?level=INFO")
                .wireTap("seda:netty-http:http://0.0.0.0:9501/middle");
    }
}
