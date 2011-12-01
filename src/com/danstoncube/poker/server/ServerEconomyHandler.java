package com.danstoncube.poker.server;

import org.bukkit.plugin.Plugin;

import com.danstoncube.poker.Poker;
import com.danstoncube.tools.banque.iConomy5Balance;
import com.danstoncube.tools.banque.iConomy6Balance;
import com.danstoncube.tools.banque.DummyBalance;
import com.danstoncube.tools.banque.Balance;

public class ServerEconomyHandler 
{
	public static Balance balance = null;
	
	public static String currencyName = "Econ.CURRENCY";
	
	public final static String noConomyErr = "Econ.NOECONERR";
	public final static String noAccountErr = "Econ.NOACCOUNTERR";
	public final static String noFundsErr = "Econ.NOFUNDSERR";
	public final static String oddErr = "Econ.UNKNOWNERR";

	public static boolean currencyEnabled = false;
	
	
	
	public static void setupEconomy() 
	{
		Poker plugin = Poker.getInstance();
		
		for (Plugin p : plugin.getServer().getPluginManager().getPlugins())
		{
			
			// Testing for iConomy6
			if (p.getClass().getName().equals("com.iCo6.iConomy"))
			{
				plugin.log.info(plugin.logPrefix + "Econ.ICO6_HOOKED");
				balance = new iConomy6Balance(plugin, (com.iCo6.iConomy)p);
				currencyEnabled = true;
				return;
      		}
			
			// Testing for iConomy5
			if (p.getClass().getName().equals("com.iConomy.iConomy"))
			{
				plugin.log.info(plugin.logPrefix + "Econ.ICO5_HOOKED"); 
				balance = new iConomy5Balance(plugin, (com.iConomy.iConomy)p);
				currencyEnabled = true;
				return;
			}
			
		}
		
		// No economy system found
		if(balance == null)
		{
			balance = new DummyBalance(plugin);
			plugin.log.severe(plugin.logPrefix + "Econ.NOECONHOOKED"); //$NON-NLS-1$
			currencyEnabled = false;
		}
		
	}

	
	public static int hasEnough(String p, double amount) 
	{
		// returns -3 if something odd happened
		// returns -2 if account doesnt have enough
		// returns -1 if no money system
		// returns 0 if the player account can't be found
		// returns +1 if successful
		
		if (!currencyEnabled){
			return -1;
		}
		
		if(balance != null)
		{
			if(!balance.hasEnough(p, amount))
			{
				return -2;
			}
			else
			{
				return 1;
			}
		}
		else
		{
			return -3;
		}
		
		
		/*
		if (iconomy != null){
			if (!(iConomy.hasAccount(pName))){
				return 0;
			}
			
			if (iConomy.getAccount(pName).getHoldings().hasEnough(amount))
				return 1;
			else return -2;
		}
		
		return -3;
		*/
	}
	
	
	
	//@SuppressWarnings("deprecation")
	public static int modifyMoney(String pName, Double costAmount) 
	{
		// returns -3 if something odd happened.
		// returns -2 if they don't have enough money.
		// returns -1 if no money system
		// returns 0 if the player account can't be found
		// returns +1 if successful
		if (!currencyEnabled)
		{
			return -1;
		}
		
		if(balance != null)
		{
			
			if(costAmount > -1)
			{
				balance.add(pName, costAmount);
			}
			else
			{
				if(balance.hasEnough(pName, costAmount))
				{
					balance.add(pName, costAmount);
				}
				else
				{
					return -2;
				}
			}
			
			return 1;
			
		}

		return -3;
	}
	
	

	@Deprecated
	public static int modifyMoney(String pName, Integer costAmount) 
	{
		return modifyMoney(pName, Double.parseDouble(Integer.toString(costAmount)));
	}
	
	public static String playerBalance(String pName) 
	{	
		if(balance != null)
		{
			return ServerEconomyHandler.formatMoney(balance.balance(pName)) +  ServerEconomyHandler.formatCurrency(balance.balance(pName));
		}		
		return noConomyErr;
	}

	public static String playerHave(String pName) 
	{		
		if(balance != null)
		{
			return Double.toString(balance.balance(pName));
		}		
		return noConomyErr;
	}

	public static String getEconError(int econ) 
	{
		if (econ == 0)
			return "Econ.NOFUNDSERR2";
		if (econ == -1)
			return noConomyErr;
		if (econ == -2)
			return "Econ.NOFUNDSERR3";
		if (econ == -3)
			return oddErr;
		return "Econ.UNKNOWNERR2";
	}
	
	public static String formatCurrency(Double getAmount)
	{
		//TODO: demander le nom de la currency a iconomy
		return "Eu" + (getAmount > 1 ? "s":"");
	}


	public static String formatMoney(Double money)
	{
		float y = (float) (money * 10.0);
		int i =(int) y;
		int mod = i % 10;
		 
		if(mod == 0)
		   return String.valueOf(i/10);

		return String.valueOf(i/10) + "." + mod;
	}
	
	
	
	
	
}
