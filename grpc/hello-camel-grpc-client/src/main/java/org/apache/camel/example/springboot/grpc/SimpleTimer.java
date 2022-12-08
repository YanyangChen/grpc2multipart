package org.apache.camel.example.springboot.grpc;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleTimer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
            from("timer:simpleTimer?period=1000")
                    .routeId("simpleTimerId")
                    .setBody(constant("HelloWorld from body"))
                    .log(LoggingLevel.INFO,"${body}");
                    //.to("log:first-timer");

    }
}
