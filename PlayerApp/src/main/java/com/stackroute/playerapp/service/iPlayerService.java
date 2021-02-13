package com.stackroute.playerapp.service;

import java.util.List;

import com.stackroute.playerapp.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerapp.exceptions.PlayerNotFoundException;
import com.stackroute.playerapp.model.Player;

public interface iPlayerService {
	
	public Player addPlayer(Player player) throws PlayerAlreadyExistsException;
	
	public List<Player> getPlayerList();
	
	public Player findPlayer(int Id);
	
	public boolean deletePlayer(int Id) throws PlayerNotFoundException;

}
