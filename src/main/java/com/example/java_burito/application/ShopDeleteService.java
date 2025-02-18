package com.example.java_burito.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.java_burito.domain.shop.ShopDeleteRepository;
import com.example.java_burito.domain.shop.ShopDeleteResult;

@Service
public class ShopDeleteService {
	private final ShopDeleteRepository shopDeleteRepository;
	
	@Transactional
	public ShopDeleteResult shopDelete(int shopId) {
		try {
			boolean result = shopDeleteRepository.shopDelete(shopId);
			return result ? ShopDeleteResult.SUCCESS : ShopDeleteResult.FAILED;
		}finally{
			System.out.println("success");
		}
	}

	public ShopDeleteService(ShopDeleteRepository shopDeleteRepository) {
		this.shopDeleteRepository = shopDeleteRepository;
	}

}
