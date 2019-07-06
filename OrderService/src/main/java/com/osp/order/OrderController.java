package com.osp.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class OrderController {

    
	@GetMapping("/order")
	public String processOrder(@RequestParam(name="ordername", required=false) String ordername) {
		
		System.out.println("order "+ordername +"successfully processed");;
		return "order "+ordername +"successfully processed";
	}
}
