package leopardcraft.block;

import leopardcraft.base.blocks.LCBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class MapleWood extends AxisBlock {
	
	public MapleWood(Properties properties) {
		super(properties);
		setDefaultState(stateContainer.getBaseState().with(axisProperty, Direction.Axis.Y));
		
	}
	
	@Override
	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		return activationCode(state, world, position, player, hand);
	}
	
	public ActionResultType activationCode(BlockState state, World world, BlockPos position, PlayerEntity player, Hand hand) {
		if(!world.isRemote) {
			if(player.getHeldItem(hand).getItem() == Items.WOODEN_AXE || player.getHeldItem(hand).getItem() == Items.STONE_AXE || player.getHeldItem(hand).getItem() == Items.IRON_AXE || player.getHeldItem(hand).getItem() == Items.GOLDEN_AXE || player.getHeldItem(hand).getItem() == Items.DIAMOND_AXE) {
				LOGGER.info("Has axe");
				world.getWorld().setBlockState(position, LCBlocks.strippedMapleWood.get().getDefaultState().with(AxisBlock.axisProperty, state.get(AxisBlock.axisProperty)));
			}
		}
		return ActionResultType.SUCCESS;
	}
	
}