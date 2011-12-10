package com.danstoncube.poker.plugin.game;

import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerGameListener;
import com.danstoncube.poker.game.PokerHand;
import com.danstoncube.poker.game.PokerPlayer;
import com.danstoncube.poker.game.PokerStep;
import com.danstoncube.poker.plugin.Poker;
import com.danstoncube.poker.plugin.packets.PlayerActionPacket;

public class GameListener  implements PokerGameListener
{
	
	private GameOperator gameop = null;

			
	public GameListener(GameOperator gameOperator)
	{
		this.setGameop(gameOperator);
	}
			
	

	

	@Override
	public void onNextHand(PokerHand newhand)
	{
		//Send packet to clients to let them know hand changed
		
		 
		
	}

	@Override
	public void onGameCreated()
	{
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	@Override
	public void onGameStarted()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGameFinished()
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPlayerChanged(PokerPlayer player)
	{
		// TODO Auto-generated method stub
		
	}

	public GameOperator getGameop()
	{
		return gameop;
	}


	public void setGameop(GameOperator gameop)
	{
		this.gameop = gameop;
	}


	@Override
	public void onPlayerAction(PokerPlayer pokerPlayer,
			PlayerActionEnum action, double chipsamount)
	{
		
		//Prepare packet pour notification autres joueurs
		PlayerActionPacket packet = new PlayerActionPacket();
		packet.setPlayer(pokerPlayer).setPlayerAction(action).setChipsAmount(chipsamount);
		
		//Il faudra envoyer le packet aux autres joueurs également
		//TODO: packet.send(this.getSpoutplayersToWarnCollection()
	}





	@Override
	public void onNextStep(PokerStep newStep)
	{
		// TODO Auto-generated method stub
		
	}





	

	

}
