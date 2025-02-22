package com.example.java_burito.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.example.java_burito.domain.shop.ShopDeleteRepository;
import com.example.java_burito.domain.shop.ShopDeleteResult;
import com.example.java_burito.domain.shop.ShopExistsRepository;

public class ShopDeleteServiceTest {
	private ShopDeleteService target;
	
	private ShopDeleteRepository shopDeleteRepository;
	private ShopExistsRepository shopExistsRepository;
	
	@BeforeEach
	public void setup() {
		shopDeleteRepository = mock(ShopDeleteRepository.class);
		shopExistsRepository = mock(ShopExistsRepository.class);

		target = new ShopDeleteService(shopDeleteRepository,shopExistsRepository);
	}
	
	@Test
	public void お店削除成功() {
		ArgumentCaptor<Integer> captorShopId1 = ArgumentCaptor.forClass(Integer.class);
		doReturn(true).when(shopExistsRepository).existsShopById(captorShopId1.capture());
		ArgumentCaptor<Integer> captorShopId2 = ArgumentCaptor.forClass(Integer.class);
		doReturn(true).when(shopDeleteRepository).shopDelete(captorShopId2.capture());

		final ShopDeleteResult results = target.shopDelete(1);
				
		assertEquals(0,results.code());
		verify(shopExistsRepository, times(1)).existsShopById(1);
		assertEquals(1,captorShopId1.getValue());
		verify(shopDeleteRepository, times(1)).shopDelete(1);
		assertEquals(1,captorShopId2.getValue());
	}
	
	@Test
	public void お店削除失敗() {
		ArgumentCaptor<Integer> captorShopId1 = ArgumentCaptor.forClass(Integer.class);
		doReturn(true).when(shopExistsRepository).existsShopById(captorShopId1.capture());
		ArgumentCaptor<Integer> captorShopId2 = ArgumentCaptor.forClass(Integer.class);
		doReturn(false).when(shopDeleteRepository).shopDelete(captorShopId2.capture());

		final ShopDeleteResult results = target.shopDelete(1);
				
		assertEquals(9,results.code());
		verify(shopExistsRepository, times(1)).existsShopById(1);
		assertEquals(1,captorShopId1.getValue());
		verify(shopDeleteRepository, times(1)).shopDelete(1);
		assertEquals(1,captorShopId2.getValue());
	}

	@Test
	public void お店削除失敗_不正なshopId() {

		final ShopDeleteResult results = target.shopDelete(0);
				
		assertEquals(1,results.code());
		verify(shopExistsRepository, never()).existsShopById(0);
		verify(shopDeleteRepository, never()).shopDelete(0);
	}
	
	@Test
	public void お店削除失敗_該当しないshopId() {
		ArgumentCaptor<Integer> captorShopId1 = ArgumentCaptor.forClass(Integer.class);
		doReturn(false).when(shopExistsRepository).existsShopById(captorShopId1.capture());

		final ShopDeleteResult results = target.shopDelete(99);
				
		assertEquals(2,results.code());
		verify(shopExistsRepository, times(1)).existsShopById(99);
		assertEquals(99,captorShopId1.getValue());
		verify(shopDeleteRepository, never()).shopDelete(99);
	}
	
	@Test
	public void お店削除失敗_削除処理で例外発生() {
		ArgumentCaptor<Integer> captorShopId1 = ArgumentCaptor.forClass(Integer.class);
		doReturn(true).when(shopExistsRepository).existsShopById(captorShopId1.capture());
		ArgumentCaptor<Integer> captorShopId2 = ArgumentCaptor.forClass(Integer.class);
	    doThrow(new RuntimeException("削除失敗")).when(shopDeleteRepository).shopDelete(captorShopId2.capture());

	    // 例外がスローされることを確認
	    assertThrows(RuntimeException.class, () -> {
	        target.shopDelete(1);
	    });
	    
		verify(shopExistsRepository, times(1)).existsShopById(1);
		assertEquals(1,captorShopId1.getValue());
		verify(shopDeleteRepository, times(1)).shopDelete(1);
		assertEquals(1,captorShopId2.getValue());
	}




	
}
