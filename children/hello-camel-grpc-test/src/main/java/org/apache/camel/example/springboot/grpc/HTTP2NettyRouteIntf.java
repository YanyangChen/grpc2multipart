package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;

public class HTTP2NettyRouteIntf extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .routeId("nettyStartIntf")
                .to("netty-http:http://0.0.0.0:9000/foo?chunkedMaxContentLength=20971520");
        // .to("mock:middle");

        from("netty-http:http://0.0.0.0:8123/foo?chunkedMaxContentLength=20971520")

                .to("mock:end");
    }
}
