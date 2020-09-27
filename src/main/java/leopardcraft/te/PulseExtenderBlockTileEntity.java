package leopardcraft.te;

import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.block.PulseExtenderBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class PulseExtenderBlockTileEntity extends TileEntity implements ITickableTileEntity {
	
	private static TileEntityType<?> type = TileEntityType.Builder.create(PulseExtenderBlockTileEntity::new, LCBlocks.peBlock.get()).build(null);
	
	private int length;
	private int timeRemaining;
	private boolean isTimerRunning;
	
	public PulseExtenderBlockTileEntity() {
		super(type);
	}
	
	public static TileEntityType<?> getTeType() {
		return type;
	}
	
	public void tick() {
		//Set length
		length = this.getBlockState().get(PulseExtenderBlock.length);
		
		//Check if timer is running
		if(isTimerRunning) {
			timeRemaining--;
			//Do output updates
			switch(this.getBlockState().get(PulseExtenderBlock.facing)) {
			case NORTH:
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().north(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
				}
				break;
			case SOUTH:
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().south(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
				}
				break;
			case EAST:
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().east(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
				}
				break;
			case WEST:
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().west(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
				}
				break;
			default:
				break;
			}
			if(timeRemaining <= 0) {
				isTimerRunning = false;
			}
		} else {
			timeRemaining = 0;
			isTimerRunning = false;
			switch(this.getBlockState().get(PulseExtenderBlock.facing)) {
			case NORTH:
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().south(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().south()).get(RedstoneWireBlock.POWER) >= 1) {
						timeRemaining = length;
						isTimerRunning = true;
					}
				}
				break;
			case SOUTH:
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().north(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().south()).get(RedstoneWireBlock.POWER) >= 1) {
						timeRemaining = length;
						isTimerRunning = true;
					}
				}
				break;
			case EAST:
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().west(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().south()).get(RedstoneWireBlock.POWER) >= 1) {
						timeRemaining = length;
						isTimerRunning = true;
					}
				}
				break;
			case WEST:
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.COMPARATOR) {
					this.getWorld().setBlockState(this.getPos().east(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().south()).get(RedstoneWireBlock.POWER) >= 1) {
						timeRemaining = length;
						isTimerRunning = true;
					}
				}
				break;
			default:
				break;
			}
		}
	}
	
	public void remove() {
		super.remove();
	}
}