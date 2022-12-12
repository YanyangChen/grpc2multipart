package org.apache.camel.example.springboot.grpc;

import io.netty.buffer.ByteBuf;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.StreamCache;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.converter.stream.InputStreamCache;
import org.apache.camel.examples.CamelHelloRequest;
import org.apache.camel.examples.MimeContentRequest;
import org.apache.camel.model.dataformat.MimeMultipartDataFormat;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@CamelSpringBootTest
@UseAdviceWith
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleHttp2Test {

    @Autowired
    CamelContext context;


    @EndpointInject("mock:start")
    protected MockEndpoint mockStartpoint;

    @EndpointInject("mock:middle")
    protected MockEndpoint mockMiddlepoint;

    @EndpointInject("mock://end")
    protected MockEndpoint mockEnd;

    @EndpointInject("mock:endgrpc")
    protected MockEndpoint mockEndGrpcPoint;

    @Test
    @Order(1)
    public void test1ClientRoute() throws Exception{

        AdviceWith.adviceWith(context, "http2start", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockStartpoint);

        });

        mockStartpoint.allMessages().body().isInstanceOf(String.class);
        mockStartpoint.expectedMinimumMessageCount(1);

        context.start();

        mockStartpoint.assertIsSatisfied();

    }

    @Test
    @Order(2)
    public void test2MiddleRoute() throws Exception{

        AdviceWith.adviceWith(context, "http2middle", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockMiddlepoint);

        });


        mockMiddlepoint.allMessages().body().isNotNull();

        //List<Exchange> list = mockMiddlepoint.getReceivedExchanges();
        //String body = mockMiddlepoint.getReceivedExchanges().get(0).getIn().getBody(String.class);
        //System.out.println("mockMiddlepoint.getReceivedExchanges() + " + body);
        //mockMiddlepoint.allMessages().body().isInstanceOf(Exchange.class);
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("name");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("city");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("Camel");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("London");
        mockMiddlepoint.expectedMinimumMessageCount(1);

        context.start();


        //Assert.assertTrue(mockMiddlepoint.getReceivedExchanges().get(0).getIn().getBody(String.class).contains("London"));
        mockMiddlepoint.assertIsSatisfied();

    }

    @Test
    @Order(3)
    public void test3EndRoute() throws Exception{

        AdviceWith.adviceWith(context, "http2end", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEnd);

        });

//        mockEnd.allMessages().body().isInstanceOf(CamelHelloRequest.class);
        mockEnd.allMessages().body().convertTo(String.class).contains("name: \"Camel\"\n" +"city: \"London\"");
        //mockEnd.allMessages().body().convertTo(String.class).contains("city");
        //mockEnd.allMessages().body().convertTo(String.class).contains("Camel");
        //mockEnd.allMessages().body().convertTo(String.class).contains("London");
        mockEnd.expectedMinimumMessageCount(1);

        context.start();

        mockEnd.assertIsSatisfied();


    }





    @Test
    public void test4EndGrpcRoute() throws Exception {
        AdviceWith.adviceWith(context, "http2endGrpc", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEndGrpcPoint);

        });

        mockEndGrpcPoint.allMessages().body().isInstanceOf(CamelHelloRequest.class);
        mockEndGrpcPoint.expectedMinimumMessageCount(1);



        context.start();
        mockEndGrpcPoint.assertIsSatisfied();
    }

    @Test
    public void test0HTTP2Route() throws Exception{


        //mockEndpoint.expectedBodiesReceived(expectedBody);
        //String expectedBody = "Date: Fri, 9 Dec 2022 10:39:16 +0800 (HKT)\\r\\nMessage-ID: <1559701419.1.1670553556788@debian>\\r\\nMIME-Version: 1.0\\r\\nContent-Type: multipart/mixed; \\r\\n\\tboundary=\\\"----=_Part_0_1925413803.1670553556768\\\"\\r\\n\\r\\n------=_Part_0_1925413803.1670553556768\\r\\nContent-Type: application/octet-stream\\r\\nContent-Transfer-Encoding: binary\\r\\n\\r\\nname: \\\"Camel\\\"\\ncity: \\\"London\\\"\\n\\r\\n------=_Part_0_1925413803.1670553556768--\\r\\n";


        AdviceWith.adviceWith(context, "http2start0", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockStartpoint);

        });

        mockStartpoint.allMessages().body().isInstanceOf(String.class);
        mockStartpoint.expectedMinimumMessageCount(1);


        AdviceWith.adviceWith(context, "http2middle0", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockMiddlepoint);

        });

        //mockMiddlepoint.allMessages().body().isInstanceOf(MimeContentRequest.class);
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("name");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("city");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("Camel");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("London");
        mockMiddlepoint.expectedMinimumMessageCount(1);

        AdviceWith.adviceWith(context, "http2end0", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEnd);

        });

        mockEnd.allMessages().body().isInstanceOf(MimeContentRequest.class);
        mockEnd.expectedMinimumMessageCount(1);


        AdviceWith.adviceWith(context, "http2endGrpc", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEndGrpcPoint);

        });

        mockEndGrpcPoint.allMessages().body().isInstanceOf(CamelHelloRequest.class);
        mockEndGrpcPoint.expectedMinimumMessageCount(1);


        context.start();
        mockStartpoint.assertIsSatisfied();
        mockMiddlepoint.assertIsSatisfied();
        mockEnd.assertIsSatisfied();
        mockEndGrpcPoint.assertIsSatisfied();



    }
}
