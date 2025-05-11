package com.auth2.client.app.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth2.client.app.models.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AppController {

	@GetMapping("/list")
	public List<Message> get() {

		return Collections.singletonList(new Message("Test list"));
	}

	@PostMapping("/create")
	public Message postMethodName(@RequestBody Message entity) {
		System.out.println("saved message");
		return entity;
	}

	public Map<String, String> authorized(@RequestParam String code) {
		return Collections.singletonMap("code", "code");
	}

}
