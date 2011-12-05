package com.danstoncube.poker.plugin.gui;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PokerGameCreateGuiScreenListener extends ScreenListener 
{
		/**
		 * Handles a button click event
		 *
		 * @param event the event
		 */
		@Override
		public void onButtonClick(ButtonClickEvent event) 
		{
			SpoutPlayer player = event.getPlayer();
			
			PokerPlayerGui popup = (PokerPlayerGui) player.getMainScreen().getActivePopup();
			
			if(popup == null)
				return;
			
					
			popup.close();		
		}
}