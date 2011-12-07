package com.danstoncube.poker.plugin;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.danstoncube.poker.plugin.game.GameManager;

public class Poker extends JavaPlugin
{

	private static Poker _instance = null;
	
	private GameManager _gamemanager = new GameManager();

	public Logger log;
	public String logPrefix = "[Poker] ";
	public String chatPrefix = "[Poker] ";

	public static Poker getInstance()
	{
		return _instance;
	}

	public static GameManager getGameManager()
	{
		return _instance._gamemanager;
	}
	
	@Override
	public void onDisable()
	{
		Poker._instance = null;
		//TODO: finire proprement les parties en cours
		log.info(logPrefix + "disabled !");
	}

	@Override
	public void onEnable()
	{
		Poker._instance = this;	
		
		log = getServer().getLogger();

		PluginManager pm = getServer().getPluginManager();
				
		//pour être au courant de l'activation/désactivation d'autres plugins (iConomy surtout)
        pm.registerEvent(Event.Type.PLUGIN_ENABLE, new PluginListener(), Priority.Monitor, this);
        pm.registerEvent(Event.Type.PLUGIN_DISABLE, new PluginListener(), Priority.Monitor, this);
       
		//getServer().getScheduler().scheduleAsyncDelayedTask(this, paramRunnable)
        
        //CustomBlocks moved in addon ? 
        /*
        CustomBlocks.precacheTextures();
        CustomBlocks.loadTextures();
        CustomBlocks.createBlocks();
        CustomBlocks.createRecipes();
		*/
        
        
        //CardWidget.precacheTexture();
      
        
		log.info(logPrefix + "enabled !");
        
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("You must be a player to do that");
			return true;
		}

		Player player = ((Player) sender);
		

		if(cmd.getName().equalsIgnoreCase("create") || cmd.getName().equalsIgnoreCase("pokercreate")) 
		{
			return CommandOperator.createCommand(player, cmd, commandLabel, args);
		}		
		else if(cmd.getName().equalsIgnoreCase("join") || cmd.getName().equalsIgnoreCase("pokerjoin")) 
		{
			return CommandOperator.joinCommand(player, cmd, commandLabel, args);
		}
		
		CommandOperator.usageCommand(player);
		return false;
		
	}
	
	

	

}
