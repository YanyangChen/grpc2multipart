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
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.examples.CamelHelloRequest;
import org.springframework.stereotype.Component;

/**
 * A simple Camel gRPC route example using Spring-boot
 */
//@Component
public class Multipart2gRPCRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

       // CamelHelloRequest request = CamelHelloRequest.newBuilder().setName("Camel").setCity("HongKong IRD").build();
        from("activemq:my-activemq-queue")
                //.convertBodyTo(CamelHelloRequest.class)

                .process(new Processor() {

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String receivedBody = exchange.getIn().getBody(String.class);
                        log.info("receivedBody is " + receivedBody);

                        //String name = receivedBody.substring(nameIndex,cityIndex-receivedBody.substring(cityIndex).length());
                        String name = receivedBody.substring(nthOccurrence(receivedBody,"\"",3 )+1,nthOccurrence(receivedBody,"\"",4));
                        String city = receivedBody.substring(nthOccurrence(receivedBody,"\"",5 )+1,nthOccurrence(receivedBody,"\"",6));
                        log.info("received Name is " + name);
                        log.info("received City is " + city);
                        CamelHelloRequest request = CamelHelloRequest.newBuilder().setName(name).setCity(city).build();
                        exchange.getIn().setBody(request, CamelHelloRequest.class);
                    }
                })

                .log("Message body back in grpc: ${body}")
    .to("log:org.apache.camel.example?level=INFO");
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
