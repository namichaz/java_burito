package com.example.java_burito.domain.shop;

public class Shop {
	private final int shop_id;
	private final String shop_name;
	private final double longitude;
	private final double latitude;
	
	
	public Shop of(int shop_id,String shop_name, double longitude,double latitude) {
		return new Shop(shop_id,shop_name, longitude, latitude);
	}
	
	public Shop(int shop_id, String shop_name, double longitude,double latitude) {
		super();
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.longitude = longitude;
		this.latitude = latitude;
	}

}
