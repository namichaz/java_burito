package com.example.java_burito.domain.shop;
import java.util.ArrayList;
import java.util.List;

public class MenuList {
    private List<String> items;

    // コンストラクタ
    public MenuList(List<String> items) {
        this.items = items;
    }

    // ゲッター
    public List<String> getItems() {
        return items;
    }

    // 文字列をカンマ区切りで変換する
    public String toString() {
        return String.join(",", items);
    }

    // 文字列からMenuListを作成する静的メソッド
    public static MenuList fromString(String menuListString) {
        List<String> items = List.of(menuListString.split(","));
        return new MenuList(items);
    }
    
    public static MenuList empty() {
    	return new MenuList(new ArrayList<>());
    }
}
