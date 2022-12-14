package org.apache.camel.example.springboot.grpc;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.examples.CamelHelloRequest;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CamelHTTP2RestfulRoute extends RouteBuilder {

    @Autowired
    private Environment env;

    @Override
    public void configure() throws Exception {

        /*restConfiguration()
                .component("servlet")
                .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .port(env.getProperty("server.port", "8080"))
                .bindingMode(RestBindingMode.json);

        rest("/books").description("Books REST service")
                .get("/").description("The list of all the books").to("direct:books")
                .get("order/{id}").description("Details of an order by id").to("direct:order");
        //from("timer://foo?period=5000&repeatCount=1")*/

        /*restConfiguration().component("jetty").host("0.0.0.0").port(8080).bindingMode(RestBindingMode.json).enableCORS(true);

        rest("masterclass")
                .produces("application/json")
                .description("Books REST service")
                .post("/").description("The list of all the books")
                .to("log:org.apache.camel.restFulEnd?level=INFO");*/
        restConfiguration().component("jetty").host("0.0.0.0").port(8080).bindingMode(RestBindingMode.json).enableCORS(true);
        from("direct:start")
                .to("rest:get:hello/{me}");
        from("rest:get:hello/{me}")
                .transform().simple("Hi ${header.me}")
                .to("direct:order");
        from("direct:order")
                .routeId("restStartRoute")
                .log("Message body in rest: ${body}")
                .log("Message headers in rest: ${headers}")

                .convertBodyTo(String.class)

                .to("log:org.apache.camel.example?level=INFO")
                .wireTap("seda:netty-http:http://0.0.0.0:9501/middle");
        // .to("mock:start");


        from("seda:netty-http:http://0.0.0.0:9501/middle")


                .marshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)
                .to("log:org.apache.camel.example?level=INFO")
                .to("seda:netty-http:http://0.0.0.0:8125/foo")
                .log("Message body back multipart: ${body}");
        // .to("mock:middle");

        from("seda:netty-http:http://0.0.0.0:8125/foo")
                .routeId("http2restfulEnd")
                /*.process(exchange -> {
                    String receivedBody = exchange.getIn().getBody(String.class);
                    log.info("receivedBody is " + exchange.getIn().getBody().getClass().getName());



                   *//* MimeContentRequest request2 = MimeContentRequest.newBuilder().setContent(receivedBody).build();
                    exchange.getIn().setBody(request2, MimeContentRequest.class);*//*
                    //log.info("Message body back in grpc " + exchange.getIn().getBody());
                })*/
                //try unmarshal
                .unmarshal()
                .mimeMultipart("mixed", true, true, "(included|x-.*)", true)

                // .convertBodyTo(String.class)

                .log("Message headers in ending grpc: ${headers}");

                //.to("mock:restfulEnd");

    }
}
