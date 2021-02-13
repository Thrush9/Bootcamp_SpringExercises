package com.stackroute.pharmacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.pharmacy.model.Tablet;
import com.stackroute.pharmacy.repository.TabletRepository;

@Service
public class TabletServiceImpl implements TabletService{

	@Autowired
	TabletRepository tabletRepo;
	
	@Override
	public Tablet addTablet(Tablet tab) throws Exception {
		Optional<Tablet> check = tabletRepo.findById(tab.getTabletId());
		Tablet added;
		if(check.isPresent()) {
			throw new Exception("Already Exists");
		} else {
			 added = tabletRepo.save(tab);
		} 
		return added;
	}

	@Override
	public List<Tablet> getTabletList() {
		List<Tablet> tablets = tabletRepo.findAll();
		return tablets;
	}

	@Override
	public Tablet updateTablet(Tablet tab) throws Exception {
		Tablet check = tabletRepo.getOne(tab.getTabletId());
		if(check == null) {
			throw new Exception("Doesn't Exists");
		} else {
			 check = tabletRepo.saveAndFlush(tab);
		} 
		return check;
	}

	@Override
	public void deleteTablet(int tabletId) throws Exception {
		Tablet check = tabletRepo.getOne(tabletId);
		if(check == null) {
			throw new Exception("Doesn't Exists");
		} else {
			tabletRepo.deleteById(tabletId);
		} 
	}

	@Override
	public Tablet findTablet(int tabletId) throws Exception {
		Tablet search = tabletRepo.getOne(tabletId);
		if(search == null) {
			throw new Exception("Doesn't Exists");
		} else {
			return search;
		} 
	}

}
