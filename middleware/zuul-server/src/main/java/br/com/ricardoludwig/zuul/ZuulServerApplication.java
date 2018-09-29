package br.com.ricardoludwig.zuul;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ricardoludwig.zuul.filter.ErrorFilter;
import br.com.ricardoludwig.zuul.filter.PostFilter;
import br.com.ricardoludwig.zuul.filter.PreFilter;
import br.com.ricardoludwig.zuul.filter.RouteFilter;

@Controller
@Configuration
@ComponentScan
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
public class ZuulServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@ResponseBody
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();

	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
