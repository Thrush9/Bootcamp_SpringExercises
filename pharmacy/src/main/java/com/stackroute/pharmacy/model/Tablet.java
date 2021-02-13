package com.stackroute.pharmacy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tablet {
	
	@Id
	public int tabletId;
	
	public String tabletName;
	
	public String tabletExpDate;
	
	public Tablet() {
		
	}

	public int getTabletId() {
		return tabletId;
	}

	public void setTabletId(int tabletId) {
		this.tabletId = tabletId;
	}

	public String getTabletName() {
		return tabletName;
	}

	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}

	public String getTabletExpDate() {
		return tabletExpDate;
	}

	public void setTabletExpDate(String tabletExpDate) {
		this.tabletExpDate = tabletExpDate;
	}

	@Override
	public String toString() {
		return "Tablet [tabletId=" + tabletId + ", tabletName=" + tabletName + ", tabletExpDate=" + tabletExpDate + "]";
	}

	
}
