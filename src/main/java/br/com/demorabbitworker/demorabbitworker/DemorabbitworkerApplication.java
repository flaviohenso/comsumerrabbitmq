package br.com.demorabbitworker.demorabbitworker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemorabbitworkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemorabbitworkerApplication.class, args);
	}

}
