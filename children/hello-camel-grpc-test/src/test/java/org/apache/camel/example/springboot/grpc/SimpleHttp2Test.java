package org.apache.camel.example.springboot.grpc;

import io.netty.buffer.ByteBuf;
import org.apache.camel.*;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.converter.stream.InputStreamCache;
import org.apache.camel.examples.CamelHelloRequest;
import org.apache.camel.examples.MimeContentRequest;
import org.apache.camel.impl.DefaultCamelContext;
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

    @EndpointInject("mock:end")
    protected MockEndpoint mockEnd;

    @EndpointInject("mock:ends")
    protected MockEndpoint mockEnds;

    @EndpointInject("mock:restfulEnd")
    protected MockEndpoint mockRestfulEnd;

    @EndpointInject("mock:restfulStart")
    protected MockEndpoint mockRestfulStart;

    @EndpointInject("mock:fileStart")
    protected MockEndpoint mockFileStart;

    @EndpointInject("mock:fileEnd")
    protected MockEndpoint mockFileEnd;

    @EndpointInject("mock:endgrpc")
    protected MockEndpoint mockEndGrpcPoint;

    @Autowired
    ProducerTemplate template;

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

        mockEnd.allMessages().body().convertTo(String.class).contains("name: \"Camel\"\n" +"city: \"London\"");
        mockEnd.expectedMinimumMessageCount(1);

        context.start();

        mockEnd.assertIsSatisfied();

    }

    @Test
    @Order(8)
    public void test8EndRouteResponse() throws Exception{

        AdviceWith.adviceWith(context, "http2endResponse", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEnd);

        });

        mockEnd.allMessages().body().convertTo(String.class).contains("name: \"Camel\"\n" +"city: \"London\"");
        mockEnd.expectedMinimumMessageCount(1);

        context.start();

        mockEnd.assertIsSatisfied();

    }







    @Test
    @Order(4)
    public void test4EndGrpcRoutePOC() throws Exception {
        AdviceWith.adviceWith(context, "http2endGrpc", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockEndGrpcPoint);

        });

        mockEndGrpcPoint.allMessages().body().isInstanceOf(CamelHelloRequest.class);
        mockEndGrpcPoint.expectedMinimumMessageCount(1);



        context.start();
        mockEndGrpcPoint.assertIsSatisfied();
    }

    @Test
    @Order(5)
    public void test5FileRoute() throws Exception {
        AdviceWith.adviceWith(context, "httpFIleRoute", routeBuilder ->{
            routeBuilder.weaveAddLast().to(mockFileEnd);

        });

        //mockEndGrpcPoint.allMessages().body().isInstanceOf(CamelHelloRequest.class);
        mockFileEnd.expectedMinimumMessageCount(1);



        context.start();
        mockFileEnd.assertIsSatisfied();
    }

    @Test
    @Order(7)
    public void test0HTTP2RoutePOC() throws Exception{


        //mockEndpoint.expectedBodiesReceived(expectedBody);
        //String expectedBody = "Date: Fri, 9 Dec 2022 10:39:16 +0800 (HKT)\\r\\nMessage-ID: <1559701419.1.1670553556788@debian>\\r\\nMIME-Version: 1.0\\r\\nContent-Type: multipart/mixed; \\r\\n\\tboundary=\\\"----=_Part_0_1925413803.1670553556768\\\"\\r\\n\\r\\n------=_Part_0_1925413803.1670553556768\\r\\nContent-Type: application/octet-stream\\r\\nContent-Transfer-Encoding: binary\\r\\n\\r\\nname: \\\"Camel\\\"\\ncity: \\\"London\\\"\\n\\r\\n------=_Part_0_1925413803.1670553556768--\\r\\n";


        AdviceWith.adviceWith(context, "http2starts", routeBuilder ->{
            //routeBuilder.weaveAddLast().to(mockStartpoint);
            routeBuilder.weaveByToUri("mock:start").replace().to(mockStartpoint);

        });

        mockStartpoint.allMessages().body().isInstanceOf(String.class);
        mockStartpoint.expectedMinimumMessageCount(1);


        AdviceWith.adviceWith(context, "http2middles", routeBuilder ->{
            routeBuilder.weaveByToUri("mock:middle").replace().to(mockMiddlepoint);

        });

        //mockMiddlepoint.allMessages().body().isInstanceOf(MimeContentRequest.class);
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("name");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("city");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("Camel");
        mockMiddlepoint.allMessages().body().convertTo(String.class).contains("London");
        mockMiddlepoint.expectedMinimumMessageCount(1);

        AdviceWith.adviceWith(context, "http2ends", routeBuilder ->{
            routeBuilder.weaveByToUri("mock:ends").replace().to(mockEnds);

        });

        //mockEnd.allMessages().body().isInstanceOf(MimeContentRequest.class);
        mockEnd.expectedMinimumMessageCount(1);


        AdviceWith.adviceWith(context, "http2endGrpcs", routeBuilder ->{
            routeBuilder.weaveByToUri("mock:endgrpc").replace().to(mockEndGrpcPoint);

        });

        mockEndGrpcPoint.allMessages().body().isInstanceOf(CamelHelloRequest.class);
        mockEndGrpcPoint.expectedMinimumMessageCount(1);


        context.start();
        mockStartpoint.assertIsSatisfied();
        mockMiddlepoint.assertIsSatisfied();
        mockEnds.assertIsSatisfied();
        mockEndGrpcPoint.assertIsSatisfied();



    }

    @Test
    @Order(6)
    public void test6RestFulEndRoute() throws Exception{
        //CamelContext camelcontext = new DefaultCamelContext();
        //ProducerTemplate template = context.createProducerTemplate();

        System.out.println("template.sendBodyAndHeader is "+template);
        AdviceWith.adviceWith(context, "restStartRoute", routeBuilder ->{
            routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to(mockRestfulStart);

        });
        // mockRestfulStart.expectedMinimumMessageCount(1);

        AdviceWith.adviceWith(context, "http2restfulEnd", routeBuilder ->{
            //routeBuilder.replaceFromWith("direct:mockStart");
            routeBuilder.weaveAddLast().to(mockRestfulEnd);

        });
        mockRestfulEnd.expectedMinimumMessageCount(1);

        context.start();
        template.sendBodyAndHeader("direct:mockStart", "testing_body", "test", "Restful Header");
        mockRestfulStart.assertIsSatisfied();
        mockRestfulEnd.assertIsSatisfied();
    }
}
