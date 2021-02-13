package com.stackroute.playerapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.playerapp.exceptions.TeamAlreadyExistsException;
import com.stackroute.playerapp.exceptions.TeamNotFoundException;
import com.stackroute.playerapp.model.Team;
import com.stackroute.playerapp.repository.TeamRepository;

@Service
public class TeamServiceImpl implements iTeamService {

	@Autowired
	TeamRepository teamRepo;

	@Override
	public Team addTeam(Team team) throws TeamAlreadyExistsException {
		Team search = findTeam(team.getTeamId());
		if (search == null)
			throw new TeamAlreadyExistsException("Team Already Exists");
		else {
			Team added = teamRepo.save(team);
			return added;
		}
	}

	@Override
	public List<Team> getTeamList() {
		List<Team> teamlist = teamRepo.findAll();
		return teamlist;
	}

	@Override
	public Team findTeam(int Id) {
		Team search = null;
		Optional<Team> find = teamRepo.findById(Id);
		if (find.isPresent())
			search = find.get();
		return search;
	}

	@Override
	public boolean deleteTeam(int Id) throws TeamNotFoundException {
		Team search = findTeam(Id);
		if (search == null) {
			System.out.println("1");
			throw new TeamNotFoundException("TeamId not Found");
		}
		else {
			teamRepo.deleteById(Id);
			return true;
		}
	}

}
