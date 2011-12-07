package com.danstoncube.poker.plugin;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;

import com.danstoncube.poker.plugin.game.GameOperator;
import com.danstoncube.poker.plugin.gui.PokerPlayerGui;

public class CommandOperator
{
	
	//private final Poker plugin = Poker.getInstance();
	
	
	public static boolean joinCommand(Player player, Command cmd, String commandLabel, String[] args)
	{
		
		new PokerPlayerGui(SpoutManager.getPlayer(player));
		
		//gui.show();
		
		
		return true;
	}
	
	public static boolean createCommand(Player player, Command cmd, String commandLabel, String[] args)
	{
		Poker plugin = Poker.getInstance();
		
		//TODO: check permission "dtc.poker.creategame"

		
		//TODO: read config defaults if not specified
		
		int min = 2;	
		int max = 8;
		int chips = 1500;
		int buyin = 5;
		
		
		GameOperator newGame = Poker.getGameManager().createNewGame(min, max, SpoutManager.getPlayer(player));
		
		//Log
		plugin.log.info(plugin.logPrefix + player.getName() + " created new PokergGame(" + min + ", " + max + ", " +  chips + ", " + buyin+") id=" + newGame.getGame().getId());
		
		//Chat message
		player.sendMessage(plugin.chatPrefix + "Game started, tell people to join by typing /pokerjoin #" + newGame.getGame().getId());
		
		
		
		
		return true;		
	}

	public static boolean usageCommand(Player player)
	{
		//TODO
		return false;
	}
	
	
	
}
