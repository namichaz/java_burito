package com.example.java_burito.presentation.shop.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResultResponse extends ResponseEntity<ResultItem>{
	public static ResultResponse of(String result , HttpStatus status) {
		return new ResultResponse(ResultItem.of(result), status);
	}
	
	public static ResultResponse invalidParamOf() {
		return of("INVALID_PARAM",HttpStatus.BAD_REQUEST);
	}
	
	public static ResultResponse unauthorizedOf() {
		return of("UNAUTHORIZED",HttpStatus.UNAUTHORIZED);
	}
	
	public static ResultResponse errorOf() {
		return of("FAILED",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResultResponse(ResultItem resultResponse,HttpStatus status) {
		super(resultResponse, status);
	}
}
