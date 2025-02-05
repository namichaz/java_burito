package com.example.java_burito.infrastructure.datasource.shop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.java_burito.domain.shop.Shop;
import com.example.java_burito.domain.shop.ShopSearchRepository;
import com.example.java_burito.infrastructure.datasource.shop.search.entity.ShopSearchEntity;

@Repository
public class ShopSearchDataSource implements ShopSearchRepository {

	private final ShopSearchDao searchDao;
	
	@Override
	public List<Shop> shopLists() {
		final List<ShopSearchEntity> shopEntityList = searchDao.shopSearch();
		List<Shop> shopList = new ArrayList<>();
		return shopList = shopEntityList.stream()
	                .map(entity -> new Shop(
	                        entity.getShopId(),   
	                        entity.getShopName(), 
	                        entity.getLongitude(),
	                        entity.getLatitude()  
	                ))
	                .collect(Collectors.toList());  // リストにまとめる
	    }

	
	public ShopSearchDataSource(ShopSearchDao searchDao) {
		this.searchDao = searchDao;
	}

}
