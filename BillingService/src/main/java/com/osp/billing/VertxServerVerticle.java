package com.osp.billing;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;


@Component
public class VertxServerVerticle extends AbstractVerticle{

	@Autowired
	private Environment environment;
	
	  @Autowired
	  private RestTemplate restTemplate;
		
	@Override
	public void start() throws Exception {		
		super.start();
		
		try {					
				HttpServer httpServer = vertx.createHttpServer();
				//Main router
				Router router = Router.router(vertx);		
				router.route().handler(BodyHandler.create());			
				router.get("/billing/*").blockingHandler(this::processOrderBilling);        
				httpServer.requestHandler(router::accept).listen(environment.getProperty("server.port", Integer.class)); //use sprint boot configured port
				
				System.out.println("Server Started");			   
				
			}catch (Exception e) {
				e.printStackTrace();
		  }
	}
	
	/*This handler will process the billing/payment of an order*/
	private void processOrderBilling(RoutingContext routingContext) {
		
		HttpServerResponse response = routingContext.response();		
		String orderAmount = routingContext.request().getParam("amount");
		String ordername = routingContext.request().getParam("ordername");
		String creditCardNumber = routingContext.request().getParam("creditcardnumber");
		

		System.out.println("received billing request for order ordername = ="+ordername);
		System.out.println("processing amount = ="+orderAmount);
		System.out.println("processing credit card number = ="+creditCardNumber);
		


		
		//RestTemplate restTemplate = new RestTemplate();
		
		// use the "smart" Eureka-aware RestTemplate
		
		System.out.println("calling order service");
		
        ResponseEntity<String> exchange =
                  restTemplate.exchange("http://order-service/order/",HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>() {
                        });

        System.out.println("order service response = "+exchange.getBody());
        
		JsonObject obj = new JsonObject();
		obj.put("ordername", ordername);
		obj.put("Amount", orderAmount);		
		//obj.put("ProcessingStatus", "Success");	
		obj.put("ProcessingStatus", exchange.getBody());	
		
		routingContext.response()
								.putHeader("content-type", "application/json")
								.setStatusCode(200)
								.end(Json.encodePrettily(obj));

		System.out.println("**************************************************");
	}
}
