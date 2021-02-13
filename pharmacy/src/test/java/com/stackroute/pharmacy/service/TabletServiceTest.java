package com.stackroute.pharmacy.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.pharmacy.model.Tablet;
import com.stackroute.pharmacy.repository.TabletRepository;

public class TabletServiceTest {
	
	@Mock
	TabletRepository tabletRepo;

	@InjectMocks
	TabletServiceImpl tabletService;
	
	Tablet test;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		test = new Tablet();
		test.setTabletId(1);
		test.setTabletName("Check");
		test.setTabletExpDate("07-01-2021");
	}
	
//	@AfterEach
//	public void destroy() {
//		test = null;
//	}
	
	@Test
	public void testSaveTablet() throws Exception {
		Mockito.when(tabletService.addTablet(test)).thenReturn(test);
		assertEquals(test, tabletService.addTablet(test));
	}
	
	@Test
	public void testTabletsList() throws Exception {
		List<Tablet> list = new ArrayList<>();
		list.add(test);
		Mockito.when(tabletRepo.findAll()).thenReturn(list);
		assertEquals(list, tabletService.getTabletList());
	}
	
	@Test
	public void testFindTablet() throws Exception {
		int tabletId = test.getTabletId();
		tabletService.addTablet(test);
		when(tabletRepo.findById(test.getTabletId())).thenReturn(Optional.of(test));
		//Tablet search = tabletService.findTablet(tabletId);
		assertEquals(test.getTabletExpDate(),tabletService.findTablet(tabletId).getTabletExpDate());
	}
	 

}
