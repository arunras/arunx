package com.arunx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arunx.model.Message;

@RestController
public class MessageController {

	@GetMapping("/message")
	public Message sent() {
		return new Message("First message");
	}
	
	@PostMapping("/message")
	public Message echo(@RequestBody Message message) {
		return message;
	}
}
