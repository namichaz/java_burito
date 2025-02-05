package com.example.java_burito.presentation.shop.response;

import java.util.List;

import com.example.java_burito.domain.shop.Shop;

public class ShopListResponse {
    private final List<Shop> shopList;

    public ShopListResponse(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }
}
