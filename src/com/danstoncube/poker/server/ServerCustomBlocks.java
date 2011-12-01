package com.danstoncube.poker.server;

import org.getspout.spoutapi.SpoutManager;


import com.danstoncube.poker.Poker;
import com.danstoncube.poker.server.customblocks.PokerTable;
import com.danstoncube.poker.server.customblocks.table.PokerTableBlock;


public class ServerCustomBlocks
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
