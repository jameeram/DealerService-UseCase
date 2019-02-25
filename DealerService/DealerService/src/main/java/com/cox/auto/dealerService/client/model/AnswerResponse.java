package com.cox.auto.dealerService.client.model;

public class AnswerResponse {
	
	private Boolean success;
	
	private String message;
	
	private Long totalMilliseconds;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTotalMilliseconds() {
		return totalMilliseconds;
	}

	public void setTotalMilliseconds(Long totalMilliseconds) {
		this.totalMilliseconds = totalMilliseconds;
	}

}
