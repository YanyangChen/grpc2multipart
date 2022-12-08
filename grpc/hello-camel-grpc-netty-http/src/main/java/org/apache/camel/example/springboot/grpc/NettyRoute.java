package org.apache.camel.example.springboot.grpc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.StreamCache;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.stream.StreamCacheConverter;
import org.apache.camel.examples.CamelHelloRequest;
import org.apache.camel.examples.MimeContentRequest;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;



@Component
public class NettyRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty-http:http://0.0.0.0:8123/foo")
                //.log("Message body back in multipart: ${body}") //multipart once logged the body will be empty
                //.convertBodyTo(String.class)
		//
		//
		//
		//
		//convert to a more generic grpc type then send to server
		//not convert directly to the ending type, that's black box's job
                .process(exchange -> {
                    String receivedBody = exchange.getIn().getBody(String.class);

                   // log.info("Message body back in multipart " + receivedBody);

                    MimeContentRequest request = MimeContentRequest.newBuilder().setContent(receivedBody).build();
                    exchange.getIn().setBody(request, MimeContentRequest.class);
                    log.info("Message body back in grpc " + exchange.getIn().getBody());
                })
                //.to("seda:netty-http:http://0.0.0.0:8124/foo")
                //.log("Message body back in grpc: ${body}")
                .to("log:org.apache.camel.example?level=INFO");

                /*from("seda:netty-http:http://0.0.0.0:8124/foo")
                .process(exchange -> {
                    String receivedBody = exchange.getIn().getBody(String.class);

                    log.info("Message body back in multipart " + receivedBody);

                    //String name = receivedBody.substring(nameIndex,cityIndex-receivedBody.substring(cityIndex).length());
                    String name = receivedBody.substring(nthOccurrence(receivedBody,"\"",3 )+1,nthOccurrence(receivedBody,"\"",4));
                    String city = receivedBody.substring(nthOccurrence(receivedBody,"\"",5 )+1,nthOccurrence(receivedBody,"\"",6));
                    log.info("received Name is " + name);
                    log.info("received City is " + city);
                    CamelHelloRequest request = CamelHelloRequest.newBuilder().setName(name).setCity(city).build();
                    exchange.getIn().setBody(request, CamelHelloRequest.class);
                })

                .log("Message body back in grpc: ${body}")
                .to("log:org.apache.camel.example?level=INFO") ;*/
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
