package br.com.ricardoludwig.quotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class QuotaionApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotaionApplication.class, args);
	}
}
