/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.springboot.grpc;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.netty.NettyServerBootstrapConfiguration;
import org.apache.camel.examples.CamelHelloRequest;
import org.apache.camel.examples.MimeContentRequest;
import org.springframework.stereotype.Component;

/**
 * A simple Camel gRPC route example using Spring-boot
 */
//@Component
public class CamelHTTP2EndGrpc extends RouteBuilder {


    @Override
    public void configure() throws Exception {
	//setup the proto generated object
        CamelHelloRequest request = CamelHelloRequest.newBuilder().setName("Camel").setCity("London").build();

        NettyServerBootstrapConfiguration nettyHttpBootstrapOptions = new NettyServerBootstrapConfiguration();
        //from uri="netty-http:http://0.0.0.0:{{port}}/foo?bootstrapConfiguration=#nettyHttpBootstrapOptions"

	//setup endpoint and its behavior
        from("timer://foo?period=5000&repeatCount=1")
                .routeId("http2start0")
                .process(new Processor() {
            @Override
	    //set the body with the object, using the interface with thr object and its type name
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(request, CamelHelloRequest.class);
                
            }

        })
                .log("Message body in grpc: ${body}")
                .to("activemq:my-activemq-grpc")
                .convertBodyTo(String.class)

                .setExchangePattern(ExchangePattern.InOut)
                //.to("netty-http:http://0.0.0.0:9000/foo");
                //.to("log:org.apache.camel.example?level=INFO")
                //.wireTap("mock:start")
                .log("Message body after grpc: ${body}")
                .wireTap("seda:grpc://0.0.0.0:19500/middle");



        from("seda:grpc://0.0.0.0:19500/middle")

                .routeId("http2middle0")
                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                //.to("log:org.apache.camel.example?level=INFO")
                .log("Message body after multipart: ${body}")
                .wireTap("seda:netty-http:http://0.0.0.0:18123/foo");
                //.wireTap("mock:middle")
                //.log("Message body back multipart: ${body}");
               // ;

        from("seda:netty-http:http://0.0.0.0:18123/foo")
                .routeId("http2end0")
                .process(exchange -> {
                    String receivedBody = exchange.getIn().getBody(String.class);
                    log.info("receivedBody is " + exchange.getIn().getBody());
                    MimeContentRequest request2 = MimeContentRequest.newBuilder().setContent(receivedBody).build();
                    exchange.getIn().setBody(request2, MimeContentRequest.class);
                    log.info("Message body back in grpc " + exchange.getIn().getBody());
                })
                //.to("mock:end")
                .wireTap("seda:netty-http:http://0.0.0.0:18124/foo");
                //.wireTap("mock:end");

        from("seda:netty-http:http://0.0.0.0:18124/foo")
                .routeId("http2endGrpc")
                .process(exchange -> {
                    MimeContentRequest mq= exchange.getIn().getBody(MimeContentRequest.class);
                    String receivedBody = mq.getContent();

                    //String receivedBody = exchange.getIn().getBody(String.class);

                    log.info("Message body back in multipart " + receivedBody);

                    //String name = receivedBody.substring(nameIndex,cityIndex-receivedBody.substring(cityIndex).length());
                    String name = receivedBody.substring(nthOccurrence(receivedBody,"\"",3 )+1,nthOccurrence(receivedBody,"\"",4));
                    String city = receivedBody.substring(nthOccurrence(receivedBody,"\"",5 )+1,nthOccurrence(receivedBody,"\"",6));
                    log.info("received Name is " + name);
                    log.info("received City is " + city);
                    CamelHelloRequest requestEnd = CamelHelloRequest.newBuilder().setName(name).setCity(city).build();
                    exchange.getIn().setBody(requestEnd, CamelHelloRequest.class);
                });

                //.log("Message body back in grpc: ${body}")
                //.to("mock:endgrpc");
                //.to("seda:netty-http:http://0.0.0.0:8124/foo");

    }

    public int nthOccurrence(String str1, String str2, int n) {

        String tempStr = str1;
        int tempIndex = -1;
        int finalIndex = 0;
        for(int occurrence = 0; occurrence < n ; ++occurrence){
            tempIndex = tempStr.indexOf(str2);
            if(tempIndex==-1){
                finalIndex = 0;
                break;
            }
            tempStr = tempStr.substring(++tempIndex);
            finalIndex+=tempIndex;
        }
        return --finalIndex;
    }

}
