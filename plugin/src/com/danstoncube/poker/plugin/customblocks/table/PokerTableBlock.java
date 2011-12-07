package com.danstoncube.poker.plugin.customblocks.table;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;


import com.danstoncube.poker.plugin.Poker;

public class PokerTableBlock extends GenericCustomBlock
{
	SpoutShapedRecipe recipe;
	
	public PokerTableBlock()
	{
		
		super(Poker.getInstance(), "PokerTableBlock");

		Bukkit.getServer().getLogger().info("PokerTableBlock");
		
		BlockDesign design = new PokerTableDesign();
		
		//ints are { bottom, north, ?, ?, ?, top }
		this.setBlockDesign(design);
		this.setHardness(10F);
		//this.
	}

	public SpoutShapedRecipe createRecipe()
	{
		String[] shapestring = new String[]{
			"bbb",
			"bbb",
			"b  "
		};
		
		ItemStack itemStack = new SpoutItemStack(this, 1);
		
		recipe = new SpoutShapedRecipe(itemStack);
		recipe.shape(shapestring).setIngredient('b', MaterialData.bedrock);		
		return recipe;
	}
	

	@Override
	public void onNeighborBlockChange(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4)
	{
	}
	
	
	@Override
	public void onBlockPlace(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, LivingEntity paramLivingEntity)
	{
	}
	
	@Override
	public void onBlockPlace(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3)
	{
	}

	

	
	@Override
	public void onBlockDestroyed(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3)
	{
	}

	
	
	@Override
	public boolean onBlockInteract(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, SpoutPlayer paramSpoutPlayer)
	{
		return false;	
	}

	@Override
	public void onEntityMoveAt(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, Entity paramEntity)
	{
	}

	@Override
	public void onBlockClicked(World paramWorld, int paramInt1, int paramInt2,
			int paramInt3, SpoutPlayer paramSpoutPlayer)
	{
	}

	@Override
	public boolean isProvidingPowerTo(World paramWorld, int paramInt1,
			int paramInt2, int paramInt3, BlockFace paramBlockFace)
	{
		return false;
	}
	
	@Override
	public boolean isIndirectlyProvidingPowerTo(World paramWorld,
			int paramInt1, int paramInt2, int paramInt3,
			BlockFace paramBlockFace)
	{
		return false;
	}

	@Override
	public void onBlockDestroyed(World arg0, int arg1, int arg2, int arg3,
			LivingEntity arg4)
	{
	}





	
}
