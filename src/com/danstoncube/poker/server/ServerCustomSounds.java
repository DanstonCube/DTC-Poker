package com.danstoncube.poker.server;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.Poker;

public class ServerCustomSounds
{
	public static final String yourTurnUrl = "http://dl.dropbox.com/u/15091039/poker_yourturn.ogg";
	public static final String timeoutAlarmUrl = "http://dl.dropbox.com/u/15091039/poker_warningtimeout.ogg";
	public static final String foldUrl = "http://dl.dropbox.com/u/15091039/poker_fold.ogg";	
	public static final String betUrl = "http://dl.dropbox.com/u/15091039/poker_bet.ogg";
	public static final String drawUrl = "http://dl.dropbox.com/u/15091039/poker_draw.ogg";
	public static final String checkUrl = "http://dl.dropbox.com/u/15091039/poker_check.ogg";
	public static final String endUrl = "http://dl.dropbox.com/u/15091039/poker_end.ogg";
	
	
	
	public static void playYourTurnSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.yourTurnUrl, false) ;
	}
	
	public static void playTimeoutAlarmSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.timeoutAlarmUrl, false) ;
	}
	
	public static void playFoldSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.foldUrl, false) ;
	}
	
	public static void playCheckSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.checkUrl, false) ;
	}
	
	public static void playBetSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.betUrl, false) ;
	}
	
	public static void playDrawSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.drawUrl, false) ;
	}
	
	public static void playEndSound(SpoutPlayer player)
	{
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), player, ServerCustomSounds.endUrl, false) ;
	}
	
}
