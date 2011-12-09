
package com.danstoncube.poker.plugin;

import com.nijikokun.register.payment.Method;
import com.nijikokun.register.payment.Method.MethodAccount;
import com.nijikokun.register.payment.Methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Economy 
{
    
    private static Method payementMethod;
    private static boolean enabled = false;

	/**
	* Constructor of Economy.
	*/
    public Economy(Poker plugin) {       
        if(getMethod()!=null)
        	enabled = true;
        
        plugin.log.info(plugin.logPrefix + "Hooked into " + payementMethod.getName());
    }

	/**
	* Checks the economy enabled-state of the plugin.
	*
	* @return True if economy is enabled
	*/
	public static boolean checkEconomy() {     
		return (getMethod() != null);
	}


    private static boolean subtract(Player player, int amount) 
    {
        MethodAccount balance = payementMethod.getAccount(player.getName());
        if (!balance.hasEnough(amount)) {
            return false;
        }
        balance.subtract(amount);
        return true;
    }
    
    private static boolean credit(Player player, int amount) 
    {
        MethodAccount balance = payementMethod.getAccount(player.getName());
        balance.add(amount);
        return true;
    }
    	

    public static Method getMethod() {
        if (payementMethod == null) {
            Methods.setMethod(Bukkit.getServer().getPluginManager());
            payementMethod = Methods.getMethod();
        }
        return payementMethod;
    }
}

		