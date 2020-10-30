package leopardcraft.util;

import leopardcraft.base.LeopardCraft;
import leopardcraft.block.IntegerContainerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DataWriter {
	
	private BlockPos pos;
	
	public DataWriter(BlockPos pos) {
		this.pos = pos;
	}
	
	public void write(DataResult<?> data) {
		
		World world = LeopardCraft.minecraft.world.getWorld();
		
		if(data.val instanceof Integer) {
			world.setBlockState(pos, world.getBlockState(pos).with(IntegerContainerBlock.valueProperty, (Integer)data.val));
		}
		
	}
}