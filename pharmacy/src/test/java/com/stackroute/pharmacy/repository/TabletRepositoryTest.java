package com.stackroute.pharmacy.repository;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.pharmacy.model.Tablet;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TabletRepositoryTest {
	
	@Autowired
	TabletRepository tabletRepo;
	
	Tablet testTablet;
	
	@BeforeEach
	public void setUp() {
		testTablet = new Tablet();
		testTablet.setTabletId(1);
		testTablet.setTabletName("Check");
		testTablet.setTabletExpDate("07-01-2021");
	}

	@AfterEach
    void tearDown() { 
		testTablet = null;
	}
	
	@Test
	public void testSave() {
		Tablet added = tabletRepo.save(testTablet);
		assertEquals(testTablet.getTabletId(), added.getTabletId());
	}
	
	@Test
	public void testTabletList() {
		List<Tablet> tabletlist = new ArrayList<>();
		Tablet added = tabletRepo.save(testTablet);
		tabletlist.add(added);
		List<Tablet> list = tabletRepo.findAll();
		assertEquals(tabletlist, list);
	}
	
	@Test
	public void testSearch() {
		Tablet added = tabletRepo.save(testTablet);
		Tablet search = tabletRepo.getOne(added.getTabletId());
		assertEquals(testTablet.getTabletExpDate(), search.getTabletExpDate());
	}
	
	@Test
	public void testDelete() {
		Tablet added = tabletRepo.save(testTablet);
		tabletRepo.deleteById(added.getTabletId());
		Optional<Tablet> search = tabletRepo.findById(testTablet.getTabletId());
		assertEquals(true,search.isEmpty());
	}
	
	@Test
	public void testUpdate() {
		Tablet added = tabletRepo.save(testTablet);
		testTablet.setTabletName("updatedName");
		Tablet updated = tabletRepo.saveAndFlush(testTablet);
		assertEquals(testTablet.getTabletName(),updated.getTabletName());
	}

}
