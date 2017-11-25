package com.bff.core.framework.exception;

import java.io.Serializable;
import java.util.Arrays;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String text;
	private Object[] args;
	private String defaultMessage;

	public Message() {
	}

	public Message(String code, Object[] args) {
		this(code, args, null);
	}

	public Message(String code) {
		this.code = code;
	}

	public Message(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public Message(String code, String text, Object[] args) {
		this.code = code;
		this.args = args;
		this.text = text;
	}

	public Message(String code, Object[] args, String defaultMessage) {
		this.code = code;
		this.args = args;
		this.defaultMessage = defaultMessage;
	}

	/**
	 * Gets the message code.
	 *
	 * @return the message code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the message code.
	 *
	 * @param code
	 *            message code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getArguments() {
		return args;
	}

	public void setArguments(Object[] arguments) {
		this.args = arguments;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", text=" + text + ", args=" + Arrays.toString(args) + ", defaultMessage="
				+ defaultMessage + "]";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
