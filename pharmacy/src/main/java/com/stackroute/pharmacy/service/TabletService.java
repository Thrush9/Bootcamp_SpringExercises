package com.stackroute.pharmacy.service;

import java.util.List;

import com.stackroute.pharmacy.model.Tablet;

public interface TabletService {
	
	public Tablet addTablet(Tablet tab) throws Exception;
	
	public List<Tablet> getTabletList();
	
	public Tablet updateTablet(Tablet tab) throws Exception;
	
	public void deleteTablet(int tabletId) throws Exception;

	public Tablet findTablet(int tabId) throws Exception;

}
