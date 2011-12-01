package com.danstoncube.poker.server.customblocks;

import org.getspout.spoutapi.block.design.Texture;
import com.danstoncube.poker.Poker;

public class PokerTable
{
	private static Texture _texture;
	
	
	public final static String texture_url = "http://dl.dropbox.com/u/15091039/table.png"; //TODO
	
	
	
	
	public static void createTexture()
	{
		_texture = new Texture(Poker.getInstance(), texture_url, 4096, 4096, 256);
	}
	
	public static Texture getTexture()
	{
		return _texture;
	}
	
}
