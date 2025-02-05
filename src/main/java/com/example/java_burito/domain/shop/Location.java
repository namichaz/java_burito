package com.example.java_burito.domain.shop;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Location {

    private String type;
    private double[] coordinates;

    // コンストラクタや getter, setter などはそのまま

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    // ここで JSON 文字列を受け取れるようにする場合
    public Location(String json) {
        // JSON 文字列を解析して type と coordinates をセットするロジック
        // Jackson や Gson などのライブラリを使う
        try {
            ObjectMapper mapper = new ObjectMapper();
            Location loc = mapper.readValue(json, Location.class);
            this.type = loc.getType();
            this.coordinates = loc.getCoordinates();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Location(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }
}
