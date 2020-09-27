package leopardcraft.block;

import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.te.MapleLogTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItemUseContext;
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

public class MapleLog extends AxisBlock {

	public static final IntegerProperty sapState = IntegerProperty.create("sap", 0, 3);
	
	public MapleLog(Properties properties) {
		super(properties);
		setDefaultState(stateContainer.getBaseState().with(axisProperty, Direction.Axis.Y).with(sapState, 3));
		
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(sapState);
		super.fillStateContainer(builder);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return stateContainer.getBaseState().with(axisProperty, context.getFace().getAxis()).with(sapState, 3);
	}
	
	@Override
	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		return activationCode(state, world, position, player, hand);
	}
	
	public ActionResultType activationCode(BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand) {
		if(!world.isRemote) {
			if(player.getHeldItem(hand).getItem() instanceof AxeItem) {
				LOGGER.info("Has axe");
				world.getWorld().setBlockState(position, LCBlocks.strippedMapleLog.get().getDefaultState().with(AxisBlock.axisProperty, state.get(AxisBlock.axisProperty)));
			} else {
				return ActionResultType.PASS;
			}
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new MapleLogTileEntity();
	}
	
}