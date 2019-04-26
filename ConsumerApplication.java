package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.controller.ConsControler2;
import com.controller.ControllerZuul;
import com.controller.RibbonControler;

@SpringBootApplication
@ComponentScan({"com.*"})
public class ConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(ConsumerApplication.class, args);
		/*ConsumerController consumer = ioc.getBean(ConsumerController.class);
		consumer.fetchEmp();*/
		
		/*ConsControler2 consumer = ioc.getBean(ConsControler2.class);
		consumer.getEmpDetails();*/
		
		/*ControllerZuul consumer = ioc.getBean(ControllerZuul.class);
		consumer.fetchEmp();*/
		
		RibbonControler consumer = ioc.getBean(RibbonControler.class);
		consumer.fetchEmp();
		
	}

}
