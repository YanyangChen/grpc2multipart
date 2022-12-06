package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NettyRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty-http:http://0.0.0.0:8123/foo")
                //.transform().constant("Bye World");
                .log("Message body back in grpc: ${body}")
                .to("log:org.apache.camel.example?level=INFO");
    }
}
