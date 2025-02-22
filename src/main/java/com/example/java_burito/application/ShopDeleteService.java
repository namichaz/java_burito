package com.example.java_burito.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.java_burito.domain.shop.ShopDeleteRepository;
import com.example.java_burito.domain.shop.ShopDeleteResult;
import com.example.java_burito.domain.shop.ShopExistsRepository;

@Service
public class ShopDeleteService {
	private final ShopDeleteRepository shopDeleteRepository;
	private final ShopExistsRepository shopExistsRepository;
	
	@Transactional
	public ShopDeleteResult shopDelete(int shopId) {
		try {
			if(shopId == 0)return ShopDeleteResult.BADREQUEST;
			boolean isShopId = shopExistsRepository.existsShopById(shopId);
			if(!isShopId) return ShopDeleteResult.SHOP_NOT_FOUND;
			boolean result = shopDeleteRepository.shopDelete(shopId);
			return result ? ShopDeleteResult.SUCCESS : ShopDeleteResult.FAILED;
		}catch(Exception e){
			System.out.println("エラーが発生しました: " + e.getMessage());
			throw new RuntimeException("削除失敗", e);
		}
	}

	public ShopDeleteService(ShopDeleteRepository shopDeleteRepository, ShopExistsRepository shopExistsRepository) {
		this.shopDeleteRepository = shopDeleteRepository;
		this.shopExistsRepository = shopExistsRepository;
	}


}
