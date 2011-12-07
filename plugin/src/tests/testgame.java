package tests;
import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerGame;
import com.danstoncube.poker.game.PokerPlayer;
import com.danstoncube.poker.plugin.GameManager;
import com.danstoncube.poker.plugin.GameOperator;


public class testgame
{

	public static void main(String[] args)
	{
		GameManager gamemgr = new GameManager();
		
		@SuppressWarnings("unused")
		TestGameListener listener = new TestGameListener();
		
		
		
		//Nouvelle partie
		GameOperator gameop = gamemgr.createNewGame(2,8,null);
		PokerGame game = gameop.getGame();
		
		//game.addPokerGameListener(listener);
		
		//Ajoute 4 joueurs
		game.addPlayer(new PokerPlayerHandler("toto"), 0, 1500);
		game.addPlayer(new PokerPlayerHandler("titi"), 2, 1500);
		game.addPlayer(new PokerPlayerHandler("tutu"), 3, 1500);
		game.addPlayer(new PokerPlayerHandler("tata"), 6, 1500);
		
		
		game.start();
		
		//initialise une main (debutte la partie)
		game.nextHand();
		
		//debug: affiche les cartes des joueurs		
		for(PokerPlayer p : game.getPlayers())
		{
			if(p==null)
			{
				System.out.println("AUCUN JOUEUR");
				continue;
			}			
			System.out.println(p.getPlayerName() + ": " + p.cards[0] + "-" + p.cards[1]);
		}
		
		System.out.println("-------------------------");

		
		/* 1er tour */
		
		
		DisplayGameStepInfo(game);
		
		
		
		
		//System.out.println("Au tour de " + game.getPlayer().getPlayerName());
		
		game.playerPlay(game.getCurrentPlayer(), PlayerActionEnum.FOLD, 0.0);
		
		System.out.println("Au tour de " + game.getPlayer().getPlayerName());
		
		game.playerPlay(game.getCurrentPlayer(), PlayerActionEnum.FOLD, 0.0);
		
		System.out.println("Au tour de " + game.getPlayer().getPlayerName());
		game.playerPlay(game.getCurrentPlayer(), PlayerActionEnum.CALL, 5.0);
		
		System.out.println("Au tour de " + game.getPlayer().getPlayerName());
		
		game.playerPlay(game.getCurrentPlayer(), PlayerActionEnum.CHECK, 0.0);

		
		//On passe au flop
		game.nextStep();
		
		/* 2EME TOUR */
		DisplayGameStepInfo(game);
		
		
	}
	
	
	
	private static void DisplayGameStepInfo(PokerGame game)
	{
		System.out.println("Step: " + game.getCurrentHand().getStep().getType());				
		System.out.println("Pot: " + game.getCurrentHand().getPot());
		System.out.println("Dealer: " + game.getCurrentHand().getDealer().getPlayerName());		
		System.out.println("Small blind: " + game.getCurrentHand().getSmallBlindPlayer().getPlayerName());
		System.out.println("Big blind: " + game.getCurrentHand().getBigBlindPlayer().getPlayerName());
		System.out.println("Au tour de: " + game.getPlayer().getPlayerName());

		String flopPreFlop = "";
		for(CardEnum card : game.getCurrentHand().getFlop())
		{
			if(card!=null)
			{
				if(flopPreFlop!="")
					flopPreFlop += "-";
				
				flopPreFlop += card;
			}
		}
		System.out.println("FLOP: " + flopPreFlop);		
		
		System.out.println("-------------------------");
	}
	
	
	
	
	
	

}
