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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.playerapp.exceptions.TeamAlreadyExistsException;
import com.stackroute.playerapp.exceptions.TeamNotFoundException;
import com.stackroute.playerapp.model.Team;
import com.stackroute.playerapp.service.iTeamService;

@RestController
@RequestMapping("/playerapp/team")
public class TeamController {
	
	@Autowired
	iTeamService teamService;
	
	@GetMapping("/viewAll")
	public ResponseEntity<?> getAllTeams() {
		List<Team> teamList = teamService.getTeamList();
		return new ResponseEntity<List<Team>>(teamList,HttpStatus.OK);
	}
	
	@PostMapping("/addTeam")
	public ResponseEntity<?> addTeam(@RequestBody Team teamObj){
		try {
			Team  added = teamService.addTeam(teamObj);
			return new ResponseEntity<Team>(added,HttpStatus.OK);
		} catch (TeamAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{teamId}")
	public ResponseEntity<?> deletePlayer(@PathVariable("teamId") int id){
		try {
			boolean result = teamService.deleteTeam(id);
			return new ResponseEntity<String>("Team Deleted",HttpStatus.OK);
		} catch (TeamNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}
