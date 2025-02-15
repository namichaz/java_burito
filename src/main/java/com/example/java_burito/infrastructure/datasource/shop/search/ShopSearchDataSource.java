package com.example.java_burito.infrastructure.datasource.shop.search;

import org.springframework.stereotype.Repository;

import com.example.java_burito.domain.shop.ShopInfo;
import com.example.java_burito.domain.shop.ShopSearchRepository;
import com.example.java_burito.infrastructure.datasource.shop.search.entity.ShopSearchEntity;

@Repository
public class ShopSearchDataSource implements ShopSearchRepository {

	private final ShopSearchDao searchDao;
	
	@Override
	public ShopInfo[] shopLists() {
	    return searchDao.shopSearch().stream()
	            .map(ShopSearchEntity::toDomain)  // ShopSearchEntity -> ShopInfo に変換
	            .toArray(ShopInfo[]::new);  // ShopInfo[] 型の配列に変換
	}

	public ShopSearchDataSource(ShopSearchDao searchDao) {
		this.searchDao = searchDao;
	}

}
