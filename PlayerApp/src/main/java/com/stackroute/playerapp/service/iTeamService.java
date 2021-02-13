package com.stackroute.playerapp.service;

import java.util.List;

import com.stackroute.playerapp.exceptions.TeamAlreadyExistsException;
import com.stackroute.playerapp.exceptions.TeamNotFoundException;
import com.stackroute.playerapp.model.Team;

public interface iTeamService {

	public Team addTeam(Team team) throws TeamAlreadyExistsException;
	
	public List<Team> getTeamList();
	
    public Team findTeam(int Id);
	
	public boolean deleteTeam(int Id) throws TeamNotFoundException;
}
