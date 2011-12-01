package com.danstoncube.poker;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.danstoncube.poker.gui.PokerGameCreateGuiScreenListener;
import com.danstoncube.poker.gui.PokerPlayerGuiScreenListener;
import com.danstoncube.poker.server.ServerCommandOperator;
import com.danstoncube.poker.server.ServerGameManager;

public class Poker extends JavaPlugin
{

	private static Poker _instance = null;
	
	private ServerGameManager _gamemanager = new ServerGameManager();

	public Logger log;
	public String logPrefix = "[Poker] ";

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
		
		log = getServer().getLogger();

		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.CUSTOM_EVENT, new PokerPlayerGuiScreenListener(), Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, new PokerGameCreateGuiScreenListener(), Priority.Normal, this);
		
		//pour être au courant de l'activation/désactivation d'autres plugins (iConomy surtout)
        pm.registerEvent(Event.Type.PLUGIN_ENABLE, this.serverListener, Priority.Monitor, this);
        pm.registerEvent(Event.Type.PLUGIN_DISABLE, this.serverListener, Priority.Monitor, this);
       
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
