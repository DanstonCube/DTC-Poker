package tests;
import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.game.PokerGame;
import com.danstoncube.poker.game.PokerPlayer;
import com.danstoncube.poker.server.ServerGameManager;


public class testgame
{

	public static void main(String[] args)
	{
		ServerGameManager gamemgr = new ServerGameManager();
		
		//Nouvelle partie
		PokerGame currentGame = gamemgr.startNewGame(2,8);		
		
		//Ajoute 4 joueurs
		currentGame.addPlayer(new PokerPlayer("toto"), 0, 1500);
		currentGame.addPlayer(new PokerPlayer("titi"), 2, 1500);
		currentGame.addPlayer(new PokerPlayer("tutu"), 3, 1500);
		currentGame.addPlayer(new PokerPlayer("tata"), 6, 1500);
		
		//initialise une main (debutte la partie)
		currentGame.nextHand();
		
		//debug: affiche les cartes des joueurs		
		for(PokerPlayer p : currentGame.players)
		{
			if(p==null)
			{
				System.out.println("AUCUN JOUEUR");
				continue;
			}			
			System.out.println(p.getPlayerName() + ": " + p.cards[0] + "-" + p.cards[1]);
		}
		
		System.out.println("-------------------------");

		System.out.println("Dealer: " + currentGame.hand.dealer.getPlayerName());		
		System.out.println("Small blind: " + currentGame.hand.sbplayer.getPlayerName());
		System.out.println("Big blind: " + currentGame.hand.bbplayer.getPlayerName());
		
		System.out.println("-------------------------");
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		currentGame.nextPlayer();
		
		System.out.println("Au tour de " + currentGame.getPlayer().getPlayerName());
		
		//On passe au flop
		currentGame.nextStep();
		
		String flopStepFlop = "";
		for(CardEnum card : currentGame.hand.flop)
		{
			if(card!=null)
				flopStepFlop += card.getDisplay();
		}
		
		System.out.println("FLOP: " + flopStepFlop);		
		
		//on passe a la turn
		currentGame.nextStep();
		
		String flopStepTurn = "";
		for(CardEnum card : currentGame.hand.flop)
		{
			if(card!=null)
				flopStepTurn += card.getDisplay();
		}
		
		System.out.println("FLOP: " + flopStepTurn);		
		
		//on passe a la river
		currentGame.nextStep();
		
		String flopStepRiver = "";
		for(CardEnum card : currentGame.hand.flop)
		{
			if(card!=null)
				flopStepRiver += card.getDisplay();
		}
		
		System.out.println("FLOP: " + flopStepRiver);		
		
		currentGame.nextStep();
		
		
		
	}
	
	
	
	
	
	
	
	

}
