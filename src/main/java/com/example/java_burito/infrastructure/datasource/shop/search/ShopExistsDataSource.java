package com.example.java_burito.infrastructure.datasource.shop.search;

import org.springframework.stereotype.Repository;

import com.example.java_burito.domain.shop.ShopExistsRepository;

@Repository
public class ShopExistsDataSource implements ShopExistsRepository {
	
	private final ShopExistsDao shopExistsDao;

	@Override
	public boolean existsShopById(int shopId) {
		return shopExistsDao.existsShopById(shopId);
	}

	public ShopExistsDataSource(ShopExistsDao shopExistsDao) {
		this.shopExistsDao = shopExistsDao;
	}

}
