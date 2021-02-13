package com.stackroute.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.pharmacy.model.Tablet;
import com.stackroute.pharmacy.service.TabletService;

@RestController
@RequestMapping("/pharmacy")
public class TabletController {
	
	@Autowired
	TabletService tabletService;

	
	@GetMapping("/viewTablets")
	public ResponseEntity<?> getAllTablets(){
		List<Tablet> tabletsList = tabletService.getTabletList();
		return new ResponseEntity<List<Tablet>>(tabletsList,HttpStatus.OK);
	}
	
	@PostMapping("/saveTablet")
	public ResponseEntity<?> saveTablet(@RequestBody() Tablet tab){
		try {
			Tablet addedTablet = tabletService.addTablet(tab);
			return new ResponseEntity<Tablet>(addedTablet,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateTablet")
	public ResponseEntity<?> updateTablet(@RequestBody() Tablet tab){
		try {
			Tablet updatedTablet = tabletService.updateTablet(tab);
			return new ResponseEntity<Tablet>(updatedTablet,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findTablet/{tabletId}")
	public ResponseEntity<?> findTablet(@PathVariable("tabletId") int tabId){
		try {
			 Tablet search = tabletService.findTablet(tabId);
			return new ResponseEntity<Tablet>(search,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/delete/{tabletId}")
	public ResponseEntity<?> deleteTablet(@PathVariable("tabletId") int tabId){
		try {
			 tabletService.deleteTablet(tabId);
			return new ResponseEntity<String>("Tablet Deleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
