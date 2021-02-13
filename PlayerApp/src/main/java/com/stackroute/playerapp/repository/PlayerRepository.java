package com.stackroute.playerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.playerapp.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
