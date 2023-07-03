package com.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

	@Bean
	public NewTopic stringTopic() {
		return TopicBuilder.name("stringTopic").build();
	}
	
	@Bean
	public NewTopic jsonTopic() {
		return TopicBuilder.name("jsonTopic").build();
	}
}
