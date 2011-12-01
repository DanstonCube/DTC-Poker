package com.danstoncube.Poker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.danstoncube.com.Poker.server.ServerCommandOperator;
import com.danstoncube.com.Poker.server.ServerGameManager;

public class Poker extends JavaPlugin
{

	private static Poker _instance = null;
	
	private ServerGameManager _gamemanager = new ServerGameManager();

	public static Poker getInstance()
	{
		return _instance;
	}

	public static ServerGameManager getGameManager()
	{
		return _instance._gamemanager;
	}
	
	@Override
	public void onDisable()
	{
		Poker._instance = null;
		//TODO: finire proprement les parties en cours
	}

	@Override
	public void onEnable()
	{
		Poker._instance = this;	
		
		//PluginManager pm = getServer().getPluginManager();
		//pm.registerEvent(paramType, paramListener, paramPriority, paramPlugin);
		
		//getServer().getScheduler().scheduleAsyncDelayedTask(this, paramRunnable)
		
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("You must be a player to do that");
			return true;
		}

		Player player = ((Player) sender);
		

		if(cmd.getName().equalsIgnoreCase("create")) 
		{
			return ServerCommandOperator.createCommand(player, cmd, commandLabel, args);
		}		
		else if(cmd.getName().equalsIgnoreCase("join")) 
		{
			return ServerCommandOperator.joinCommand(player, cmd, commandLabel, args);
		}
		
		ServerCommandOperator.usageCommand(player);
		return false;
		
	}
	
	

	

}
