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
                .unmarshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .log("Message body unmarshal multipart: ${body}");

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
