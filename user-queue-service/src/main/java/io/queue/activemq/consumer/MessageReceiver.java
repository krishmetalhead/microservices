package io.queue.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
 
	@JmsListener(destination = "spring-microservice-example-queue")
	public void receiveQueue(String text) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("Inside receiveQueue method of MessageReceiver of User Queue Service"); 		
	}
}

