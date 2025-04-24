package com.example.java_burito.presentation.shop.param;

public class ShopRegisterParam {

    private String shopName;
    private String prefecture;
    private String city;
    private String street;
    private String latitude;
    private String longitude;
    private String[] menuItem; // 配列として受け取るため List<String> を使う

    // 各フィールドの getter と setter を追加します

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String[] getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String[] menuItem) {
        this.menuItem = menuItem;
    }

//	public ShopRegisterParam(@JsonProperty("shopName") String shopName, @JsonProperty("prefecture")String prefecture, @JsonProperty("city")String city,@JsonProperty("street") String street, @JsonProperty("latitude")String latitude,
//			@JsonProperty("longitude")String longitude, @JsonProperty("menuItem")String[] menuItem) {
//		this.shopName = shopName;
//		this.prefecture = prefecture;
//		this.city = city;
//		this.street = street;
//		this.latitude = latitude;
//		this.longitude = longitude;
//		this.menuItem = menuItem;
//	}
    
    
}
