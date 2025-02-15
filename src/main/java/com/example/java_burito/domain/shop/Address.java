package com.example.java_burito.domain.shop;


public class Address {
    private final String prefecture;
    private final String city;
    private final String street;
    private final double longitude;
    private final double latitude;
    
	public Address(String prefecture, String city, String street, double longitude, double latitude) {
		this.prefecture = prefecture;
		this.city = city;
		this.street = street;
		this.longitude = longitude;
		this.latitude = latitude;
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
	
	public static Address of(String prefecture, String city, String street, double longitude, double latitude){
		return new Address(prefecture,city,street,longitude,latitude);
	}
	
	public static Address empty(){
		return new Address("","","",0,0);
	}


}
