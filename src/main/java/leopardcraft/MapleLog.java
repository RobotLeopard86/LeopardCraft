package leopardcraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;

public class MapleLog extends DirectionalBlock {

	static final IntegerProperty sapState = IntegerProperty.create("sap", 0, 3);
	
	public MapleLog(Properties properties) {
		super(properties);
		setDefaultState(stateContainer.getBaseState().with(axisProperty, Direction.Axis.Y).with(sapState, 3));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(sapState);
		super.fillStateContainer(builder);
	}


	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return stateContainer.getBaseState().with(sapState, 3);

	}
   
	
}