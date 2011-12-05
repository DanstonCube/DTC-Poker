package com.danstoncube.poker.plugin.packets;




import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.io.SpoutInputStream;
import org.getspout.spoutapi.io.SpoutOutputStream;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PlayersTurnPacket extends AddonPacket{

	
	private SpoutPlayer _player = null;
	private double _potsize = 0.0;
	
	public PlayersTurnPacket(SpoutPlayer p, double potSize)
	{
		this._player = p;
		this._potsize = potSize;
	}
	
	@Override
	public void run(SpoutPlayer arg0)
	{
		// TODO Auto-generated method stub
		System.out.println("packet run for " + arg0.getName());
	}
	
	@Override
	public void read(SpoutInputStream input) {
		//Pas de read, on ne fait qu'en envoyer coté serveur
	}

	@Override
	public void write(SpoutOutputStream output) {		
		System.out.println("Packet sent: PlayersTurnPacket(" + _player + ", " + _potsize);
		output.writeString(_player.getName());
		output.writeDouble(_potsize);
	}

	public SpoutPlayer getPlayer()
	{
		return _player;
	}

	
	


}