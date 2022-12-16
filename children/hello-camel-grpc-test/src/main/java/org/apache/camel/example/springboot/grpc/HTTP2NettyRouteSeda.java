package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;

public class HTTP2NettyRouteSeda extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("seda:netty-http:http://0.0.0.0:9501/middle")
                .routeId("nettyStart")
                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .to("log:org.apache.camel.example?level=INFO")
                .to("seda:netty-http:http://0.0.0.0:8125/foo")
                .log("Message body back multipart: ${body}");
        // .to("mock:middle");

        from("seda:netty-http:http://0.0.0.0:8125/foo")
                //.routeId("http2restfulEnd")

                .unmarshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .log("Message headers in ending point: ${headers}")
                .to("mock:end");
    }
}
