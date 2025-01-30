package com.example.java_burito.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // このクラスは設定クラスであることを示す
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS設定をここで行う
        registry.addMapping("/**")  // 全てのエンドポイントに適用
                .allowedOrigins("http://localhost:8080")  // Vue.jsが動作しているURLを許可
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 許可するHTTPメソッド
                .allowedHeaders("*")  // 全てのヘッダーを許可
                .allowCredentials(true);  // Cookieなどを送信する場合に必要
    }
}
