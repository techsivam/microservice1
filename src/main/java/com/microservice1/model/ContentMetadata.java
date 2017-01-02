package com.microservice1.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ContentMetadata {

	private HttpStatus httpStatus;
	private String assetId;
	private Object responseObject;

}
