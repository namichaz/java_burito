package com.example.java_burito.infrastructure.datasource.shop.register;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface ShopRegisterDao {
	@Insert(sqlFile=true)
    public int insertShop(String shopName);
	
	@Insert(sqlFile=true)
	public int insertAddress(String shopName,String prefecture,String city,String street,Double latitude,Double longitude);

	@Insert(sqlFile=true)
	public int insertMenu(String shopName,int menuId,boolean showFlg);
	

}
