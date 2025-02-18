package com.example.java_burito.domain.shop;

import org.springframework.http.HttpStatus;

import com.example.java_burito.presentation.shop.response.ResultResponse;

public enum ShopDeleteResult {
	SUCCESS(0,HttpStatus.OK),
	SHOP_NOT_FOUND(2,HttpStatus.NOT_FOUND),
	FORBIDDEN(3,HttpStatus.FORBIDDEN),
	FAILED(9,HttpStatus.INTERNAL_SERVER_ERROR);
	
	private final int code;
	private final HttpStatus status;
	
	public int code() {
		return code;
	}
	
	public HttpStatus status() {
		return status;
	}
	
	public ResultResponse resultResponse() {
		return ResultResponse.of(this.toString(), this.status);
	}
	
	private ShopDeleteResult(int code,HttpStatus status) {
		this.code = code;
		this.status = status;
	}
}
