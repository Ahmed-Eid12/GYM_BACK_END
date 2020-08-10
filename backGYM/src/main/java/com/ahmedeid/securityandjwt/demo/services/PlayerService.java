package com.ahmedeid.securityandjwt.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Player;
import com.ahmedeid.securityandjwt.demo.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	// get all players of list ...
	public List<Player> getAll() {
		return this.playerRepository.findAll();
	}

	// get player by id ...
	public Player getPlayerById(int id) {
		return this.playerRepository.findById(id).get();
	}

	// get player by code ...
	public Player getPlayerByCode(long code) {
		return this.playerRepository.getPlayerByCode(code);
	}

	// get player by code ...
	public Player getPlayerByPlayerName(String playerName) {
		return this.playerRepository.getPlayerByPlayerName(playerName);
	}

	// save or update new player ...
	public Player saveNewPlayer(Player player) {
		return this.playerRepository.save(player);
	}

	// delete player By id ....
	public boolean deletePlayerById(int id) {
		Player player = getPlayerById(id);
		System.out.println(player);
		if (player != null) {
			this.playerRepository.delete(player);
			return true;
		}
		return false;
	}
	
}
