package com.example.java_burito.infrastructure.datasource.shop.register;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import com.example.java_burito.domain.shop.MenuItem;
import com.example.java_burito.domain.shop.ShopRegisterRepository;

@Repository
public class ShopRegisterDataSource implements ShopRegisterRepository {

	private final ShopRegisterDao registerDao;
	
	@Override
	public boolean shopRegister(String shopName) {
		return registerDao.insertShop(shopName) > 0;
	}

	@Override
	public boolean addressRegister(String shopName, String prefecture, String city, String street, Double latitude,
			Double longitude) {
		return registerDao.insertAddress(shopName, prefecture, city, street, latitude, longitude) > 0;
	}

	@Override
	public boolean shopMenuRegister(String shopName,String[] menuItems) {
		    var registerCount = 0;

		    // enumの値を順番に取り出す
		    for (var i = 0; i < MenuItem.values().length; i++) {
		        MenuItem item = MenuItem.values()[i];  // enumの値を順番に取得
		        boolean showFlg = Arrays.asList(menuItems).contains(item.getName());  // menuItemsに存在するかチェック

		        // showFlgの状態をログ出力
		        System.out.println("メニュー: " + item.getName() + ", showFlg=" + showFlg);

		        // insertMenuにenum番号とshowFlgを渡して登録
		        registerCount += registerDao.insertMenu(shopName, i + 1, showFlg);  // enum番号は1から始める（i + 1）
		    }

		    System.out.println("registerCount=" + registerCount);
		    return registerCount == MenuItem.values().length;  // すべてのメニューが登録されていればtrue
		}
	
	public ShopRegisterDataSource(ShopRegisterDao registerDao) {
		this.registerDao = registerDao;
	}

}
