package com.mail.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mail.send.service.OrderService;

@SpringBootApplication
public class EmailsenderAppApplication {

	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(EmailsenderAppApplication.class, args);
	//get service class object
	OrderService service = ctx.getBean("orderService",OrderService.class);
	//invoke method
	try {
	System.out.println(service.orderdetails(new float[] {10000.0f, 12000.0f, 20000.0f}
	,new String[] {	"fan","frige","tv"},
			new String[] {"tomsmith03242@gmail.com","er.suniltomar@yahoo.com","spring716am@gmail.com",
					"dssunilsingh@gmail.com","unanimous03242@gmail.com"})
	);
	
	}catch(Exception e) {
		e.printStackTrace();
	}
}}
