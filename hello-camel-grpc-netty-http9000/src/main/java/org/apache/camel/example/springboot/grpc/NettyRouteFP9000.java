package org.apache.camel.example.springboot.grpc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NettyRouteFP9000  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty-http:http://0.0.0.0:9000/foo?chunkedMaxContentLength=20971520")
                //.transform().constant("Bye World");
                //.log("Message Head grpc: ${headers}")

                //.to("activemq:my-activemq-grpc2Str")

                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                //.mimeMultipart()
                //front plat netty end

                //send to another netty server
                //.to("netty-http:http://0.0.0.0:8123/foo") //send to assumed netty server port 8123
                //.log("Message body back in multipart: ${body}")
                .to("netty-http:http://0.0.0.0:8123/foo?chunkedMaxContentLength=20971520");
                //.log("Message body in multipart: ${body}")
                //.log("Message body in multipart header: ${headers}");
                //.to("activemq:my-activemq-queue");
    }
}
