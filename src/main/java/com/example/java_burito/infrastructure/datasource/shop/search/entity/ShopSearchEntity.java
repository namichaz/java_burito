package com.example.java_burito.infrastructure.datasource.shop.search.entity;

import java.io.Serializable;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import com.example.java_burito.domain.shop.Address;
import com.example.java_burito.domain.shop.MenuList;
import com.example.java_burito.domain.shop.Shop;
import com.example.java_burito.domain.shop.ShopInfo;

@Entity
public class ShopSearchEntity implements Serializable {
	
	@Id
	@Column(name="shop_id")
	private int shopId;
	@Column(name="shop_name")
	private String shopName;
	@Column(name="prefecture")
	private String prefecture;
	@Column(name="city")
	private String city;
	@Column(name="street")
	private String street;
	@Column(name="longitude")
	private double longitude;
	@Column(name="latitude")
	private double latitude;
	@Column(name="menu_list")
	private String menuList;
	
	public int getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public String getMenuList() {
		return menuList;
	}

	public ShopInfo toDomain() {
		return ShopInfo.of(
				Shop.of(shopId, shopName),
				Address.of(prefecture,city,street,longitude,latitude),
				MenuList.fromString(menuList)
				);
	}
}
