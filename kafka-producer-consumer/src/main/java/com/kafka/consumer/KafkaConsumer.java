package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.dto.User;
import com.kafka.producer.KafkaProducer;

@Service
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	
	@KafkaListener(topics = "stringTopic", groupId = "employee")
	public void consume(String message) {
		logger.info(String.format("Message from Producer %s", message));
	}
	
	@KafkaListener(topics = "jsonTopic", groupId = "employee")
	public void consume(User user) {
		logger.info(String.format("Message from Producer %s", user.toString()));
	}
}
