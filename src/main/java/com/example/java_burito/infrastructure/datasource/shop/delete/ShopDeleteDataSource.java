package com.example.java_burito.infrastructure.datasource.shop.delete;

import org.springframework.stereotype.Repository;

import com.example.java_burito.domain.shop.ShopDeleteRepository;

@Repository
public class ShopDeleteDataSource implements ShopDeleteRepository {

	private final ShopDeleteDao deleteDao;
	
	@Override
	public boolean shopDelete(int shopId) {
		return deleteDao.deleteShopInfo(shopId) > 0;
	}

	public ShopDeleteDataSource(ShopDeleteDao deleteDao) {
		this.deleteDao = deleteDao;
	}

}
