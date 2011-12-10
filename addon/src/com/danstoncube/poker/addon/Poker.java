package com.danstoncube.poker.addon;



import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.addon.java.JavaAddon;
import org.spoutcraft.spoutcraftapi.gui.Keyboard;
import org.spoutcraft.spoutcraftapi.keyboard.BindingExecutionDelegate;
import org.spoutcraft.spoutcraftapi.keyboard.KeyBinding;


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
			
		KeyBinding touchePoker = new KeyBinding(Keyboard.KEY_P.getKeyCode(), Poker.getAddon(), "ToucheP", "toto");
		
		BindingExecutionDelegate delegate = new BindingExecutionDelegate() 
		{
            @Override
            public void onKeyRelease(int paramInt, KeyBinding paramKeyBinding) {
            	
            }
            
            @Override
            public void onKeyPress(int paramInt, KeyBinding paramKeyBinding)
            {
            	//DEBUG: open popup gui on key press
            	new PokerPlayerGui();
            }
           
        };
        touchePoker.setDelegate(delegate);
        	
		Spoutcraft.getKeyBindingManager().registerControl(touchePoker);
		
		Spoutcraft.getLogger().info("POKER - activé");
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
