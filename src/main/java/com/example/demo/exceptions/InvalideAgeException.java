package com.example.demo.exceptions;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalideAgeException extends Exception {
	public InvalideAgeException() {
		super("L'âge minimum requis est 18 ans ! ");
	}

}
