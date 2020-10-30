package leopardcraft.util;

import leopardcraft.base.LeopardCraft;
import leopardcraft.block.IntegerContainerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DataReader {
	
	private BlockPos pos;
	
	public DataReader(BlockPos pos) {
		this.pos = pos;
	}
	
	public DataResult<Integer> receiveInt() {
		World world = LeopardCraft.minecraft.world.getWorld();
		
		if(!(world.getBlockState(pos).getBlock() instanceof IntegerContainerBlock)) {
			return new DataResult<Integer>();
		}
		
		int value = world.getBlockState(pos).get(IntegerContainerBlock.valueProperty);
		
		return new DataResult<Integer>(value);
	}
}