package com.example.java_burito.domain.shop;

public enum MenuItem {
    nachos("nachos"),
    burrito("burrito"),
    tacos("tacos"),
    tortilla("tortilla"),
    enchiladas("enchiladas"),
    guacamole("guacamole");

    private final String name;

    // コンストラクタ
    MenuItem(String name) {
        this.name = name;
    }

    // nameを取得するメソッド
    public String getName() {
        return name;
    }

    // 文字列がenumに存在するかをチェックするメソッド
    public static boolean contains(String test) {
        for (MenuItem item : MenuItem.values()) {
            if (item.getName().equals(test)) {  // getName()を使用
                return true;
            }
        }
        return false;
    }
}

