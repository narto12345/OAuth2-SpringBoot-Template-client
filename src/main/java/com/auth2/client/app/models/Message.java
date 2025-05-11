package com.auth2.client.app.models;

public class Message {

	private String text;

	public Message() {
		super();
	}

	public Message(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
