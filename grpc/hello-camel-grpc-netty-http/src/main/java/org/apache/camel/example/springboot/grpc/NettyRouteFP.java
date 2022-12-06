package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class NettyRouteFP  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty-http:http://0.0.0.0:8123/foo")
                //.transform().constant("Bye World");
                .log("Message body back in grpc: ${body}")

                .to("activemq:my-activemq-grpc2Str")

                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                //.mimeMultipart()
                //front plat netty end

                //send to another netty server
                //.to("netty-http:http://0.0.0.0:8123/foo") //send to assumed netty server port 8123
                .log("Message body back in multipart: ${body}")
                .to("activemq:my-activemq-queue");
    }
}
