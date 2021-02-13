package com.stackroute.playerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.playerapp.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}
