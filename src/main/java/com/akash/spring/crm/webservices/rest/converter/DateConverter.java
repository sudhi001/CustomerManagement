package com.akash.spring.crm.webservices.rest.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DateConverter extends ObjectMapper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateConverter() {
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
}
