package com.osp.billing;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.vertx.core.Vertx;

@SpringBootApplication
@EnableEurekaClient
public class BillingServiceApplication {


  @Autowired
  private VertxServerVerticle vertxServerVerticle;
	

  
	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@PostConstruct
	  public void deployServerVerticle() {
	     Vertx.vertx().deployVerticle(vertxServerVerticle);

	  }
}
