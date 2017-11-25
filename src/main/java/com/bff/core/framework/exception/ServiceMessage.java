package com.bff.core.framework.exception;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceMessage {

	@JsonProperty
	private String source;
	@JsonProperty
	private String text;
	@JsonProperty
	private long code;
	@JsonProperty
	private Map<String, Object> detailMap;

	public ServiceMessage() {
	}

	/**
	 * 
	 * @param text
	 */
	public ServiceMessage(String text) {
		this.text = text;
	}

	public ServiceMessage(String text, String source) {
		this.text = text;
		this.source = source;
	}

	public ServiceMessage(String text, String source, Map<String, Object> detailMap) {
		this.text = text;
		this.source = source;
		this.setDetails(detailMap);
	}

	/**
	 * @return The source of the message. In the case of this being a validation
	 *         message, the source would be something like the name of the class
	 *         or operation in which the validation error occurred.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            The source of the message. In the case of this being a
	 *            validation message, the source would be something like the
	 *            name of the class or operation in which the validation error
	 *            occurred.
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return The message text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            The text of the message, usually scrubbed and hand-crafted for
	 *            consumption by end users.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return The message code.
	 */
	public long getCode() {
		return code;
	}

	/**
	 * @param code
	 *            A code representing the message. This could be used in lieu of
	 *            setting message text, after which some message externalization
	 *            layer would use the code to look up the message to be sent to
	 *            the client.
	 */
	public void setCode(long code) {
		this.code = code;
	}

	/**
	 * Used to add extra details of the exception.
	 * 
	 * @param key
	 * @param value
	 */
	public void addDetail(String key, Object value) {
		this.detailMap.put(key, value);
	}

	public void setDetails(Map<String, Object> detailMap) {
		this.detailMap = new HashMap<>(detailMap);
	}

	public boolean hasDetails() {
		return this.detailMap.isEmpty();
	}

	public Map<String, Object> getDetails() {
		return this.detailMap;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append("text:").append(this.text).append(",");
		text.append("code:").append(Long.toString(this.code)).append(",");
		text.append("source:").append(this.source);
		return super.toString();
	}

}
