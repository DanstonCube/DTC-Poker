package com.danstoncube.poker.plugin.customblocks.table;

import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;

import com.danstoncube.poker.plugin.Poker;
import com.danstoncube.poker.plugin.customblocks.PokerTable;


public class PokerTableDesign extends GenericCubeBlockDesign 
{

	public PokerTableDesign() 
	{
		super(Poker.getInstance(), PokerTable.getTexture(), new int[] { 1, 0, 0, 0, 0, 1 });
		this.setMinBrightness(1F).setMaxBrightness(1F);
	}
	
	public float getX(int degrees) {
		return (float) (0.5 + (0.5 * Math.cos(Math.toRadians(degrees))));
	}
	
	public float getZ(int degrees) {
		return (float) (0.5 + (0.5 * Math.sin(Math.toRadians(degrees))));
	}
	

}

