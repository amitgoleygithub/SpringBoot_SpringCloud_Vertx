package com.osp.billing;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.vertx.core.Vertx;

@SpringBootApplication
@EnableEurekaClient
public class BillingServiceApplication {


  @Autowired
  private VertxServerVerticle vertxServerVerticle;
	  
	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	
	@PostConstruct
	  public void deployServerVerticle() {
	     Vertx.vertx().deployVerticle(vertxServerVerticle);

	  }
}
