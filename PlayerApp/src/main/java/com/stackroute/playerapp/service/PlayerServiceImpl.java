package com.stackroute.playerapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.playerapp.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerapp.exceptions.PlayerNotFoundException;
import com.stackroute.playerapp.model.Player;
import com.stackroute.playerapp.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements iPlayerService {

	@Autowired
	PlayerRepository playerRepo;

	@Override
	public Player addPlayer(Player player) throws PlayerAlreadyExistsException {
		Player search = findPlayer(player.getPlayerId());
		if (search == null)
			throw new PlayerAlreadyExistsException("PlayerId Already Exists");
		else {
			Player newPlayer = playerRepo.save(player);
			return newPlayer;
		}
	}

	@Override
	public List<Player> getPlayerList() {
		List<Player> playerList = playerRepo.findAll();
		return playerList;
	}

	@Override
	public Player findPlayer(int Id) {
		Player search = null;
		Optional<Player> find = playerRepo.findById(Id);
		if (find.isPresent())
			search = find.get();
		return search;
	}

	@Override
	public boolean deletePlayer(int Id) throws PlayerNotFoundException {
		Player search = findPlayer(Id);
		if (search == null)
			throw new PlayerNotFoundException("PlayerId not Found");
		else {
			playerRepo.deleteById(Id);
			return true;
		}
	}

}
