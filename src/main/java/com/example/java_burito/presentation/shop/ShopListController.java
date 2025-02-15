package com.example.java_burito.presentation.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_burito.application.ShopListService;
import com.example.java_burito.domain.shop.ShopInfo;
import com.example.java_burito.presentation.shop.response.ShopListResponse;

@RestController
public class ShopListController {
	
	private final ShopListService service;

    @GetMapping("/shops/info")
    public ShopListResponse shopList() {
    	ShopInfo[] shopInfos = service.shopList();

        // ShopListResponse を作成して返す
        return new ShopListResponse(shopInfos);
    }
    public ShopListController(ShopListService service) {
    	this.service = service;
    }
}
