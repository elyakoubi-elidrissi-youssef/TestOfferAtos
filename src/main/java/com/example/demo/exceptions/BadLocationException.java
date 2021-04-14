package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadLocationException extends Exception {
	public BadLocationException() {
		super("vous n'êtes pas un français !");
	}
}
