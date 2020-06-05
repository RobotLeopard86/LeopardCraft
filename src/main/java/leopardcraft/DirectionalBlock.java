package leopardcraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;

public class DirectionalBlock extends Block {
    
	
	//Variables go here
    static final EnumProperty<Direction.Axis> axisProperty = EnumProperty.create("axis",Direction.Axis.class);

    
    //Constructor
    public DirectionalBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(axisProperty, Direction.Axis.Y));
    }


	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(axisProperty);
		super.fillStateContainer(builder);
	}


	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return stateContainer.getBaseState().with(axisProperty, context.getFace().getAxis());

	}
   
	
	
    
    
}

