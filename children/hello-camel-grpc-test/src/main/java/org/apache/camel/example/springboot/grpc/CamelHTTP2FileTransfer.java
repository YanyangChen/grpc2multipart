package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class CamelHTTP2FileTransfer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input?flatten=true&noop=true")
                //the simulation of netty-http does not support chunkedMaxContentLength option?
                .to("seda:netty-http:http://0.0.0.0:9200/foo");//?chunkedMaxContentLength=20971520

        from("seda:netty-http:http://0.0.0.0:9200/foo")
                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)

                .to("seda:netty-http:http://0.0.0.0:8323/foo");
        from("seda:netty-http:http://0.0.0.0:8323/foo")
                .routeId("httpFIleRoute")
                .unmarshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .to("file:files/output");
    }
}
