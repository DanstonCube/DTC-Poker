package com.danstoncube.tools.banque;

import com.iConomy.iConomy;
import java.util.logging.Level;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class iConomy5Balance extends Balance
{
	private iConomy iconomy;
	private Plugin p;

	public iConomy5Balance(Plugin p, iConomy iconomy)
	{
		super(p);
		this.p = p;
	}
	
	public boolean hasEnough(Player p, double amount) 
	{
		try 
		{
			return iConomy.getAccount(p.getName()).getHoldings().hasEnough(amount);
		} 
		catch (NullPointerException npe) 
		{
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
		
		return false;
	}

	public boolean hasEnough(String p, double amount) 
	{
		try 
		{
			return iConomy.getAccount(p).getHoldings().hasEnough(amount);
		} 
		catch (NullPointerException npe) 
		{
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
		
		return false;
	}

	public boolean isEnabled()
	{
		return this.iconomy.isEnabled();
	}

	public void add(Player p, double amount) {
		try {
				add(p.getName(), amount);
		} catch (NullPointerException npe) {
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
	}

	public void add(String p, double amount) 
	{
		try 
		{
			iConomy.getAccount(p).getHoldings().add(amount);
		}
		catch (NullPointerException npe) 
		{
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
	}
 
	public void sub(Player p, double amount) 
	{
		try 
		{
			sub(p.getName(), amount);
		} 
		catch (NullPointerException npe) 
		{
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
	}

	public void sub(String p, double amount) 
	{
		try 
		{
			iConomy.getAccount(p).getHoldings().subtract(amount);
		}
		catch (NullPointerException npe) 
		{
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
	}

	public String getClassName() 
	{
		return iConomy.class.getName();
	}

	public double balance(String paramString) 
	{
		
		try 
		{
			return iConomy.getAccount(paramString).getHoldings().balance();
		} 
		catch (NullPointerException npe) 
		{
			this.p.getServer().getLogger().log(Level.WARNING, "[com.danstoncube.tools.banque.iConomy5Balance] NullPointerException: " + npe.getMessage());
		}
		
		return -1;
	} 


}

