package com.example.java_burito.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.java_burito.domain.shop.ShopRegisterRepository;

@Service
public class ShopRegisterService {
private final ShopRegisterRepository shopRegisterRepository;
	

@Transactional
public boolean registerShopInfo(String shopName,int shopId, String prefecture, String city, String street, Double latitude,
			Double longitude, boolean showFlg,String[] menuItem) {
	return (
			shopRegisterRepository.shopRegister(shopName) &&
			shopRegisterRepository.addressRegister(shopName, prefecture, city, street, latitude, longitude) &&
			shopRegisterRepository.shopMenuRegister(shopName, menuItem)
			);
}
	public ShopRegisterService(ShopRegisterRepository shopRegisterRepository) {
		this.shopRegisterRepository = shopRegisterRepository;
	}
}