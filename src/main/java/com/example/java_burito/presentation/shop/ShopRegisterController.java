package com.example.java_burito.presentation.shop;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_burito.application.ShopRegisterService;
import com.example.java_burito.domain.shop.ShopRegisterResult;
import com.example.java_burito.presentation.shop.param.ShopRegisterParam;
import com.example.java_burito.presentation.shop.response.ShopRegisterResponse;

@RestController
public class ShopRegisterController {
	
	private final ShopRegisterService service;

    @PostMapping("/shops/info")
    public ShopRegisterResponse shopRegister(@RequestBody ShopRegisterParam param) {
    	System.out.println("param=" + param.getMenuItem());
//    	if(shop.getShop_id() <= 0 || shop.getShop_name() == "")
//    	if(address.getPrefecture() == "")
//    	ShopInfo[] shopInfos = service.shopList();
    	
    	final boolean result = service.registerShopInfo(
    			param.getShopName(), 
    			Integer.parseInt(param.getShopId()), 
    			param.getPrefecture(), 
    			param.getCity(), 
    			param.getStreet(), 
    			Double.parseDouble(param.getLatitude()), 
    			Double.parseDouble(param.getLongitude()), 
    			true,
    			param.getMenuItem()
    			);
    	if(result) return ShopRegisterResponse.of(ShopRegisterResult.SUCCESS);
    	return ShopRegisterResponse.errorOf();
    	}
    public ShopRegisterController(ShopRegisterService service) {
    	this.service = service;
    }
}
