package com.example.java_burito.infrastructure.datasource.shop.delete;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface ShopDeleteDao {
	@Delete(sqlFile=true)
	public int deleteShopInfo(int shopId);
}

	
