package com.spring.cloudamqp.producer.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloudamqp.SimpleMessageDto;

@RestController
public class RabbitMqProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/publish")
	public ResponseEntity < String > postMessage(@RequestBody SimpleMessageDto message) {
		
		rabbitTemplate.convertAndSend("TopicExchange", "topic",message);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hi!, I am working";
	}
	
}
