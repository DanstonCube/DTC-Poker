package com.danstoncube.poker.server;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.Poker;

public class ServerCustomSounds
{
	public static final String yourTurnUrl = "http://dl.dropbox.com/u/15091039/jingle_sncf.ogg"; //TODO: trouver un son

	public static void playYourTurnSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.yourTurnUrl, false) ;
	}
	
}
