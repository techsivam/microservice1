/**
 * 
 */
package com.microservice1.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice1.model.ContentMetadata;
import com.microservice1.service.Microservice1Service;

/**
 * @author sivprakash
 *
 */
@RestController
@RequestMapping("contentMetadata")
public class Microservice1Controller {

	private Microservice1Service service;

	public Microservice1Controller(Microservice1Service service) {

		this.service = service;

	}

	@RequestMapping(value = "/content", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ContentMetadata> getContentDetails(@RequestParam("id") final String id) {
		// ContentMetadata cm = new ContentMetadata();
		// if (id != null) {
		// cm.setAssetId(id);
		// cm.setHttpStatus(HttpStatus.OK);
		// } else {
		// cm.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
		// }
		System.out.println(id);
		ContentMetadata cm = service.getContentDetails(id);
		return new ResponseEntity<>(cm, cm.getHttpStatus());
	}

	@RequestMapping(value = "/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ContentMetadata> getGroupDetails(@RequestParam("id") final String id) {

		/*
		 * ContentMetadata cm = new ContentMetadata(); if (id != null) {
		 * cm.setAssetId(id); cm.setHttpStatus(HttpStatus.OK); } else {
		 * cm.setHttpStatus(HttpStatus.NOT_ACCEPTABLE); }
		 */
		ContentMetadata cm = service.getGroupDetails(id);
		return new ResponseEntity<>(cm, cm.getHttpStatus());
	}
}
