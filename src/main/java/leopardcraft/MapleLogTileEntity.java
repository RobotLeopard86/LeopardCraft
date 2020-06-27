package leopardcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class MapleLogTileEntity extends TileEntity implements ITickableTileEntity {
	
	private static final Logger LOGGER = LogManager.getLogger();
	private static TileEntityType<?> type = TileEntityType.Builder.create(MapleLogTileEntity::new, LeopardCraft.mapleLogBlock).build(null);
	static {
		type.setRegistryName("leopardcraft", "maple_log_te");
	}
	
	private int regenTime = 160;
	
	public MapleLogTileEntity() {
		super(type);
	}
	
	public static TileEntityType<?> getTileEntityType(){
		return type;
	}
	
	private boolean regenerationAllowed(int sapLevel) {
		boolean allowed = false;
		if(sapLevel >= 3) {
			allowed = false;
		} else {
			allowed = true;
		}
		return allowed;
	}

	@Override
	public void tick() {
		if(regenerationAllowed(this.getBlockState().get(MapleLog.sapState)) && regenTime >= 1) {
			regenTime--;
			LOGGER.info("Time remaining: " + regenTime);
		} else if(regenTime < 1){
			LOGGER.info("Sap level increasing...");
			this.getWorld().setBlockState(getPos(), getBlockState().with(MapleLog.axisProperty, this.getBlockState().get(MapleLog.axisProperty)).with(MapleLog.sapState, this.getBlockState().get(MapleLog.sapState) + 1));
			LOGGER.info("Resetting regen time...");
			regenTime = 160;
		}
	}
	
	@Override
	public void remove() {
		super.remove();
	}
}