package com.danstoncube.poker.plugin;


import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;

import com.danstoncube.tools.banque.DummyBalance;


 

public class PluginListener extends ServerListener {

	private Poker plugin;

    public PluginListener(Poker plugin) {
        this.plugin = plugin;
    }

    public PluginListener() {
        this.plugin = Poker.getInstance();
    }
    
    @Override
    public void onPluginDisable(PluginDisableEvent event) 
    {
    	
    	if (EconomyHandler.balance != null) 
    	{
            if (event.getPlugin().getDescription().getName().equals("iConomy"))
            {
            	EconomyHandler.balance = new DummyBalance(this.plugin);
            	EconomyHandler.currencyEnabled = false;
                plugin.log.info(plugin.logPrefix + Messages.getString("Econ.UNHOOKED"));
            }
        }
    	
    	
    }

    @Override
    public void onPluginEnable(PluginEnableEvent event) 
    {
		//On teste si iConomy est up
		if (EconomyHandler.balance == null) 
		{
			EconomyHandler.setupEconomy();
		}
    }
}