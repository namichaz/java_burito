package com.example.java_burito.domain.shop;

import java.util.Arrays;

public class MenuList {
    private String[] items;

    // コンストラクタ
    public MenuList(String[] items) {
        this.items = items;
    }

    // ゲッター
    public String[] getItems() {
        return items;
    }

    // 文字列からMenuListを作成する静的メソッド
    public static MenuList fromString(String menuListString) {
        // DBから取得した文字列をカンマで分割して、MenuItemに変換する
        String[] items = Arrays.stream(menuListString.split(","))
                                 .map(String::trim)  // 不要な空白を除去
                                 .toArray(String[]::new);  // 配列に変換
        return new MenuList(items);
    }

    public static MenuList empty() {
        return new MenuList(new String[0]);
    }
}
