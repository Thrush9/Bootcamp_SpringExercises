package com.stackroute.playerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.playerapp.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerapp.exceptions.PlayerNotFoundException;
import com.stackroute.playerapp.model.Player;
import com.stackroute.playerapp.service.iPlayerService;

@RestController
public class PlayerController {

	@Autowired
	iPlayerService playerService;

	@GetMapping("/playerapp/player/viewAll")
	public ResponseEntity<?> getAllPlayers() {
		List<Player> playerList = playerService.getPlayerList();
		return new ResponseEntity<List<Player>>(playerList, HttpStatus.OK);
	}

	@PostMapping("/playerapp/player/addPlayer")
	public ResponseEntity<?> addPlayer(@RequestBody Player playerObj) {
		try {
			Player added = playerService.addPlayer(playerObj);
			return new ResponseEntity<Player>(added, HttpStatus.OK);
		} catch (PlayerAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/playerapp/player/{playerId}")
	public ResponseEntity<?> deletePlayer(@PathVariable("playerId") int id) {
		try {
			boolean result = playerService.deletePlayer(id);
			return new ResponseEntity<String>("Player Deleted", HttpStatus.OK);
		} catch (PlayerNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
