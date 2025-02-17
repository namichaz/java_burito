package com.example.java_burito.domain.shop;

public interface ShopRegisterRepository {
	public boolean shopRegister(String shopName);
	
	public boolean addressRegister(String shopName,String prefecture,String city,String street,Double latitude,Double longitude);

	public boolean shopMenuRegister(String shopName,String[] menuItems);
}
