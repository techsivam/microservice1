/**
 * 
 */
package com.microservice1.service;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice1.model.ContentMetadata;

/**
 * @author sivpraka
 *
 */
@Service
public class Microservice1Service {

	public ContentMetadata getContentDetails(String id) {
		ContentMetadata cm = new ContentMetadata();
		if (id != null) {
			cm.setAssetId(id);
			cm.setHttpStatus(HttpStatus.OK);
		} else {
			cm.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
		}
		return cm;
	}
	public ContentMetadata getGroupDetails(String id) {
		ContentMetadata cm = new ContentMetadata();
		StringBuffer location = new StringBuffer("classpath:contentetadata/");
		location.append("failure_response.json");
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourceResolver.getResource(location.toString());
		String string = null;
		try {
			 string = IOUtils.toString(resource.getInputStream());
		} catch (IOException ioe) {
		}
		
		if (id != null) {
			cm.setAssetId(id);
			//cm.setResponseObject(string);
			Object object=new Object();
			object=123456;
			cm.setResponseObject(object);
			
			cm.setHttpStatus(HttpStatus.OK);
		} else {
			cm.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
		}
		return cm;
	}
}
