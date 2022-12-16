package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;

public class FileEntryRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input?flatten=true&noop=true")
                .routeId("httpFIleRoute")
                //the simulation of netty-http does not support chunkedMaxContentLength option?
                .to("seda:netty-http:http://0.0.0.0:9200/foo");//?chunkedMaxContentLength=20971520
    }
}
