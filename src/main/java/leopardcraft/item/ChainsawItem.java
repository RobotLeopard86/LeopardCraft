package leopardcraft.item;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.block.MapleLog;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

public class ChainsawItem extends Item {
	
	public Logger logger = LogManager.getLogger();
	
	public ChainsawItem() {
		super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).setNoRepair());
	}
	
	public List<BlockPos> findTreeBlocks(BlockPos pos, List<BlockPos> treeBlocks, ItemUseContext context) {
		if(!(context.getWorld().getBlockState(pos).getBlock() instanceof MapleLog) && !(context.getWorld().getBlockState(pos).getBlock() instanceof LogBlock) && !(context.getWorld().getBlockState(pos).getBlock() instanceof LeavesBlock) && !(context.getWorld().getBlockState(pos).getBlock() == LCBlocks.strippedMapleLog.get())) {
			return treeBlocks;
		}
		treeBlocks.add(pos);
		if(!treeBlocks.contains(pos.up())){
			if(!treeBlocks.contains(pos.up().west())) {
				findTreeBlocks(pos.up().west(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.up().east())) {
				findTreeBlocks(pos.up().east(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.up().south())) {
				findTreeBlocks(pos.up().south(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.up().north())) {
				findTreeBlocks(pos.up().north(), treeBlocks, context);
			}
			findTreeBlocks(pos.up(), treeBlocks, context);
		}
		if(!treeBlocks.contains(pos.down())){
			if(!treeBlocks.contains(pos.down().west())) {
				findTreeBlocks(pos.down().west(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.down().east())) {
				findTreeBlocks(pos.down().east(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.down().south())) {
				findTreeBlocks(pos.down().south(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.down().north())) {
				findTreeBlocks(pos.down().north(), treeBlocks, context);
			}
			findTreeBlocks(pos.down(), treeBlocks, context);
		}
		if(!treeBlocks.contains(pos.west())){
			if(!treeBlocks.contains(pos.west().up())) {
				findTreeBlocks(pos.west().up(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.west().down())) {
				findTreeBlocks(pos.west().down(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.west().south())) {
				findTreeBlocks(pos.west().south(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.west().north())) {
				findTreeBlocks(pos.west().north(), treeBlocks, context);
			}
			findTreeBlocks(pos.west(), treeBlocks, context);
		}
		if(!treeBlocks.contains(pos.east())){
			if(!treeBlocks.contains(pos.east().up())) {
				findTreeBlocks(pos.east().up(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.east().down())) {
				findTreeBlocks(pos.east().down(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.east().south())) {
				findTreeBlocks(pos.east().south(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.east().north())) {
				findTreeBlocks(pos.east().north(), treeBlocks, context);
			}
			findTreeBlocks(pos.east(), treeBlocks, context);
		}
		if(!treeBlocks.contains(pos.south())){
			if(!treeBlocks.contains(pos.south().up())) {
				findTreeBlocks(pos.south().up(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.south().down())) {
				findTreeBlocks(pos.south().down(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.south().west())) {
				findTreeBlocks(pos.south().west(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.south().east())) {
				findTreeBlocks(pos.south().east(), treeBlocks, context);
			}
			findTreeBlocks(pos.south(), treeBlocks, context);
		}
		if(!treeBlocks.contains(pos.north())){
			if(!treeBlocks.contains(pos.north().up())) {
				findTreeBlocks(pos.north().up(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.north().down())) {
				findTreeBlocks(pos.north().down(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.north().west())) {
				findTreeBlocks(pos.north().west(), treeBlocks, context);
			}
			if(!treeBlocks.contains(pos.north().east())) {
				findTreeBlocks(pos.north().east(), treeBlocks, context);
			}
			findTreeBlocks(pos.north(), treeBlocks, context);
		}
		return treeBlocks;
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		List<BlockPos> treeBlocks = findTreeBlocks(context.getPos(), new ArrayList<BlockPos>(), context);
		for(BlockPos currentPos : treeBlocks) {
			context.getPlayer().inventory.addItemStackToInventory(new ItemStack(getItemFromBlock(context.getWorld().getBlockState(currentPos).getBlock())));
			context.getWorld().setBlockState(currentPos, Blocks.AIR.getDefaultState());
		}
		return ActionResultType.SUCCESS;
	}	
}
