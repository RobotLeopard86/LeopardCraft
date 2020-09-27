package leopardcraft.te;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.block.TFlipFlopBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TFlipFlopTileEntity extends TileEntity implements ITickableTileEntity {
	
	private static Logger logger = LogManager.getLogger();
	private static TileEntityType<?> type = TileEntityType.Builder.create(TFlipFlopTileEntity::new, LCBlocks.tffBlock.get()).build(null);
	
	public TFlipFlopTileEntity() {
		super(type);
	}
	
	public static TileEntityType<?> getTeType() {
		return type;
	}

	@Override
	public void tick() {
		logger.info("Hullo from the T Flip-Flop Tile Entity!");
		switch(this.getBlockState().get(TFlipFlopBlock.facing)) {
		case NORTH:
			if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().south()).get(RedstoneWireBlock.POWER) >= 1 && this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.COMPARATOR) {
				this.getWorld().setBlockState(this.getPos().north(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, !Blocks.COMPARATOR.getDefaultState().get(ComparatorBlock.POWERED)));
			}
			break;
		case SOUTH:
			if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().north()).get(RedstoneWireBlock.POWER) >= 1 && this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.COMPARATOR) {
				this.getWorld().setBlockState(this.getPos().south(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, !Blocks.COMPARATOR.getDefaultState().get(ComparatorBlock.POWERED)));
			}
			break;
		case EAST:
			if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().west()).get(RedstoneWireBlock.POWER) >= 1 && this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.COMPARATOR) {
				this.getWorld().setBlockState(this.getPos().east(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, !Blocks.COMPARATOR.getDefaultState().get(ComparatorBlock.POWERED)));
			}
			break;
		case WEST:
			if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().east()).get(RedstoneWireBlock.POWER) >= 1 && this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.COMPARATOR) {
				this.getWorld().setBlockState(this.getPos().west(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, !Blocks.COMPARATOR.getDefaultState().get(ComparatorBlock.POWERED)));
			}
			break;
		default:
			break;
		}
	}
	
	public void remove() {
		super.remove();
	}
}