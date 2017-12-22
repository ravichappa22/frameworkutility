package com.bff.core.framework.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ValidationServiceException extends HttpServiceException implements Iterable<ServiceMessage> {
	private List<ServiceMessage> validationMsgs = new ArrayList<>();
    /**
     *
     * @param message The main message for the client.
     */
    public ValidationServiceException(String message) {
        super(message);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
 
    /**
     *
     * @param message The main message for the client.
     * @param validationMessage
     */
    public ValidationServiceException(String message, ServiceMessage validationMessage) {
        super(message);
        this.addValidationMessage(validationMessage);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
 
    public ValidationServiceException(String message, ServiceMessage...validationMessages) {
        super(message);
        this.addValidationMessages(validationMessages);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
 
    /**
     *
     * @param message The main message for the client.
     * @param validationMessages
     */
    public ValidationServiceException(String message, List<ServiceMessage> validationMessages) {
        super(message);
        this.addValidationMessages(validationMessages);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
 
    /**
     *
     * @param message The main message for the client.
     * @param details
     */
    public ValidationServiceException(String message, Map<String,Object> details) {
        super(message);
        this.setDetails(details);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
   
    
 
    public void addValidationMessage(ServiceMessage message) {
        if(message!=null) {
            this.validationMsgs.add(message);
        }
    }
 
    public void addValidationMessages(ServiceMessage...messages) {
        if(messages!=null) {
            for(ServiceMessage msg : messages) {
                this.addValidationMessage(msg);
            }
        }
    }
 
    public void addValidationMessages(List<ServiceMessage> msgList) {
        if(msgList!=null) {
            for(ServiceMessage msg : msgList) {
                this.addValidationMessage(msg);
            }
        }
    }
 
    public List<ServiceMessage> getValidationMessages() {
        return new ArrayList<>(this.validationMsgs);
    }
 
    @Override
    public Iterator<ServiceMessage> iterator() {
        return this.validationMsgs.iterator();
    }

}
