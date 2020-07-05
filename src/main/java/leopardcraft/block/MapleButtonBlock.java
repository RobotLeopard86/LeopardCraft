package leopardcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodButtonBlock;

public class MapleButtonBlock extends WoodButtonBlock {

	public MapleButtonBlock() {
		super(Block.Properties.from(Blocks.JUNGLE_BUTTON));
		this.setRegistryName("maple_button");
	}
	
}