package org.apache.camel.example.springboot.grpc;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.converter.stream.InputStreamCache;
import org.apache.camel.examples.CamelHelloRequest;
import org.apache.camel.examples.MimeContentRequest;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.OutputStream;
import java.util.stream.Stream;

@SpringBootTest
@CamelSpringBootTest
@UseAdviceWith
public class SimpleHttp2Test {

    @Autowired
    CamelContext context;


    @EndpointInject("mock:start")
    protected MockEndpoint mockStartpoint;

    @EndpointInject("mock:middle")
    protected MockEndpoint mockMiddlepoint;

    @EndpointInject("mock:result")
    protected MockEndpoint mockEndpoint;

    @Test
    public void testHTTP2Route() throws Exception{


        //mockEndpoint.expectedBodiesReceived(expectedBody);
        //String expectedBody = "Date: Fri, 9 Dec 2022 10:39:16 +0800 (HKT)\\r\\nMessage-ID: <1559701419.1.1670553556788@debian>\\r\\nMIME-Version: 1.0\\r\\nContent-Type: multipart/mixed; \\r\\n\\tboundary=\\\"----=_Part_0_1925413803.1670553556768\\\"\\r\\n\\r\\n------=_Part_0_1925413803.1670553556768\\r\\nContent-Type: application/octet-stream\\r\\nContent-Transfer-Encoding: binary\\r\\n\\r\\nname: \\\"Camel\\\"\\ncity: \\\"London\\\"\\n\\r\\n------=_Part_0_1925413803.1670553556768--\\r\\n";


        AdviceWith.adviceWith(context, "http2start", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockStartpoint);

        });

        mockStartpoint.allMessages().body().isInstanceOf(String.class);



        AdviceWith.adviceWith(context, "http2middle", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockMiddlepoint);

        });

        mockMiddlepoint.allMessages().body().isInstanceOf(String.class);

        AdviceWith.adviceWith(context, "http2end", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEndpoint);

        });

        mockEndpoint.allMessages().body().isInstanceOf(MimeContentRequest.class);
        mockEndpoint.expectedMinimumMessageCount(1);



        context.start();
        mockEndpoint.assertIsSatisfied();

        mockMiddlepoint.assertIsSatisfied();
    }
}
