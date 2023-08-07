package com.SanketFirstRestApp.RestfulWebServices01.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timeStamp;
	private String msg;
	private String errorDetail;
	public ErrorDetails(LocalDateTime timeStamp, String msg, String errorDetail) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.errorDetail = errorDetail;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public String getMsg() {
		return msg;
	}
	public String getErrorDetail() {
		return errorDetail;
	}
	
	
	
}