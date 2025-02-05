package com.example.java_burito.infrastructure.datasource.shop.search.entity;

import java.io.Serializable;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class ShopSearchEntity implements Serializable {
	
	@Id
	@Column(name="shop_id")
	private int shopId;
	
	@Column(name="shop_name")
	private String shopName;

	@Column(name="longitude")
	private double longitude;
	
	@Column(name="latitude")
	private double latitude;

	public int getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	
	
}
