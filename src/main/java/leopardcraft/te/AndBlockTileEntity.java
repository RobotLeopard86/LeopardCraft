package leopardcraft.te;

import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.block.AndBlock;
import leopardcraft.util.LeopardCraftHelpers;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;

public class AndBlockTileEntity extends TileEntity implements ITickableTileEntity {
	
	private static TileEntityType<?> type = TileEntityType.Builder.create(AndBlockTileEntity::new, LCBlocks.andBlock.get()).build(null);
	
	public AndBlockTileEntity() {
		super(type);
	}
	
	public static TileEntityType<?> getTeType() {
		return type;
	}

	@Override
	public void tick() {
		LeopardCraftHelpers.HorizontalAxis axis = this.getBlockState().get(AndBlock.axis);
		
		if(axis == LeopardCraftHelpers.HorizontalAxis.X) {
			if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.REDSTONE_WIRE) {
				if(this.getWorld().getBlockState(this.getPos().west()).get(RedstoneWireBlock.POWER) >= 1 && this.getWorld().getBlockState(this.getPos().east()).get(RedstoneWireBlock.POWER) >= 1) {
					if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().north(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
					} else if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().south(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
					}
				} else {
					if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().north(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					} else if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().south(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					}
				}
			}
		} else {
			if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.REDSTONE_WIRE && this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.REDSTONE_WIRE) {
				if(this.getWorld().getBlockState(this.getPos().north()).get(RedstoneWireBlock.POWER) >= 1 && this.getWorld().getBlockState(this.getPos().south()).get(RedstoneWireBlock.POWER) >= 1) {
					if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().west(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
					} else if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().east(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(true)));
					}
				} else {
					if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().west(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					} else if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.COMPARATOR) {
						this.getWorld().setBlockState(this.getPos().east(), Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
					}
				}
			}
		}
	}
	
	public void remove() {
		super.remove();
	}
}