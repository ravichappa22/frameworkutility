package com.bff.core.framework.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class HttpServiceException extends ServiceException {
	
	private HttpStatus responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	private Map<String,Object> detailMap = new HashMap<>();
	private long timestamp = (new Date()).getTime();
	private String code;

    public HttpServiceException(String message) {
        super(message);
    }

    public HttpServiceException(String message, HttpStatus status) {
        super(message);
        this.responseStatus = status;
    }

    public HttpServiceException(String message, Map<String, Object> details) {
    	super(message);
    	this.detailMap=details;
    }

    public HttpServiceException(String message, Map<String, Object> details, HttpStatus status) {
    	super(message);
    	this.detailMap=details;
        this.responseStatus = status;
    }

    public HttpServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpServiceException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.responseStatus = status;
    }

    public HttpServiceException(String message, Throwable cause, Map<String, Object> details) {
    	super(message,cause);
    	this.detailMap=details;
    }

    public HttpServiceException(String message, Throwable cause, Map<String, Object> details, HttpStatus status) {
    	super(message,cause);
    	this.detailMap=details;
        this.responseStatus = status;
    }

    public HttpServiceException(Throwable cause) {
        super(cause);
    }

    public HttpServiceException(Throwable cause, HttpStatus status) {
        super(cause);
        this.responseStatus = status;
    }

    public HttpServiceException(Throwable cause, Map<String, Object> details) {
    	super(cause);
    	this.detailMap=details;
    }
    
    public HttpServiceException(Throwable cause, Map<String, Object> details, HttpStatus status) {
        super(cause);
        this.detailMap=details;
        this.responseStatus = status;
    }
    /**
     * @return The status code to use for any REST response resulting from the exception.
     */
    public HttpStatus getStatus() {
        return this.responseStatus;
    }

    /**
     * @param status The status code to use for any REST response resulting from the exception.
     */
    public void setStatus(HttpStatus status) {
        this.responseStatus = (status==null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

}
