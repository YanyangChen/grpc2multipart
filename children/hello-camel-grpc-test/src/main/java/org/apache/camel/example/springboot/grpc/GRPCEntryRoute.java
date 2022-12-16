package org.apache.camel.example.springboot.grpc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.netty.NettyServerBootstrapConfiguration;
import org.apache.camel.examples.CamelHelloRequest;

public class GRPCEntryRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CamelHelloRequest request = CamelHelloRequest.newBuilder().setName("Camel").setCity("London").build();

        NettyServerBootstrapConfiguration nettyHttpBootstrapOptions = new NettyServerBootstrapConfiguration();
        //from uri="netty-http:http://0.0.0.0:{{port}}/foo?bootstrapConfiguration=#nettyHttpBootstrapOptions"

        //setup endpoint and its behavior
        from("timer://foo?period=5000&repeatCount=1")
                .routeId("grpcStarter")
                .process(new Processor() {
                    @Override
                    //set the body with the object, using the interface with thr object and its type name
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setBody(request, CamelHelloRequest.class);
                    }
                })
                .log("Message body in grpc: ${body}")
                .log("Message headers in grpc: ${headers}")
                .convertBodyTo(String.class)

                .to("log:org.apache.camel.example?level=INFO"); //INFO org.apache.camel.example
    }
}
