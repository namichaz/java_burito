package com.example.java_burito.presentation.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_burito.application.ShopListService;
//import com.example.java_burito.application.ShopListService;
import com.example.java_burito.domain.shop.Shop;
import com.example.java_burito.presentation.shop.response.ShopListResponse;

@RestController
public class ShopListController {
	
	private final ShopListService service;

    @GetMapping("/info/shops")
    public ShopListResponse shopList() {        // サンプルデータ作成
    	List<Shop> res = service.shopList();
        double longitude = 139.6917;
        double latitude = 35.6895;
        Shop shop1 = new Shop(1, "Elsocalo Burito", longitude,latitude);
        Shop shop2 = new Shop(2, "Burrito Town", longitude,latitude);

        List<Shop> shopList = new ArrayList<>();
        shopList.add(shop1);
        shopList.add(shop2);

        // ShopListResponse を作成して返す
        return new ShopListResponse(shopList);
    }
    public ShopListController(ShopListService service) {
    	this.service = service;
    }
}
