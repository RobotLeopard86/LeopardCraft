package leopardcraft.block;

import leopardcraft.base.LeopardCraft;
import leopardcraft.base.LeopardCraftHelpers;
import leopardcraft.te.SapTapperTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SapTapperBlock extends Block {
	
	public enum TankStates implements IStringSerializable {
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
	
	
	public static final EnumProperty<TankStates> tankState = EnumProperty.create("tank", TankStates.class);
	public static final DirectionProperty facing = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	private static final Vec3d TUBE_MIN_CORNER = new Vec3d(7.0, 5.0, 0.0);
	private static final Vec3d TUBE_MAX_CORNER = new Vec3d(9.0, 6.0, 13.0);
	private static final Vec3d FAUCET_MIN_CORNER = new Vec3d(6.0, 6.0, 9.0);
	private static final Vec3d FAUCET_MAX_CORNER = new Vec3d(10.0, 7.0, 10.0);
	private static final Vec3d TANK_MIN_CORNER = new Vec3d(6.0, 2.0, 10.0);
	private static final Vec3d TANK_MAX_CORNER = new Vec3d(10.0, 5.0, 14.0);
	
	private static final VoxelShape TUBE = Block.makeCuboidShape(TUBE_MIN_CORNER.getX(), TUBE_MIN_CORNER.getY(), TUBE_MIN_CORNER.getZ(),
			TUBE_MAX_CORNER.getX(), TUBE_MAX_CORNER.getY(), TUBE_MAX_CORNER.getZ());
	private static final VoxelShape FAUCET = Block.makeCuboidShape(FAUCET_MIN_CORNER.getX(), FAUCET_MIN_CORNER.getY(), FAUCET_MIN_CORNER.getZ(),
			FAUCET_MAX_CORNER.getX(), FAUCET_MAX_CORNER.getY(), FAUCET_MAX_CORNER.getZ());
	private static final VoxelShape TANK = Block.makeCuboidShape(TANK_MIN_CORNER.getX(), TANK_MIN_CORNER.getY(), TANK_MIN_CORNER.getZ(),
			TANK_MAX_CORNER.getX(), TANK_MAX_CORNER.getY(), TANK_MAX_CORNER.getZ());
	
	private static VoxelShape TANK_AND_TUBE = VoxelShapes.or(TANK, TUBE);
	private static VoxelShape SHAPE_NORTH = VoxelShapes.or(TANK_AND_TUBE, FAUCET);
	private static VoxelShape SHAPE_EAST = LeopardCraftHelpers.rotateShape(Direction.NORTH, Direction.EAST, SHAPE_NORTH);
	private static VoxelShape SHAPE_SOUTH = LeopardCraftHelpers.rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE_NORTH);
	private static VoxelShape SHAPE_WEST = LeopardCraftHelpers.rotateShape(Direction.NORTH, Direction.WEST, SHAPE_NORTH);
	
	public SapTapperBlock() {
		super(Block.Properties.create(Material.MISCELLANEOUS));
		this.getStateContainer().getBaseState().with(tankState, TankStates.EMPTY).with(facing, Direction.NORTH);
		this.setRegistryName("sap_tapper");
	}
	
	@Override
	public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if(!worldIn.isRemote && player.getHeldItem(handIn).getItem() == Items.GLASS_BOTTLE && state.get(tankState) == TankStates.FULL) {
			player.setHeldItem(handIn, new ItemStack(LeopardCraft.sapBottleItem));
			worldIn.getWorld().setBlockState(pos, stateContainer.getBaseState().with(facing, state.get(facing)).with(tankState, TankStates.EMPTY));
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new SapTapperTileEntity();
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(facing)) {
		case NORTH:
			return SHAPE_NORTH;
		case EAST:
			return SHAPE_EAST;
		case SOUTH:
			return SHAPE_SOUTH;
		case WEST:
			return SHAPE_WEST;
		default:
			return SHAPE_NORTH;
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return super.getCollisionShape(state, worldIn, pos, context);
	}
	
	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return super.getRenderShape(state, worldIn, pos);
	}
	
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(tankState, facing);
		super.fillStateContainer(builder);
	}
	
	@Override
	public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return super.getRaytraceShape(state, worldIn, pos);
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
		default:
			break;
		}
		switch(context.getNearestLookingDirection()) {
			case NORTH:
				if(context.getWorld().getBlockState(facingBlock.north()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.west()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.east()).getBlock().getClass() == SapTapperBlock.class) {
					return null;
				}
				break;
			case SOUTH:
				if(context.getWorld().getBlockState(facingBlock.south()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.west()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.east()).getBlock().getClass() == SapTapperBlock.class) {
					return null;
				}
				break;
			case WEST:
				if(context.getWorld().getBlockState(facingBlock.south()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.north()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.east()).getBlock().getClass() == SapTapperBlock.class) {
					return null;
				}
				break;
			case EAST:
				if(context.getWorld().getBlockState(facingBlock.south()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.west()).getBlock().getClass() == SapTapperBlock.class || context.getWorld().getBlockState(facingBlock.north()).getBlock().getClass() == SapTapperBlock.class) {
					return null;
				}
				break;
		}
		if(facingBlock == null || context.getWorld().getBlockState(facingBlock).getBlock().getClass() != MapleLog.class ){
			return null;
		}
		return stateContainer.getBaseState().with(tankState, TankStates.EMPTY).with(facing, context.getNearestLookingDirection());
	}



}