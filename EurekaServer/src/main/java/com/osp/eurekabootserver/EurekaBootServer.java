package com.osp.eurekabootserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaServer
public class EurekaBootServer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaBootServer.class, args);
	}

}
