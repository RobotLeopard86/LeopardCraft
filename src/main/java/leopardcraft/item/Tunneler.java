package leopardcraft.item;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Tunneler extends Item {

	int range = 3;
	
	public Tunneler(boolean supa) {
		super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).setNoRepair());
		String registryName = "tunneler";
		if(supa) {
			range = 7;
			registryName = "supa_tunneler";
		}
		this.setRegistryName(registryName);
	}
	
	public void tunnel(ItemUseContext context, BlockPos origin) { 
		World world = context.getWorld();
		PlayerEntity player = context.getPlayer();
		int originX = origin.getX();
		int originY = origin.getY();
		int originZ = origin.getZ();
		Direction.Axis axis = context.getFace().getAxis();
		if(axis == Direction.Axis.X) {
			origin = origin.add(0, range, range);
			BlockPos pos = null;
			for(int axisOne = originZ; axisOne > originZ - range; axisOne--) {
				for(int axisTwo = originY; axisTwo > originY - range; axisTwo--) {
					pos = new BlockPos(originX, axisTwo, axisOne);
					player.inventory.addItemStackToInventory(new ItemStack(getItemFromBlock(world.getBlockState(pos).getBlock())));
					world.setBlockState(pos, Blocks.AIR.getDefaultState());
				}
			}
		}
		if(axis == Direction.Axis.Y) {
			origin = origin.add(range, 0, range);
			BlockPos pos = null;
			for(int axisOne = originX; axisOne > originX - range; axisOne--) {
				for(int axisTwo = originZ; axisTwo > originZ - range; axisTwo--) {
					pos = new BlockPos(axisOne, originY, axisTwo);
					player.inventory.addItemStackToInventory(new ItemStack(getItemFromBlock(world.getBlockState(pos).getBlock())));
					world.setBlockState(pos, Blocks.AIR.getDefaultState());
				}
			}
		}
		if(axis == Direction.Axis.Z) {
			origin = origin.add(range, range, 0);
			BlockPos pos = null;
			for(int axisOne = originX; axisOne > originX - range; axisOne--) {
				for(int axisTwo = originY; axisTwo > originY - range; axisTwo--) {
					pos = new BlockPos(axisOne, axisTwo, originZ);
					player.inventory.addItemStackToInventory(new ItemStack(getItemFromBlock(world.getBlockState(pos).getBlock())));
					world.setBlockState(pos, Blocks.AIR.getDefaultState());
				}
			}
		}
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		tunnel(context, context.getPos());
		return ActionResultType.SUCCESS;
	}
}
