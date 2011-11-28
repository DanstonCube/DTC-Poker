package com.danstoncube.Poker;

import org.bukkit.plugin.java.JavaPlugin;

public class Poker extends JavaPlugin
{

	public static Poker _instance = null;
	
	
	
	
	
	public static Poker getInstance()
	{
		return _instance;
	}
	
	
	
	
	
	
	
	@Override
	public void onDisable()
	{
		// TODO Auto-generated method stub
		Poker._instance = null;
	}

	@Override
	public void onEnable()
	{
		// TODO Auto-generated method stub
		Poker._instance = this;
		
		
		//PokerGameManager();
		
	}

}
