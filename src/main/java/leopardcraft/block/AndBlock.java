package leopardcraft.block;

import leopardcraft.te.AndBlockTileEntity;
import leopardcraft.util.LeopardCraftHelpers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;

public class AndBlock extends LCRedstoneBlock {
	
	public static final EnumProperty<LeopardCraftHelpers.HorizontalAxis> axis = EnumProperty.create("axis", LeopardCraftHelpers.HorizontalAxis.class);

	public AndBlock() {
		super();
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new AndBlockTileEntity();
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if(context.getNearestLookingDirection().getAxis() == Direction.Axis.X) {
			return stateContainer.getBaseState().with(axis, LeopardCraftHelpers.HorizontalAxis.X);
		} else if(context.getNearestLookingDirection().getAxis() == Direction.Axis.Z) {
			return stateContainer.getBaseState().with(axis, LeopardCraftHelpers.HorizontalAxis.Z);
		} else {
			return null;
		}
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(axis);
		super.fillStateContainer(builder);
	}
}