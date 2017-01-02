package com.microservice1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.microservice1.controller.Microservice1Controller;
import com.microservice1.model.ContentMetadata;
import com.microservice1.service.Microservice1Service;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = Microservice1Application.class)
public class Microservice1ApplicationTests {

	@Mock
	Microservice1Service service;
	@Mock
	ContentMetadata contentMetadata;

	@Mock
	ContentMetadata contentMetadataGroup;
	@Before
	public void setup() {
		//contentMetadata.setHttpStatus(HttpStatus.OK);
		contentMetadata=new ContentMetadata();
		contentMetadata.setHttpStatus(HttpStatus.OK);
		contentMetadata.setAssetId("id10");
		//BDDMockito.given(contentMetadata.getHttpStatus()).willReturn(HttpStatus.OK);
		//BDDMockito.given(service.getContentDetails(BDDMockito.anyString())).willReturn(contentMetadata);
		BDDMockito.given(service.getContentDetails(BDDMockito.anyString())).willReturn(contentMetadata);
		
		StringBuffer location = new StringBuffer("classpath:contentetadata/");
		location.append("failure_response.json");
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourceResolver.getResource(location.toString());
		String string = null;
		try {
			 string = IOUtils.toString(resource.getInputStream());
		} catch (IOException ioe) {
		}
		
		contentMetadataGroup=new ContentMetadata();
		contentMetadataGroup.setHttpStatus(HttpStatus.OK);
		contentMetadata.setAssetId("id10");
		Object object=new Object();
		object=123456;
		contentMetadataGroup.setResponseObject(object);
		BDDMockito.given(service.getGroupDetails(BDDMockito.anyString())).willReturn(contentMetadataGroup);
		
		
		RestAssuredMockMvc.standaloneSetup(new Microservice1Controller(service));
	}

	
	protected void  isProperCorrelationId(Object correlationId) {
		Object correlationIdl=new Object();
		correlationIdl=123456;
		assertEquals(correlationId, correlationIdl);
		//assert correlationId == correlationIdl;
	}

	protected void comapreTextOutput(Object res, String expected){
        String result = res.toString();
        assertEquals(expected, result);
    }
	
	@Test
	public void contextLoads() {
	}

}
