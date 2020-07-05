package leopardcraft.block;

import leopardcraft.tree.MapleTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;

public class MapleSapling extends SaplingBlock {

	public MapleSapling() {
		super(new MapleTree(), Block.Properties.from(Blocks.JUNGLE_SAPLING));
		this.setRegistryName("maple_sapling");
	}
	
}