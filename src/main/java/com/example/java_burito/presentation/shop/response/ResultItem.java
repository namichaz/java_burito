package com.example.java_burito.presentation.shop.response;

public class ResultItem {
	private final String result;
	
	public static ResultItem of(String result){
		return new ResultItem(result);
	}
	
	
	
	public String getResult() {
		return result;
	}


	public ResultItem(String result) {
		this.result = result;
	}
	
	
}


