package com.example.java_burito.presentation.shop.response;

import com.example.java_burito.domain.shop.ShopInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopListResponse {
    private final ShopInfo[] shopList;

    public ShopListResponse(ShopInfo[] shopList) {
        this.shopList = shopList;
    }

    public ShopInfo[] getShopList() {
        return shopList;
    }
}
