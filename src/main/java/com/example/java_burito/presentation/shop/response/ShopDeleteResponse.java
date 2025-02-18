package com.example.java_burito.presentation.shop.response;

import com.example.java_burito.domain.shop.ShopDeleteResult;

public class ShopDeleteResponse {
	private final int result;
	
	public static ShopDeleteResponse of(ShopDeleteResult result) {
		return new ShopDeleteResponse(result.code());
	}
	
	public int getResult() {
		return result;
	}

	public ShopDeleteResponse(int result) {
		this.result = result;
	}
}
