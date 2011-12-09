package com.danstoncube.poker.addon.customblocks.table;

import org.spoutcraft.spoutcraftapi.block.design.GenericCubeBlockDesign;
import org.spoutcraft.spoutcraftapi.material.Block;

import com.danstoncube.poker.addon.Poker;
import com.danstoncube.poker.addon.customblocks.PokerTable;



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
	
	@Override
	public boolean renderBlock(Block arg0, int arg1, int arg2, int arg3)
	{
		// TODO Auto-generated method stub
		//return super.renderBlock(arg0, arg1, arg2, arg3);
		
		
		
		return true;
	}
}

