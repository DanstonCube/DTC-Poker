package com.danstoncube.poker.server;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;

import com.danstoncube.poker.plugin.gui.PokerPlayerGui;

public class ServerCommandOperator
{
	
	
	
	
	public static boolean joinCommand(Player player, Command cmd, String commandLabel, String[] args)
	{
		
		new PokerPlayerGui(SpoutManager.getPlayer(player));
		
		//gui.show();
		
		
		return true;
	}
	
	public static boolean createCommand(Player player, Command cmd, String commandLabel, String[] args)
	{
		//TODO
		return false;		
	}

	public static boolean usageCommand(Player player)
	{
		//TODO
		return false;
	}
	
	
	
}
