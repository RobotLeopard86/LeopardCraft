package leopardcraft.te;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.base.LeopardCraft;
import leopardcraft.block.MapleLog;
import leopardcraft.block.SapTapperBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class SapTapperTileEntity extends TileEntity implements ITickableTileEntity {

	private static final Logger LOGGER = LogManager.getLogger();
	private static TileEntityType<?> type = TileEntityType.Builder.create(SapTapperTileEntity::new, LeopardCraft.sapTapperBlock).build(null);
	static {
		type.setRegistryName("leopardcraft", "sap_tapper_te");
	}
	
	private int tapTime = 0;
	
	public SapTapperTileEntity() {
		super(type);
	}
	
	
	
	public static TileEntityType<?> getTileEntityType(){
		return type;
	}
	
	
	private boolean isTapping() {
		return tapTime > 0;
	}
	
	private int getTapTime(int sapLevel) {
		int time = 60;
		switch(sapLevel) {
		case 3:
			time = 60;
			break;
		case 2:
			time = 120;
			break;
		case 1:
			time = 180;
			break;
		default:
			time = 60;
		}
		return time;
	}
	
	
	BlockPos getFacingBlock() {
		switch(this.getBlockState().get(SapTapperBlock.facing)) {
		case NORTH:
			return this.getPos().north();
		case WEST:
			return this.getPos().west();
		case SOUTH:
			return this.getPos().south();
		case EAST:
			return this.getPos().east();
		default:
			return null;
		}
	}
	
	public boolean allowedToTap() {
		BlockPos facingLog = getFacingBlock();
		if(this.getBlockState().get(SapTapperBlock.tankState) == SapTapperBlock.TankStates.EMPTY && this.getWorld().getBlockState(facingLog).getBlock().getClass() == MapleLog.class) {
			return this.getWorld().getBlockState(facingLog).get(MapleLog.sapState) >= 1;
		}
		return false;
	}

	@Override
	public void tick() {
		if(!isTapping() && allowedToTap()) {
			tapTime = getTapTime(this.getWorld().getBlockState(getFacingBlock()).get(MapleLog.sapState));
		} else if(isTapping()) {
			tapTime--;
			if(tapTime == 0) {
				LOGGER.info("Filling tank...");
				this.getWorld().setBlockState(this.getPos(), this.getBlockState().with(SapTapperBlock.facing, this.getBlockState().get(SapTapperBlock.facing)).with(SapTapperBlock.tankState, SapTapperBlock.TankStates.FULL));
				LOGGER.info("Reducing sap level...");
				this.getWorld().setBlockState(getFacingBlock(), this.getWorld().getBlockState(getFacingBlock()).with(MapleLog.sapState, this.getWorld().getBlockState(getFacingBlock()).get(MapleLog.sapState) - 1).with(MapleLog.axisProperty, this.getWorld().getBlockState(getFacingBlock()).get(MapleLog.axisProperty)));
			}
		} 
	}
	
	@Override
	public void remove() {
		super.remove();
	}
}