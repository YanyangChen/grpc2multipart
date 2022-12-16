package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;

public class HTTP2NettyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("netty-http:http://0.0.0.0:9501/middle?chunkedMaxContentLength=20971520")
                .routeId("nettyStart")
                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .to("log:org.apache.camel.example?level=INFO")
                .to("netty-http:http://0.0.0.0:8125/foo?chunkedMaxContentLength=20971520")
                .log("Message body back multipart: ${body}");
        // .to("mock:middle");

        from("netty-http:http://0.0.0.0:8125/foo?chunkedMaxContentLength=20971520")
                //.routeId("http2restfulEnd")

                .unmarshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .log("Message headers in ending point: ${headers}")
                .to("mock:end");
    }
}
