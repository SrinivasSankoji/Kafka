package com.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.User;
import com.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

	private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

	private KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		kafkaProducer.sendMessage(message);
		logger.info(String.format("Message Sent %s", message));
		return ResponseEntity.ok("Message Sent to the employee Topic");
	}

	@PostMapping("/sendUserDetails")
	public ResponseEntity<String> sendUserDetails(@RequestBody User user) {
		kafkaProducer.sendUserDetails(user);
		logger.info(String.format("Message Sent %s", user));
		return ResponseEntity.ok("Message Sent to the employee Topic");
	}

}
