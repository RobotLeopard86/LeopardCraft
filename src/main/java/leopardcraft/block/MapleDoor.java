package leopardcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;

public class MapleDoor extends DoorBlock {
	
	public MapleDoor() {
		super(Block.Properties.from(Blocks.JUNGLE_DOOR));
		this.setRegistryName("maple_door");
	}
}