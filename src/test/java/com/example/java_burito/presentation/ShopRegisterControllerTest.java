package com.example.java_burito.presentation;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.java_burito.application.ShopRegisterService;
import com.example.java_burito.presentation.shop.ShopRegisterController;
import com.example.java_burito.presentation.shop.param.ShopRegisterParam;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShopRegisterControllerTest {
	
	private MockMvc mvc;
	
	private final ShopRegisterService shopRegisterService = mock(ShopRegisterService.class);
	
	@InjectMocks
	private final ShopRegisterController target = new ShopRegisterController(shopRegisterService);
	
	@BeforeEach
	public void before() {
		mvc = MockMvcBuilders.standaloneSetup(target).build();
	}
	
	@Test
	public void お店登録成功() throws Exception {
		ShopRegisterParam param = new ShopRegisterParam();
	    param.setShopName("shopName");
	    param.setShopId(String.valueOf(1));
	    param.setPrefecture("大阪府");
	    param.setCity("堺市北区");
	    param.setStreet("仲通り1-22");
	    param.setLatitude(String.valueOf(34.2134525));
	    param.setLongitude(String.valueOf(124.52534));
	    param.setMenuItem(new String[] {"burrito", "nachos"});
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonRequest = objectMapper.writeValueAsString(param);

	    ArgumentCaptor<String> captorShopName = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<Integer> captorShopId = ArgumentCaptor.forClass(Integer.class);
	    ArgumentCaptor<String> captorPrefecture = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<String> captorCity = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<String> captorStreet = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<Double> captorLatitude = ArgumentCaptor.forClass(Double.class);
	    ArgumentCaptor<Double> captorLongitude = ArgumentCaptor.forClass(Double.class);
	    ArgumentCaptor<Boolean> captorShowFlg = ArgumentCaptor.forClass(Boolean.class);
	    ArgumentCaptor<String[]> captorMenuList = ArgumentCaptor.forClass(String[].class);

	    doReturn(true).when(shopRegisterService).registerShopInfo(
	            captorShopName.capture(),
	            captorShopId.capture(),
	            captorPrefecture.capture(),
	            captorCity.capture(),
	            captorStreet.capture(),
	            captorLatitude.capture(),
	            captorLongitude.capture(),
	            captorShowFlg.capture(),
	            captorMenuList.capture()
	    );

	    mvc.perform(MockMvcRequestBuilders.post("/shops/info")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonRequest))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isOk())
	        .andReturn();

	    verify(shopRegisterService, times(1)).registerShopInfo(
	            captorShopName.getValue(),
	            captorShopId.getValue(),
	            captorPrefecture.getValue(),
	            captorCity.getValue(),
	            captorStreet.getValue(),
	            captorLatitude.getValue(),
	            captorLongitude.getValue(),
	            captorShowFlg.getValue(),
	            captorMenuList.getValue()
	    );

	    assertEquals("shopName", captorShopName.getValue());
	    assertEquals(1,captorShopId.getValue());
	    assertEquals("大阪府",captorPrefecture.getValue());
	    assertEquals("堺市北区",captorCity.getValue());
	    assertEquals("仲通り1-22",captorStreet.getValue());
	    assertEquals(34.2134525,captorLatitude.getValue());
	    assertEquals(124.52534,captorLongitude.getValue());
	    assertArrayEquals(new String[]{"burrito", "nachos"}, captorMenuList.getValue());
	    }
		
	@Test
	public void お店登録失敗() throws Exception {
		ShopRegisterParam param = new ShopRegisterParam();
	    param.setShopName("shopName");
	    param.setShopId(String.valueOf(1));
	    param.setPrefecture("大阪府");
	    param.setCity("堺市北区");
	    param.setStreet("仲通り1-22");
	    param.setLatitude(String.valueOf(34.2134525));
	    param.setLongitude(String.valueOf(124.52534));
	    param.setMenuItem(new String[] {"burrito", "nachos"});
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonRequest = objectMapper.writeValueAsString(param);

	    ArgumentCaptor<String> captorShopName = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<Integer> captorShopId = ArgumentCaptor.forClass(Integer.class);
	    ArgumentCaptor<String> captorPrefecture = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<String> captorCity = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<String> captorStreet = ArgumentCaptor.forClass(String.class);
	    ArgumentCaptor<Double> captorLatitude = ArgumentCaptor.forClass(Double.class);
	    ArgumentCaptor<Double> captorLongitude = ArgumentCaptor.forClass(Double.class);
	    ArgumentCaptor<Boolean> captorShowFlg = ArgumentCaptor.forClass(Boolean.class);
	    ArgumentCaptor<String[]> captorMenuList = ArgumentCaptor.forClass(String[].class);

	    doReturn(false).when(shopRegisterService).registerShopInfo(
	            captorShopName.capture(),
	            captorShopId.capture(),
	            captorPrefecture.capture(),
	            captorCity.capture(),
	            captorStreet.capture(),
	            captorLatitude.capture(),
	            captorLongitude.capture(),
	            captorShowFlg.capture(),
	            captorMenuList.capture()
	    );

	    mvc.perform(MockMvcRequestBuilders.post("/shops/info")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonRequest))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isInternalServerError())
	        .andReturn();

	    verify(shopRegisterService, times(1)).registerShopInfo(
	            captorShopName.getValue(),
	            captorShopId.getValue(),
	            captorPrefecture.getValue(),
	            captorCity.getValue(),
	            captorStreet.getValue(),
	            captorLatitude.getValue(),
	            captorLongitude.getValue(),
	            captorShowFlg.getValue(),
	            captorMenuList.getValue()
	    );

	    assertEquals("shopName", captorShopName.getValue());
	    assertEquals(1,captorShopId.getValue());
	    assertEquals("大阪府",captorPrefecture.getValue());
	    assertEquals("堺市北区",captorCity.getValue());
	    assertEquals("仲通り1-22",captorStreet.getValue());
	    assertEquals(34.2134525,captorLatitude.getValue());
	    assertEquals(124.52534,captorLongitude.getValue());
	    assertArrayEquals(new String[]{"burrito", "nachos"}, captorMenuList.getValue());
	    }
	
	@Test
	public void お店登録失敗_パラメータなし() throws Exception {
  
	    mvc.perform(MockMvcRequestBuilders.post("/shops/info"))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isBadRequest())
	        .andReturn();

	    verify(shopRegisterService, never());
	    }


	




}
