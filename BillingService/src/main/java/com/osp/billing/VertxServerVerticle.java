package com.osp.billing;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

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
		String orderID = routingContext.request().getParam("orderid");
		String creditCardNumber = routingContext.request().getParam("creditcardnumber");
		

		System.out.println("received billing request for order number = ="+orderID);
		System.out.println("processing amount = ="+orderAmount);
		System.out.println("processing credit card number = ="+creditCardNumber);
		

		JsonObject obj = new JsonObject();
		obj.put("OrderID", orderID);
		obj.put("Amount", orderAmount);		
		obj.put("ProcessingStatus", "Success");	
		

		routingContext.response()
								.putHeader("content-type", "application/json")
								.setStatusCode(200)
								.end(Json.encodePrettily(obj));

		System.out.println("**************************************************");
	}
}
