package br.com.ricardoludwig.catalog;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Configuration
@ComponentScan
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
public class CatalogServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CatalogServerApplication.class, args);
	}

	@ResponseBody
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
}
