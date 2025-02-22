package com.example.java_burito.presentation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.java_burito.application.ShopDeleteService;
import com.example.java_burito.domain.shop.ShopDeleteResult;
import com.example.java_burito.presentation.shop.ShopDeleteController;

public class ShopDeleteControllerTest {
	
	private MockMvc mvc;
	
	private final ShopDeleteService shopDeleteService = mock(ShopDeleteService.class);
	
	@InjectMocks
	private final ShopDeleteController target = new ShopDeleteController(shopDeleteService);
	
	@BeforeEach
	public void before() {
		mvc = MockMvcBuilders.standaloneSetup(target).build();
	}
	
	@Test
	public void お店削除成功() throws Exception{
		doReturn(ShopDeleteResult.SUCCESS).when(shopDeleteService).shopDelete(1);
		
		mvc.perform(MockMvcRequestBuilders.delete("/shops/info/1"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();
		
		verify(shopDeleteService, times(1)).shopDelete(1);
	}
	
	@Test
	public void お店削除失敗_不正なshopId() throws Exception{
		ArgumentCaptor<Integer> captorShopId = ArgumentCaptor.forClass(Integer.class);
		doReturn(ShopDeleteResult.BADREQUEST).when(shopDeleteService).shopDelete(captorShopId.capture());
		
		mvc.perform(MockMvcRequestBuilders.delete("/shops/info/0"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();
		
		verify(shopDeleteService, times(1)).shopDelete(0);
		assertEquals(0,captorShopId.getValue());
	}
	
	@Test
	public void お店削除失敗_該当するshopIdが無い() throws Exception{
		ArgumentCaptor<Integer> captorShopId = ArgumentCaptor.forClass(Integer.class);
		doReturn(ShopDeleteResult.SHOP_NOT_FOUND).when(shopDeleteService).shopDelete(captorShopId.capture());
		
		mvc.perform(MockMvcRequestBuilders.delete("/shops/info/999"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();
		
		verify(shopDeleteService, times(1)).shopDelete(999);
		assertEquals(999,captorShopId.getValue());
	}



}
