package io.queue.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserQueueServiceApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(UserQueueServiceApplication.class, args);   
	}
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("spring-microservice-example-queue");
	}

}
