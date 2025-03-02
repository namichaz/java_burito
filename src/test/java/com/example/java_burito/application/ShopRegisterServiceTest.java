package com.example.java_burito.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.example.java_burito.domain.shop.ShopRegisterRepository;

public class ShopRegisterServiceTest {

	private ShopRegisterService target;
	
	private ShopRegisterRepository shopRegisterRepository;
	
	@BeforeEach
	public void setup() {
		shopRegisterRepository = mock(ShopRegisterRepository.class);

		target = new ShopRegisterService(shopRegisterRepository);
	}
	
	@Test
	public void お店登録成功() {
		final String shopName = "shopName";
		final String prefecture = "大阪";
		final String city = "堺市";
		final String street = "堺区";
		final Double latitude = 0.1;
		final Double longitude = 0.2;
		final String[] menuItem = new String[] {"burrito","nachos"};
		ArgumentCaptor<String> shopNameCaptor = ArgumentCaptor.forClass(String.class);
		doReturn(true).when(shopRegisterRepository).shopRegister(shopNameCaptor.capture());
		ArgumentCaptor<String> prefectureCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> cityCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> streetCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Double> latitudeCaptor = ArgumentCaptor.forClass(Double.class);
		ArgumentCaptor<Double> longitudeCaptor = ArgumentCaptor.forClass(Double.class);
		doReturn(true).when(shopRegisterRepository).addressRegister(
				shopNameCaptor.capture(),
				prefectureCaptor.capture(),
				cityCaptor.capture(),
				streetCaptor.capture(),
				latitudeCaptor.capture(),
				longitudeCaptor.capture()
				);
		ArgumentCaptor<String[]> menuItemCaptor = ArgumentCaptor.forClass(String[].class);
		doReturn(true).when(shopRegisterRepository).shopMenuRegister(shopNameCaptor.capture(), menuItemCaptor.capture());

		final boolean results = target.registerShopInfo(shopName,prefecture,city,street,latitude,longitude,menuItem);
				
		assertTrue(results);
		
		verify(shopRegisterRepository, times(1)).shopRegister(shopName);
		assertEquals(shopName,shopNameCaptor.getValue());
		
		verify(shopRegisterRepository, times(1)).addressRegister(shopName,prefecture,city,street,latitude,longitude);
		assertEquals(shopName,shopNameCaptor.getValue());
		assertEquals(prefecture,prefectureCaptor.getValue());
		assertEquals(city,cityCaptor.getValue());
		assertEquals(street,streetCaptor.getValue());
		assertEquals(latitude,latitudeCaptor.getValue());
		assertEquals(longitude,longitudeCaptor.getValue());
		
		verify(shopRegisterRepository, times(1)).shopMenuRegister(shopName,menuItem);
		assertEquals(shopName,shopNameCaptor.getValue());
		assertEquals(menuItem,menuItemCaptor.getValue());
	}
	
	@Test
	public void お店登録失敗() {
		final String shopName = "shopName";
		final String prefecture = "errorString";
		final String city = "堺市";
		final String street = "堺区";
		final Double latitude = 0.1;
		final Double longitude = 0.2;
		final String[] menuItem = new String[] {"burrito","nachos"};
		ArgumentCaptor<String> shopNameCaptor = ArgumentCaptor.forClass(String.class);
		doReturn(true).when(shopRegisterRepository).shopRegister(shopNameCaptor.capture());
		ArgumentCaptor<String> prefectureCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> cityCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> streetCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Double> latitudeCaptor = ArgumentCaptor.forClass(Double.class);
		ArgumentCaptor<Double> longitudeCaptor = ArgumentCaptor.forClass(Double.class);
		doReturn(false).when(shopRegisterRepository).addressRegister(
				shopNameCaptor.capture(),
				prefectureCaptor.capture(),
				cityCaptor.capture(),
				streetCaptor.capture(),
				latitudeCaptor.capture(),
				longitudeCaptor.capture()
				);

		final boolean results = target.registerShopInfo(shopName,prefecture,city,street,latitude,longitude,menuItem);
				
		assertFalse(results);
		
		verify(shopRegisterRepository, times(1)).shopRegister(shopName);
		assertEquals(shopName,shopNameCaptor.getValue());
		
		verify(shopRegisterRepository, times(1)).addressRegister(shopName,prefecture,city,street,latitude,longitude);
		assertEquals(shopName,shopNameCaptor.getValue());
		assertEquals(prefecture,prefectureCaptor.getValue());
		assertEquals(city,cityCaptor.getValue());
		assertEquals(street,streetCaptor.getValue());
		assertEquals(latitude,latitudeCaptor.getValue());
		assertEquals(longitude,longitudeCaptor.getValue());
		
		verify(shopRegisterRepository, never()).shopMenuRegister(shopName,menuItem);
	}
	
	@Test
	public void お店登録失敗_例外発生() {
		final String shopName = "shopName";
		final String prefecture = "errorString";
		final String city = "堺市";
		final String street = "堺区";
		final Double latitude = 0.1;
		final Double longitude = 0.2;
		final String[] menuItem = new String[] {"burrito","nachos"};
		ArgumentCaptor<String> shopNameCaptor = ArgumentCaptor.forClass(String.class);
		doThrow(new RuntimeException("登録失敗")).when(shopRegisterRepository).shopRegister(shopNameCaptor.capture());

	    // 例外がスローされることを確認
	    assertThrows(RuntimeException.class, () -> {
	    	target.registerShopInfo(shopName,prefecture,city,street,latitude,longitude,menuItem);
	    });
	    
		verify(shopRegisterRepository, times(1)).shopRegister(shopName);
		assertEquals(shopName,shopNameCaptor.getValue());
		verify(shopRegisterRepository, never()).addressRegister(shopName,prefecture,city,street,latitude,longitude);
		verify(shopRegisterRepository, never()).shopMenuRegister(shopName,menuItem);
	}



}
