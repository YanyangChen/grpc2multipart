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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

/**
 * A simple Camel gRPC route example using Spring-boot
 */
@Component
public class CamelGrpcRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
	//setup the proto generated object
        //CamelHelloRequest request = CamelHelloRequest.newBuilder().setName("Camel").setCity("London").build();
        MimeContentRequest mrequest = MimeContentRequest.newBuilder().setContent("a protobuff without assumptions").build();
        //NettyServerBootstrapConfiguration nettyHttpBootstrapOptions = new NettyServerBootstrapConfiguration();
        //from uri="netty-http:http://0.0.0.0:{{port}}/foo?bootstrapConfiguration=#nettyHttpBootstrapOptions"

	//setup endpoint and its behavior
        //from("timer://foo?period=5000&repeatCount=1")
        from("file:files/input?flatten=true&noop=true")
//        .process(new Processor() {
//            @Override
//	    //set the body with the object, using the interface with thr object and its type name
//            public void process(Exchange exchange) throws Exception {
//                //exchange.getIn().setBody(request, CamelHelloRequest.class);
//                  exchange.getIn().setBody(mrequest, CamelHelloRequest.class);
//                //exchange.getIn().setBody("This is just a test to ensure garbage in garbage out");
//            }
//
//        })
//                .convertBodyTo(String.class)
                .to("netty-http:http://0.0.0.0:9000/foo?chunkedMaxContentLength=20971520");

    }

}
