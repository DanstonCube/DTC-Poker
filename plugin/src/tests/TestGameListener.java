package tests;

import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerGameListener;
import com.danstoncube.poker.game.PokerHand;
import com.danstoncube.poker.game.PokerPlayer;
import com.danstoncube.poker.game.PokerStep;

public class TestGameListener implements PokerGameListener
{

	@Override
	public void onGameCreated()
	{
		// TODO Auto-generated method stub
		System.out.println("EVENT: onGameCreated");
	}

	@Override
	public void onGameStarted()
	{
		// TODO Auto-generated method stub
		System.out.println("EVENT: onGameStarted");
	}

	@Override
	public void onGameFinished()
	{
		// TODO Auto-generated method stub
		System.out.println("EVENT: onGameFinished");
	}

	@Override
	public void onNextHand(PokerHand newhand)
	{
		// TODO Auto-generated method stub
		System.out.println("EVENT: onNextHand");
	}

	@Override
	public void onNextStep(PokerStep newStep)
	{
		// TODO Auto-generated method stub
		System.out.println("EVENT: onNextStep");
	}

	

	@Override
	public void onPlayerChanged(PokerPlayer player)
	{
		System.out.println("EVENT: onPlayerChanged -> Au tour de: " + player.getPlayerName());		
	}

	@Override
	public void onPlayerAction(PokerPlayer pokerPlayer,
			PlayerActionEnum action, double chipsAmount)
	{
		// TODO Auto-generated method stub
		System.out.println("EVENT: onPlayerAction -> " + pokerPlayer.getPlayerName() + "=" + action.toString() + " (" + chipsAmount + ")");
	}

}
