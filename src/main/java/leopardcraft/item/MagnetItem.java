package leopardcraft.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagnetItem extends Item {

	public Logger logger = LogManager.getLogger();
	
	public MagnetItem() {
		super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).setNoRepair());
		this.setRegistryName("magnet");
	}
	
	public BlockPos getPosFromXYZ(int x, int y, int z) {
		return new BlockPos(x, y, z);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		logger.info("busting those orez");
		BlockPos usePos = context.getPos();
		findOreBlocks(usePos.getX(), usePos.getY(), usePos.getZ(), context);
		logger.info("busted those orez");
		return ActionResultType.SUCCESS;
	}
	
	public void findOreBlocks(int xPos, int yPos, int zPos, ItemUseContext context){
		World world = context.getWorld();
		BlockPos pos = null;
		for(int x = (xPos - 5); x < (xPos + 5); x++) {
			for(int y = (yPos - 5); y < (yPos + 5); y++) {
				for(int z = (zPos - 5); z < (zPos + 5); z++) {
					pos = getPosFromXYZ(x, y, z);
					logger.info("Lookin for those orez @ " + pos);
					if(world.getBlockState(pos).getBlock() == Blocks.EMERALD_ORE || world.getBlockState(pos).getBlock() == Blocks.DIAMOND_ORE || world.getBlockState(pos).getBlock() == Blocks.IRON_ORE || world.getBlockState(pos).getBlock() == Blocks.COAL_ORE || world.getBlockState(pos).getBlock() == Blocks.GOLD_ORE || world.getBlockState(pos).getBlock() == Blocks.REDSTONE_ORE || world.getBlockState(pos).getBlock() == Blocks.NETHER_QUARTZ_ORE) {
						context.getPlayer().inventory.addItemStackToInventory(new ItemStack(getItemFromBlock(world.getBlockState(pos).getBlock())));
						world.setBlockState(pos, Blocks.AIR.getDefaultState());
						logger.info("goodbye");
					}
				}
			}
		}
	}
}