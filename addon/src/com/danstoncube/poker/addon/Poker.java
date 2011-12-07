package com.danstoncube.poker.addon;

import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.addon.java.JavaAddon;

import com.danstoncube.poker.addon.game.Game;
import com.danstoncube.poker.addon.gui.PokerPlayerGui;

public class Poker extends JavaAddon
{

	public static Poker _instance = null;
	
	private Game game = new Game();
	
	
	public static Poker getAddon()
	{
		return _instance;
	}
	
	public static Poker getInstance()
	{
		return _instance;
	}
	
	
	
	
	@Override
	public void onDisable()
	{
		// TODO Auto-generated method stub
		Spoutcraft.getLogger().info("POKER - désactivé");
		
	}

	@Override
	public void onEnable()
	{
		_instance = this;
		// TODO Auto-generated method stub
		//Spoutcraft.getActivePlayer().getMainScreen().attachWidget(this, new CardWidget(CardEnum.AS_DIAMONDS).setX(20).setY(20));
		
		Spoutcraft.getLogger().info("POKER - activé");
		new PokerPlayerGui();
		
		
		//Player p = null;
		
		//Spoutcraft.getAddonManager().
		
		//Spoutcraft.getKeyBindingManager().registerControl(new KeyBinding(Keyboard.KEY_P))
		
	}

	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}
 
}
