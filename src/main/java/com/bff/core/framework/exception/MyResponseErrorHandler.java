package com.bff.core.framework.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class MyResponseErrorHandler implements ResponseErrorHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyResponseErrorHandler.class);
	   
	    @Override
	    public void handleError(ClientHttpResponse response) throws IOException {
	    	LOGGER.error("Response error: {} {}", response.getStatusCode(), response.getBody());
	    }

	    @Override
	    public boolean hasError(ClientHttpResponse response) throws IOException {
	        return RestUtil.isError(response.getStatusCode());
	    }
}
