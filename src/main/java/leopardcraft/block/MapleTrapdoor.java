package leopardcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapDoorBlock;

public class MapleTrapdoor extends TrapDoorBlock {

	public MapleTrapdoor() {
		super(Block.Properties.from(Blocks.JUNGLE_TRAPDOOR));
		this.setRegistryName("maple_trapdoor");
	}
	
}