package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import demo.controller.EmployeeController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class DemoEurekaWithMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaWithMySqlApplication.class, args);
	}

}
