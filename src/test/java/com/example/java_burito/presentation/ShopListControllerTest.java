package com.example.java_burito.presentation;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.java_burito.application.ShopListService;
import com.example.java_burito.domain.shop.Address;
import com.example.java_burito.domain.shop.MenuList;
import com.example.java_burito.domain.shop.Shop;
import com.example.java_burito.domain.shop.ShopInfo;
import com.example.java_burito.presentation.shop.ShopListController;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ShopListControllerTest {
	
	private MockMvc mvc;
	
	private final ShopListService shopListService = mock(ShopListService.class);
	
	@InjectMocks
	private final ShopListController target = new ShopListController(shopListService);
	
	@BeforeEach
	public void before() {
		mvc = MockMvcBuilders.standaloneSetup(target).build();
	}
	
	@Test
	public void お店一覧取得成功() throws Exception{
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
		doReturn(shopInfos).when(shopListService).shopList();
		
		mvc.perform(MockMvcRequestBuilders.get("/shops/info"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("shopList[0].shop.shop_id").value(1))
				.andExpect(jsonPath("shopList[0].shop.shop_name").value("ShopName1"))
				.andExpect(jsonPath("shopList[0].address.prefecture").value("大阪府"))
				.andExpect(jsonPath("shopList[0].address.city").value("大阪市中央区"))
				.andExpect(jsonPath("shopList[0].address.street").value("上町1丁目1-22"))
				.andExpect(jsonPath("shopList[0].menuList.items").value(hasItems("burrito", "nachos", "tacos")))
				.andReturn();
		
		verify(shopListService, times(1)).shopList();

	}
	
	@Test
	public void お店一覧取得_データ0件() throws Exception{
		final ShopInfo[] shopInfos = new ShopInfo[]{};
		doReturn(shopInfos).when(shopListService).shopList();
		
		mvc.perform(MockMvcRequestBuilders.get("/shops/info"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("shopList").isEmpty())
				.andReturn();
		
		verify(shopListService, times(1)).shopList();

	}
}
