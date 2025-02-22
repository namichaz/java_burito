package com.example.java_burito.infrastructure.datasource.shop.search;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface ShopExistsDao {
	@Select
    public boolean existsShopById(int shopId);
}
