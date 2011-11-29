package com.danstoncube.Poker;

import org.bukkit.plugin.java.JavaPlugin;

public class Poker extends JavaPlugin
{

	private static Poker _instance = null;
	
	private PokerGameManager _gamemanager = new PokerGameManager();

	public static Poker getInstance()
	{
		return _instance;
	}

	public static PokerGameManager getGameManager()
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
	}

	

	

}
