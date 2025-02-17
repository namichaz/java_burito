package com.example.java_burito.presentation.shop.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.example.java_burito.domain.shop.ShopRegisterResult;

public class ShopRegisterResponse extends ResponseEntity<byte[]>{

	public static ShopRegisterResponse of(ShopRegisterResult result) {
		return new ShopRegisterResponse(result.status());
	}
	
	public static ShopRegisterResponse invalidParamOf() {
		return new ShopRegisterResponse(HttpStatus.BAD_REQUEST);
	}
	
	public static ShopRegisterResponse unauthorizedOf() {
		return new ShopRegisterResponse(HttpStatus.UNAUTHORIZED);
	}

	public static ShopRegisterResponse forbiddenOf() {
		return new ShopRegisterResponse(HttpStatus.FORBIDDEN);
	}

	public static ShopRegisterResponse errorOf() {
		return new ShopRegisterResponse(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ShopRegisterResponse(HttpStatusCode status) {
		super(status);
	}

}
