package com.stackroute.pharmacy.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.pharmacy.model.Tablet;
import com.stackroute.pharmacy.service.TabletService;

@SpringBootTest

//@RunWith(SpringRunner.class)
//@WebMvcTest
//@ComponentScan(basePackages = "com.stackroute.pharmacy")
public class TabletControllerTest {

	MockMvc mvc;

	@Mock
	TabletService tabletService;

	@InjectMocks
	TabletController tabletController;
	List<Tablet> tabletsList;
	
	Tablet test;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(tabletController).build();
		test = new Tablet();
		test.setTabletId(1);
		test.setTabletName("Check");
		test.setTabletExpDate("07-01-2021");
		tabletsList= new ArrayList<>();
	}
	
	@Test
	public void testAddTabletAPI() throws  Exception {
		when(tabletService.addTablet(test)).thenReturn(test);
		mvc.perform(MockMvcRequestBuilders.post("/pharmacy/saveTablet")
                .contentType(MediaType.APPLICATION_JSON).content(convertUser(test)))
		        .andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void testViewTabletsAPI() throws Exception {
		when(tabletService.getTabletList()).thenReturn(tabletsList);
		mvc.perform(MockMvcRequestBuilders.get("/pharmacy/viewTablets")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testUpdateTabletAPI() throws Exception {
		when(tabletService.updateTablet(test)).thenReturn(test);
		mvc.perform(MockMvcRequestBuilders.put("/pharmacy/updateTablet/1")
                .contentType(MediaType.APPLICATION_JSON).content(convertUser(test)))
		        .andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testFindTabletAPI() throws Exception {
		when(tabletService.findTablet(test.getTabletId())).thenReturn(test);
		mvc.perform(MockMvcRequestBuilders.get("/pharmacy/findTablet/1")
                .contentType(MediaType.APPLICATION_JSON).content(convertUser(test)))
		        .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testDeleteTabletAPI() throws Exception {
		doNothing().when(tabletService).deleteTablet(test.getTabletId());
		mvc.perform(MockMvcRequestBuilders.post("/pharmacy/findTablet/1")
                .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	public String convertUser(Object obj) throws JsonProcessingException {
		String result = null;
		try {
			ObjectMapper map = new ObjectMapper();
			String output = map.writeValueAsString(obj);
			result = output;

		} catch (JsonProcessingException e) {

		}
		return result;
	}

}
