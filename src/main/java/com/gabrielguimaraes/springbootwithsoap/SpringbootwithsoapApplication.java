package com.gabrielguimaraes.springbootwithsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootwithsoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithsoapApplication.class, args);

		System.out.println("============================================================================");
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
		System.out.println("--------------------------> O SERVIÇO ESTÁ DE PÉ <--------------------------");
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
		System.out.println("============================================================================");
	}

}
