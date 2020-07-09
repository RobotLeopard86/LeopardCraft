package leopardcraft.block;

import leopardcraft.base.LeopardCraft;
import leopardcraft.te.MapleLogTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
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

public class MapleLog extends DirectionalBlock {

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
		return super.placementStateGetter(context, true);
	}
	
	@Override
	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		return activationCode(state, world, position, player, hand);
	}
	
	public ActionResultType activationCode(BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand) {
		if(!world.isRemote) {
			if(player.getHeldItem(hand).getItem() == Items.WOODEN_AXE || player.getHeldItem(hand).getItem() == Items.STONE_AXE || player.getHeldItem(hand).getItem() == Items.IRON_AXE || player.getHeldItem(hand).getItem() == Items.GOLDEN_AXE || player.getHeldItem(hand).getItem() == Items.DIAMOND_AXE) {
				LOGGER.info("Has axe");
				world.getWorld().setBlockState(position, LeopardCraft.strippedMapleLog.getDefaultState().with(DirectionalBlock.axisProperty, state.get(DirectionalBlock.axisProperty)));
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