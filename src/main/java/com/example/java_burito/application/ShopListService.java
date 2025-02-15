package com.example.java_burito.application;

import org.springframework.stereotype.Service;

import com.example.java_burito.domain.shop.ShopInfo;
import com.example.java_burito.domain.shop.ShopSearchRepository;

@Service
public class ShopListService{
	private final ShopSearchRepository shopSearchRepository;
	
	public ShopInfo[] shopList() {
		return shopSearchRepository.shopLists();
	}
	
	public ShopListService(ShopSearchRepository shopSearchRepository) {
		this.shopSearchRepository = shopSearchRepository;
	}
}