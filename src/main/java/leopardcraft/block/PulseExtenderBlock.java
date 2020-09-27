package leopardcraft.block;

import leopardcraft.te.PulseExtenderBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PulseExtenderBlock extends LCRedstoneBlock {
	
	public static final	DirectionProperty facing = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty length = IntegerProperty.create("length", 0, 400);
	
	public PulseExtenderBlock() {
		super();
		this.getStateContainer().getBaseState().with(facing, Direction.NORTH).with(length, 0);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new PulseExtenderBlockTileEntity();
	}
	
	@Override
	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		int incVal = state.get(length) + 10;
		if(incVal > 400) {
			incVal = 0;
		}
		world.setBlockState(pos, this.getDefaultState().with(facing, state.get(facing)).with(length, incVal));
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if(context.getNearestLookingDirection() == Direction.UP || context.getNearestLookingDirection() == Direction.DOWN) {
			return null;
		}
		return stateContainer.getBaseState().with(facing, context.getNearestLookingDirection()).with(length, 0);
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(facing, length);
		super.fillStateContainer(builder);
	}
}