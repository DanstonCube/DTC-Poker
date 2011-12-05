package com.danstoncube.tools.banque;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DummyBalance extends Balance
{
	public DummyBalance(Plugin p) {
		super(p);
	}

	public void add(Player p, double amount) {
	}
	
	public void add(String p, double amount) {
	}

	public void sub(Player p, double amount) {
	}

	public void sub(String p, double amount) {  		
	}

	public boolean hasEnough(Player p, double amount) { 
		return true; 
	}
 
	public String getClassName() {
		return getClass().getName();
	}
 
	public boolean isEnabled() {
		return true;
	}

	public boolean hasEnough(String paramString, double paramDouble) {
		return false;
	}

	public double balance(String paramString) {
		return 0;
	} 

}