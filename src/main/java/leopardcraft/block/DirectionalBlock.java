package leopardcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class DirectionalBlock extends Block {
    
	
	//Variables go here
    public static final EnumProperty<Direction.Axis> axisProperty = EnumProperty.create("axis",Direction.Axis.class);

    
    //Constructor
    public DirectionalBlock(Properties properties) {
        super(properties);
        setDefaultState(stateContainer.getBaseState().with(axisProperty, Direction.Axis.Y));
    }
    
    @Override
    public ActionResultType func_225533_a_(BlockState state, World world, BlockPos position, PlayerEntity player, Hand playerHand, BlockRayTraceResult hit) {
    	return ActionResultType.PASS;
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

