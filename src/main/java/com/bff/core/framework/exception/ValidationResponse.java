package com.bff.core.framework.exception;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "timestamp",
        "message",
        "code",
        "type",
        "validations",
        "details"
})
@XmlRootElement(name = "ValidationResponse")
public class ValidationResponse {
	
	@JsonProperty
    @XmlElement(name = "message", required = true)
    private String message;
    @JsonProperty
    @XmlElement(name = "code")
    private String code;
    @JsonProperty
    @XmlElement(name = "timestamp", required = true)
    private long timestamp = (new GregorianCalendar()).getTimeInMillis();
    @JsonProperty
    @XmlElement(name = "type")
    private String type;
    @JsonProperty
    @XmlElement(name = "validations")
    private List<ServiceMessage> validationMessages = new ArrayList<>();
    @JsonProperty
    @XmlElement(name = "id")
    private String id;
    @JsonProperty
    @XmlElement(name="details")
    private Map<String,Object> detailMap;
    @XmlTransient
    private HttpStatus status;

    /**
     *
     */
    public ValidationResponse() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     *
     * @param status
     */
    public ValidationResponse(HttpStatus status) {
        this.status = status;
    }

    /**
     *
     * @param message
     */
    public ValidationResponse(String message) {
        this();
        this.setMessage(message);
    }

    /**
     *
     * @param message
     * @param status
     */
    public ValidationResponse(String message, HttpStatus status) {
        this.setMessage(message);
        this.setStatus(status);
    }
    
    public ValidationResponse(ServiceMessage validationMessage) {
        this.addValidationMessages(validationMessage);
    }
    
    public ValidationResponse(List<ServiceMessage> validationMessages) {
        this.addValidationMessages(validationMessages);
    }
    
   
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
   /* public void setDetails(Map<String,Object> details) {
        this.detailMap = details;
    }
    public Map<String,Object> getDetails() {
        return this.detailMap;
    }
*/
    

    public void addValidationMessage(ServiceMessage message) {
        this.validationMessages.add(message);
    }

    public Map<String, Object> getDetailMap() {
		return detailMap;
	}

	public void setDetailMap(Map<String, Object> detailMap) {
		this.detailMap = detailMap;
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


    /**
     *
     * @param status The status code to use in the response to the client.
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public HttpStatus getStatus() {
        return this.status;
    }


}
