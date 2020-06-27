package leopardcraft;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;

public class MapleStairs extends StairsBlock {

	public MapleStairs() {
		super(LeopardCraft.maplePlanksBlock.getDefaultState(), Block.Properties.from(Blocks.JUNGLE_STAIRS));
		this.setRegistryName("maple_stairs");
	}
	
}