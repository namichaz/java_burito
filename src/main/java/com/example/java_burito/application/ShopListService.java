package com.example.java_burito.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.java_burito.domain.shop.Shop;
import com.example.java_burito.domain.shop.ShopSearchRepository;

@Service
public class ShopListService{
	private final ShopSearchRepository shopSearchRepository;
	
	public List<Shop> shopList() {
		final List<Shop> shopList = shopSearchRepository.shopLists();
		return shopList;
	}
	
	public ShopListService(ShopSearchRepository shopSearchRepository) {
		this.shopSearchRepository = shopSearchRepository;
	}
}