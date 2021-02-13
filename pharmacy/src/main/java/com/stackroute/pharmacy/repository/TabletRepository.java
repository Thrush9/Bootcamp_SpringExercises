package com.stackroute.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.pharmacy.model.Tablet;

@Repository
public interface TabletRepository extends JpaRepository<Tablet, Integer>{

}
