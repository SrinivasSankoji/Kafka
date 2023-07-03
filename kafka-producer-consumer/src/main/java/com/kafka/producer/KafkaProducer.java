package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.dto.User;

@Service
public class KafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	private KafkaTemplate<String, Object> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		logger.info(String.format("Message Sent %s", message));
		kafkaTemplate.send("stringTopic", message);
	}

	public void sendUserDetails(User user) {
		logger.info(String.format("Message Sent %s", user));
		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "jsonTopic").build();
		kafkaTemplate.send(message);
	}
}
