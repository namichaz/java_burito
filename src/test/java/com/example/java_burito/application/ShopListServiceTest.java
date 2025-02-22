package com.example.java_burito.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.java_burito.domain.shop.Address;
import com.example.java_burito.domain.shop.MenuList;
import com.example.java_burito.domain.shop.Shop;
import com.example.java_burito.domain.shop.ShopInfo;
import com.example.java_burito.domain.shop.ShopSearchRepository;

public class ShopListServiceTest {
	private ShopListService target;
	
	private ShopSearchRepository shopSearchRepository;
	
	@BeforeEach
	public void setup() {
		shopSearchRepository = mock(ShopSearchRepository.class);
		target = new ShopListService(shopSearchRepository);
	}
	
	@Test
	public void お店一覧取得() {
		final Shop shop1 = Shop.of(1, "ShopName1");
		final Shop shop2 = Shop.of(2, "ShopName2");
		final Address address1 = Address.of("大阪府", "大阪市中央区", "上町1丁目1-22", 34.67817232955493, 135.52556733716918);
		final Address address2 = Address.of("大阪府", "堺市北区", "中百舌鳥町2-71", 34.562891187566436, 135.50687485584098);
		final String menu1 = "burrito,nachos,tacos";
		final String menu2 = "burrito,enchiladas,tortilla";
		final MenuList menuList1 = MenuList.fromString(menu1);
		final MenuList menuList2 = MenuList.fromString(menu2);
		final ShopInfo[] shopInfos = new ShopInfo[] 
						{ShopInfo.of(shop1, address1, menuList1),
						ShopInfo.of(shop2, address2, menuList2)};
		doReturn(shopInfos).when(shopSearchRepository).shopLists();
		final ShopInfo[] results = target.shopList();
				
		assertEquals(1,results[0].getShop().getShop_id());
		assertEquals("ShopName1",results[0].getShop().getShop_name());
		assertEquals("大阪府",results[0].getAddress().getPrefecture());
		assertEquals("大阪市中央区",results[0].getAddress().getCity());
		assertEquals("上町1丁目1-22",results[0].getAddress().getStreet());
		assertEquals(135.52556733716918,results[0].getAddress().getLatitude());
		assertEquals(34.67817232955493,results[0].getAddress().getLongitude());

		assertEquals(2,results[1].getShop().getShop_id());
		assertEquals("ShopName2",results[1].getShop().getShop_name());
		assertEquals("大阪府",results[1].getAddress().getPrefecture());
		assertEquals("堺市北区",results[1].getAddress().getCity());
		assertEquals("中百舌鳥町2-71",results[1].getAddress().getStreet());
		assertEquals(135.50687485584098,results[1].getAddress().getLatitude());
		assertEquals(34.562891187566436,results[1].getAddress().getLongitude());

		verify(shopSearchRepository, times(1)).shopLists();
	}
	
	@Test
	public void お店一覧取得_データ0件() {
		final ShopInfo[] shopInfos = new ShopInfo[] {};
		doReturn(shopInfos).when(shopSearchRepository).shopLists();
		final ShopInfo[] results = target.shopList();
				
		assertArrayEquals(new ShopInfo[] {},results);
		verify(shopSearchRepository, times(1)).shopLists();
	}
	
}
