package com.example.java_burito.infrastructure.datasource.shop.search;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.java_burito.infrastructure.datasource.shop.search.entity.ShopSearchEntity;

@Dao
@ConfigAutowireable
public interface ShopSearchDao {
    @Select
    public List<ShopSearchEntity> shopSearch();
}
