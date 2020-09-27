package leopardcraft.block;

import leopardcraft.te.TFlipFlopTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;

public class TFlipFlopBlock extends LCRedstoneBlock {
	
	public static final	DirectionProperty facing = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	
	public TFlipFlopBlock() {
		super();
		this.getStateContainer().getBaseState().with(facing, Direction.NORTH);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world){
		return new TFlipFlopTileEntity();
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if(context.getNearestLookingDirection() == Direction.UP || context.getNearestLookingDirection() == Direction.DOWN) {
			return null;
		}
		return stateContainer.getBaseState().with(facing, context.getNearestLookingDirection());
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(facing);
		super.fillStateContainer(builder);
	}

}