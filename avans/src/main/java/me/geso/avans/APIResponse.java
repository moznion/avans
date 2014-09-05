package me.geso.avans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class APIResponse<T extends Object> {
	@Getter
	@Setter
	int code;

	@Getter
	List<String> messages;

	@Getter
	@Setter
	T data;

	/**
	 * Create new instance.
	 */
	public APIResponse() {
		this.code = 200;
		this.messages = new ArrayList<>();
		this.data = null;
	}

	/**
	 * Create new instance with the data. Default status code is 200.
	 */
	public APIResponse(T data) {
		this.code = 200;
		this.messages = new ArrayList<>();
		this.data = data;
	}

	/**
	 * Create new instance.
	 */
	public APIResponse(int code, T data) {
		this.code = code;
		this.messages = new ArrayList<>();
		this.data = data;
	}

	/**
	 * Create new instance.
	 */
	public APIResponse(int code, String message, T data) {
		this.code = code;
		this.messages = new ArrayList<>();
		this.messages.add(message);
		this.data = data;
	}

	/**
	 * Set message. Current message will remove.
	 */
	public void setMessage(String message) {
		this.messages = new ArrayList<>();
		this.messages.add(message);
	}

	/**
	 * Set messages. Current message will remove.
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * Create empty response
	 */
	public static APIResponse<String> empty() {
		return new APIResponse<String>(null);
	}

	/**
	 * Create 404 not found response
	 */
	public static APIResponse<String> notFound() {
		return new APIResponse<String>(404, "Resource Not Found", null);
	}

	/**
	 * Create 403 forbidden API response
	 */
	public static APIResponse<String> Forbidden() {
		return new APIResponse<String>(403, "Forbidden", null);
	}
}