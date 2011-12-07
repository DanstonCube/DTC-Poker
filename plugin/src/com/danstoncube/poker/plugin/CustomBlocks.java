package com.danstoncube.poker.plugin;

import org.getspout.spoutapi.SpoutManager;


import com.danstoncube.poker.plugin.customblocks.PokerTable;
import com.danstoncube.poker.plugin.customblocks.table.PokerTableBlock;


public class CustomBlocks
{
	public static PokerTableBlock pokerTableBlock;

	
	
	public static void precacheTextures()
	{
		SpoutManager.getFileManager().addToPreLoginCache(Poker.getInstance(), PokerTable.texture_url);
		
	}
	
	public static void loadTextures()
	{
		PokerTable.createTexture();
	}
	
	
	public static void createBlocks()
	{
		pokerTableBlock = new PokerTableBlock();
	}
	
	
	
	
	public static void createRecipes()
	{		
		SpoutManager.getMaterialManager().registerSpoutRecipe(pokerTableBlock.createRecipe());
	}
	
	
}
