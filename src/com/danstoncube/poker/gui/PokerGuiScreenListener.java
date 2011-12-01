package com.danstoncube.poker.gui;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.player.SpoutPlayer;


public class PokerGuiScreenListener extends ScreenListener 
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
			
			PokerGui popup = (PokerGui) player.getMainScreen().getActivePopup();
			
			if(popup == null)
				return;
			
					
			popup.close();		
		}
}