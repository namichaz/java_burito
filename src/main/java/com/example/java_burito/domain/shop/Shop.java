package com.example.java_burito.domain.shop;


public class Shop {
    private final int shop_id;
    private final String shop_name;

    // コンストラクタ（Jacksonが使用するためpublicにする）
    public Shop(
        int shop_id, 
        String shop_name
    	) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
    }

    // フィールドのゲッター（Jacksonはデフォルトでゲッターを使ってシリアライズする）
    public int getShop_id() {
        return shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    // 'of' メソッドは不要かもしれません。通常、コンストラクタで十分です
    public static Shop of(int shop_id, String shop_name) {
        return new Shop(shop_id, shop_name);
    }
    
    public static Shop empty() {
    	return new Shop(0,"");
    }
}
