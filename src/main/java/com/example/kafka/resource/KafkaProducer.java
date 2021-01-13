package com.example.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("kafka")
public class KafkaProducer {
	
	private static final String TOPIC = "example";
	
	@Autowired
	private KafkaTemplate<String,String> template;
	
	@GetMapping("/publish/{message}")
	public String publish(@PathVariable String message) {
		
		template.send(TOPIC, message);
		return "Published message";
	}
}
