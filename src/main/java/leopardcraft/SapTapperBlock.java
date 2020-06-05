package leopardcraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;

public class SapTapperBlock extends Block {
	
	
	enum TankStates implements IStringSerializable {
		EMPTY("empty"),
		FULL("full");

		private String name;
		
		
		private TankStates(String name) {
			this.name = name;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
	}
	
	
	static final EnumProperty<TankStates> tankState = EnumProperty.create("tank", TankStates.class);
	static final DirectionProperty facing = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	
	
	
	public SapTapperBlock(Properties properties) {
		super(properties);
		this.getStateContainer().getBaseState().with(tankState, TankStates.EMPTY).with(facing, Direction.NORTH);
		this.setRegistryName("sap_tapper");
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(tankState, facing);
		super.fillStateContainer(builder);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if(context.getNearestLookingDirection() == Direction.UP || context.getNearestLookingDirection() == Direction.DOWN) {
			return null;
		}
		BlockPos facingBlock = null;
		switch(context.getNearestLookingDirection()) {
			case NORTH:
				facingBlock = context.getPos().north();
				break;
			case SOUTH:
				facingBlock = context.getPos().south();
				break;
			case EAST:
				facingBlock = context.getPos().east();
				break;
			case WEST:
				facingBlock = context.getPos().west();
				break;
		}
		if(facingBlock == null || context.getWorld().getBlockState(facingBlock).getBlock().getClass() != MapleLog.class ){
			return null;
		}
		return stateContainer.getBaseState().with(tankState, TankStates.EMPTY).with(facing, context.getNearestLookingDirection());
	}
}