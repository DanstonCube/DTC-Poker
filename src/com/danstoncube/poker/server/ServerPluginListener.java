package com.danstoncube.poker.server;


import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;

import com.danstoncube.poker.Messages;
import com.danstoncube.poker.Poker;
import com.danstoncube.tools.banque.DummyBalance;


 

public class ServerPluginListener extends ServerListener {

	private Poker plugin;

    public ServerPluginListener(Poker plugin) {
        this.plugin = plugin;
    }

   
    @Override
    public void onPluginDisable(PluginDisableEvent event) 
    {        
    	
    	if (ServerEconomyHandler.balance != null) 
    	{
            if (event.getPlugin().getDescription().getName().equals("iConomy"))
            {
            	ServerEconomyHandler.balance = new DummyBalance(this.plugin);
            	ServerEconomyHandler.currencyEnabled = false;
                plugin.log.info(plugin.logPrefix + Messages.getString("Econ.UNHOOKED"));
            }
        }    
    	
        /*
       	if (ServerEconomyHandler.permissions != null) 
       	{      		
               if (event.getPlugin().getDescription().getName().equals("Permissions"))  //$NON-NLS-1$
               {
            	   ServerPermissionsHandler.permissions = null;
            	   ServerPermissionsHandler.permissionsEnabled = false;
                   plugin.log.info(plugin.logPrefix + Messages.getString("Perm.UNHOOKED")); //$NON-NLS-1$
               }
        }    
       	*/
    	
    	
       	//TODO: desactiver showcase et webauction ???
       	

    }

    @Override
    public void onPluginEnable(PluginEnableEvent event) 
    {
		//On teste si iConomy est up
		if (ServerEconomyHandler.balance == null) 
		{
			ServerEconomyHandler.setupEconomy();
		}
    }
}