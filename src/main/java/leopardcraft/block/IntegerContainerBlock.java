package leopardcraft.block;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.gui.IntegerContainerScreen;
import leopardcraft.util.VariableContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class IntegerContainerBlock extends Block {
	
	private static Logger logger = LogManager.getLogger();
	
	public static final IntegerProperty valueProperty = IntegerProperty.create("value", 0, 1000);
	
	public final VariableContainer<Integer> value = new VariableContainer<>(0);

	public IntegerContainerBlock() {
		super(Block.Properties.create(Material.ROCK));
		logger.info("Constructing IntegerContainerBlock!");
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(valueProperty);
	}
	
	@Override
	public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		IntegerContainerScreen.open(pos);
		return ActionResultType.SUCCESS;
	}

}