package com.danstoncube.poker.addon.packets;


import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;

public class PlayersTurnPacket extends AddonPacket{

	
	private double _potsize = 0.0;
	
	@Override
	public void run() {
		System.out.println("Successfully Executed PlayersTurnPacket !");
	}

	@Override
	public void read(SpoutInputStream input) {
	
		double potSize = input.readDouble();
		
		this.setPotSize(potSize);
		
		System.out.println("it's your turn !");
		
		//TODO: beeep
		//TODO: show action buttons
	}

	@Override
	public void write(SpoutOutputStream output) {
		//Pas de write, le client n'envoi jamais ce paquet au serveur
	}

	public double getPotSize()
	{
		return _potsize;
	}

	public void setPotSize(double _potsize)
	{
		this._potsize = _potsize;
	}

}