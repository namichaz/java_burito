package com.example.java_burito.presentation.shop;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_burito.application.ShopDeleteService;
import com.example.java_burito.presentation.shop.response.ShopDeleteResponse;

@RestController
public class ShopDeleteController {
	
	private final ShopDeleteService service; 
	
    @DeleteMapping("/shops/info/{shopId}")
    public ShopDeleteResponse deleteShopInfo(@PathVariable(value="shopId") int shopId) {
		return ShopDeleteResponse.of(service.shopDelete(shopId));
    }

	public ShopDeleteController(ShopDeleteService service) {
		this.service = service;
	}
}
