package leopardcraft.te;

import leopardcraft.base.LeopardCraft;
import leopardcraft.block.MapleLog;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class MapleLogTileEntity extends TileEntity implements ITickableTileEntity {

	private static TileEntityType<?> type = TileEntityType.Builder.create(MapleLogTileEntity::new, LeopardCraft.mapleLog).build(null);
	
	private int regenTime = 160;
	
	public MapleLogTileEntity() {
		super(type);
	}
	
	public static TileEntityType<?> getTeType(){
		return type;
	}
	
	private boolean regenerationAllowed(int sapLevel) {
		boolean allowed = false;
		if(sapLevel <= 3) {
			allowed = true;
		}
		return allowed;
	}

	@Override
	public void tick() {
		if(regenerationAllowed(this.getBlockState().get(MapleLog.sapState)) && regenTime >= 1) {
			regenTime--;
		} else if(regenTime < 1 && (this.getBlockState().get(MapleLog.sapState) + 1) < 4){
			this.getWorld().setBlockState(getPos(), getBlockState().with(MapleLog.axisProperty, this.getBlockState().get(MapleLog.axisProperty)).with(MapleLog.sapState, this.getBlockState().get(MapleLog.sapState) + 1));
			regenTime = 160;
		}
	}
	
	@Override
	public void remove() {
		super.remove();
	}
}