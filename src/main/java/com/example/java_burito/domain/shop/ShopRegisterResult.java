package com.example.java_burito.domain.shop;

import org.springframework.http.HttpStatus;

public enum ShopRegisterResult {
	SUCCESS(HttpStatus.OK),
	ACCEPT(HttpStatus.ACCEPTED),
	PROCESSING(HttpStatus.NOT_ACCEPTABLE),
	FAILED(HttpStatus.INTERNAL_SERVER_ERROR);
	
	private final HttpStatus status;
	
	public HttpStatus status() {
		return status;
	}
	
	public boolean isSuccess() {
		return this == SUCCESS;
	}
	
	public boolean isAccept() {
		return this == ACCEPT;
	}
	
	public boolean isFailed() {
		return this != SUCCESS;
	}

	private ShopRegisterResult(HttpStatus status) {
		this.status = status;
	}
}
