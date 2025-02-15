package com.example.java_burito.domain.shop;

public class ShopInfo {
    private Shop shop;
    private Address address;
    private MenuList menuList;
    
	public ShopInfo(Shop shop, Address address, MenuList menuList) {
		this.shop = shop;
		this.address = address;
		this.menuList = menuList;
	}

	public Shop getShop() {
		return shop;
	}

	public Address getAddress() {
		return address;
	}

	public MenuList getMenuList() {
		return menuList;
	}
	
	public static ShopInfo of(Shop shop, Address address, MenuList menuList) {
		return new ShopInfo(shop,address,menuList);
	}
	
	public static ShopInfo empty() {
		return new ShopInfo(Shop.empty(),Address.empty(),MenuList.empty());
	}

}
