package leopardcraft.base.blocks;

import leopardcraft.base.LeopardCraft;
import leopardcraft.block.AndBlock;
import leopardcraft.block.AxisBlock;
import leopardcraft.block.IntegerContainerBlock;
import leopardcraft.block.LCStairsBlock;
import leopardcraft.block.MapleButton;
import leopardcraft.block.MapleDoor;
import leopardcraft.block.MaplePressurePlate;
import leopardcraft.block.MapleTrapdoor;
import leopardcraft.block.PulseExtenderBlock;
import leopardcraft.block.SapTapperBlock;
import leopardcraft.block.TFlipFlopBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LCBlocks {

	public static final DeferredRegister<Block> blockRegistry = new DeferredRegister<>(ForgeRegistries.BLOCKS, LeopardCraft.ModId);
	
	public static final RegistryObject<SapTapperBlock> sapTapper = blockRegistry.register("sap_tapper", () -> new SapTapperBlock());
	public static final RegistryObject<Block> maplePlanks = blockRegistry.register("maple_planks", () -> new Block(Block.Properties.from(Blocks.JUNGLE_PLANKS)));
	public static final RegistryObject<MapleButton> mapleButton = blockRegistry.register("maple_button", () -> new MapleButton());
	public static final RegistryObject<SlabBlock> mapleSlab = blockRegistry.register("maple_slab", () -> new SlabBlock(Block.Properties.from(Blocks.JUNGLE_SLAB)));
	public static final RegistryObject<LCStairsBlock> mapleStairs = blockRegistry.register("maple_stairs", () -> new LCStairsBlock(maplePlanks.get().getDefaultState(), Block.Properties.from(Blocks.JUNGLE_STAIRS)));
	public static final RegistryObject<MaplePressurePlate> maplePressurePlate = blockRegistry.register("maple_pressure_plate", () -> new MaplePressurePlate());
	public static final RegistryObject<FenceBlock> mapleFence = blockRegistry.register("maple_fence", () -> new FenceBlock(Block.Properties.from(Blocks.JUNGLE_FENCE)));
	public static final RegistryObject<FenceGateBlock> mapleFenceGate = blockRegistry.register("maple_fence_gate", () -> new FenceGateBlock(Block.Properties.from(Blocks.JUNGLE_FENCE_GATE)));
	public static final RegistryObject<MapleDoor> mapleDoor = blockRegistry.register("maple_door", () -> new MapleDoor());
	public static final RegistryObject<MapleTrapdoor> mapleTrapdoor = blockRegistry.register("maple_trapdoor", () -> new MapleTrapdoor());
	public static final RegistryObject<StandingSignBlock> mapleSignS = blockRegistry.register("maple_standing_sign", () -> new StandingSignBlock(Block.Properties.from(Blocks.JUNGLE_SIGN), WoodType.field_227042_e_));
	public static final RegistryObject<WallSignBlock> mapleSignW = blockRegistry.register("maple_wall_sign", () -> new WallSignBlock(Block.Properties.from(Blocks.JUNGLE_SIGN), WoodType.field_227042_e_));
	public static final RegistryObject<AxisBlock> mapleWood = blockRegistry.register("maple_wood", () -> new AxisBlock(Block.Properties.from(Blocks.JUNGLE_WOOD)));
	public static final RegistryObject<AxisBlock> strippedMapleLog = blockRegistry.register("stripped_maple_log", () -> new AxisBlock(Block.Properties.from(LeopardCraft.mapleLog)));
	public static final RegistryObject<AxisBlock> strippedMapleWood = blockRegistry.register("stripped_maple_wood", () -> new AxisBlock(Block.Properties.from(mapleWood.get())));
	public static final RegistryObject<AndBlock> andBlock = blockRegistry.register("and_block", () -> new AndBlock());
	public static final RegistryObject<PulseExtenderBlock> peBlock = blockRegistry.register("pe_block", () -> new PulseExtenderBlock());
	public static final RegistryObject<TFlipFlopBlock> tffBlock = blockRegistry.register("t_flip_flop_block", () -> new TFlipFlopBlock());
	public static final RegistryObject<IntegerContainerBlock> icBlock = blockRegistry.register("variable_container_int", () -> new IntegerContainerBlock());
	//Grian Suggestion Blocks
	
	//Granite
	public static final RegistryObject<Block> granite = blockRegistry.register("granite", () -> new Block(Block.Properties.from(Blocks.GRANITE)));
	public static final RegistryObject<Block> graniteCobble = blockRegistry.register("granite_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final RegistryObject<Block> graniteBricks = blockRegistry.register("granite_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS)));
	public static final RegistryObject<Block> polishedGranite = blockRegistry.register("polished_granite", () -> new Block(Block.Properties.from(Blocks.POLISHED_GRANITE)));
	public static final RegistryObject<SlabBlock> graniteSlab = blockRegistry.register("granite_slab", () -> new SlabBlock(Block.Properties.from(granite.get())));
	public static final RegistryObject<LCStairsBlock> graniteStairs = blockRegistry.register("granite_stairs", () -> new LCStairsBlock(granite.get().getDefaultState(), Block.Properties.from(Blocks.GRANITE_STAIRS)));
	public static final RegistryObject<SlabBlock> graniteCobbleSlab = blockRegistry.register("granite_cobble_slab", () -> new SlabBlock(Block.Properties.from(graniteCobble.get())));
	public static final RegistryObject<LCStairsBlock> graniteCobbleStairs = blockRegistry.register("granite_cobble_stairs", () -> new LCStairsBlock(graniteCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> graniteBrickSlab = blockRegistry.register("granite_brick_slab", () -> new SlabBlock(Block.Properties.from(graniteBricks.get())));
	public static final RegistryObject<LCStairsBlock> graniteBrickStairs = blockRegistry.register("granite_brick_stairs", () -> new LCStairsBlock(graniteBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedGraniteSlab = blockRegistry.register("polished_granite_slab", () -> new SlabBlock(Block.Properties.from(polishedGranite.get())));
	public static final RegistryObject<LCStairsBlock> polishedGraniteStairs = blockRegistry.register("polished_granite_stairs", () -> new LCStairsBlock(polishedGranite.get().getDefaultState(), Block.Properties.from(Blocks.POLISHED_GRANITE_STAIRS)));

	//Diorite
	public static final RegistryObject<Block> diorite = blockRegistry.register("diorite", () -> new Block(Block.Properties.from(Blocks.DIORITE)));
	public static final RegistryObject<Block> dioriteCobble = blockRegistry.register("diorite_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final RegistryObject<Block> dioriteBricks = blockRegistry.register("diorite_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS)));
	public static final RegistryObject<Block> polishedDiorite = blockRegistry.register("polished_diorite", () -> new Block(Block.Properties.from(Blocks.POLISHED_DIORITE)));
	public static final RegistryObject<SlabBlock> dioriteSlab = blockRegistry.register("diorite_slab", () -> new SlabBlock(Block.Properties.from(diorite.get())));
	public static final RegistryObject<LCStairsBlock> dioriteStairs = blockRegistry.register("diorite_stairs", () -> new LCStairsBlock(diorite.get().getDefaultState(), Block.Properties.from(Blocks.DIORITE_STAIRS)));
	public static final RegistryObject<SlabBlock> dioriteCobbleSlab = blockRegistry.register("diorite_cobble_slab", () -> new SlabBlock(Block.Properties.from(dioriteCobble.get())));
	public static final RegistryObject<LCStairsBlock> dioriteCobbleStairs = blockRegistry.register("diorite_cobble_stairs", () -> new LCStairsBlock(dioriteCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> dioriteBrickSlab = blockRegistry.register("diorite_brick_slab", () -> new SlabBlock(Block.Properties.from(dioriteBricks.get())));
	public static final RegistryObject<LCStairsBlock> dioriteBrickStairs = blockRegistry.register("diorite_brick_stairs", () -> new LCStairsBlock(dioriteBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedDioriteSlab = blockRegistry.register("polished_diorite_slab", () -> new SlabBlock(Block.Properties.from(polishedDiorite.get())));
	public static final RegistryObject<LCStairsBlock> polishedDioriteStairs = blockRegistry.register("polished_diorite_stairs", () -> new LCStairsBlock(polishedDiorite.get().getDefaultState(), Block.Properties.from(Blocks.POLISHED_DIORITE_STAIRS)));
	
	//Andesite
	public static final RegistryObject<Block> andesite = blockRegistry.register("andesite", () -> new Block(Block.Properties.from(Blocks.ANDESITE)));
	public static final RegistryObject<Block> andesiteCobble = blockRegistry.register("andesite_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final RegistryObject<Block> andesiteBricks = blockRegistry.register("andesite_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS)));
	public static final RegistryObject<Block> polishedAndesite = blockRegistry.register("polished_andesite", () -> new Block(Block.Properties.from(Blocks.POLISHED_ANDESITE)));
	public static final RegistryObject<SlabBlock> andesiteSlab = blockRegistry.register("andesite_slab", () -> new SlabBlock(Block.Properties.from(andesite.get())));
	public static final RegistryObject<LCStairsBlock> andesiteStairs = blockRegistry.register("andesite_stairs", () -> new LCStairsBlock(andesite.get().getDefaultState(), Block.Properties.from(Blocks.ANDESITE_STAIRS)));
	public static final RegistryObject<SlabBlock> andesiteCobbleSlab = blockRegistry.register("andesite_cobble_slab", () -> new SlabBlock(Block.Properties.from(andesiteCobble.get())));
	public static final RegistryObject<LCStairsBlock> andesiteCobbleStairs = blockRegistry.register("andesite_cobble_stairs", () -> new LCStairsBlock(andesiteCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> andesiteBrickSlab = blockRegistry.register("andesite_brick_slab", () -> new SlabBlock(Block.Properties.from(andesiteBricks.get())));
	public static final RegistryObject<LCStairsBlock> andesiteBrickStairs = blockRegistry.register("andesite_brick_stairs", () -> new LCStairsBlock(andesiteBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedAndesiteSlab = blockRegistry.register("polished_andesite_slab", () -> new SlabBlock(Block.Properties.from(polishedAndesite.get())));
	public static final RegistryObject<LCStairsBlock> polishedAndesiteStairs = blockRegistry.register("polished_andesite_stairs", () -> new LCStairsBlock(polishedAndesite.get().getDefaultState(), Block.Properties.from(Blocks.POLISHED_ANDESITE_STAIRS)));

	//Sandstone
	public static final RegistryObject<Block> sandstone = blockRegistry.register("sandstone", () -> new Block(Block.Properties.from(Blocks.SANDSTONE)));
	public static final RegistryObject<Block> sandstoneCobble = blockRegistry.register("sandstone_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final RegistryObject<Block> sandstoneBricks = blockRegistry.register("sandstone_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS)));
	public static final RegistryObject<Block> polishedSandstone = blockRegistry.register("polished_sandstone", () -> new Block(Block.Properties.from(Blocks.SMOOTH_SANDSTONE)));
	public static final RegistryObject<SlabBlock> sandstoneSlab = blockRegistry.register("sandstone_slab", () -> new SlabBlock(Block.Properties.from(sandstone.get())));
	public static final RegistryObject<LCStairsBlock> sandstoneStairs = blockRegistry.register("sandstone_stairs", () -> new LCStairsBlock(sandstone.get().getDefaultState(), Block.Properties.from(Blocks.SANDSTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> sandstoneCobbleSlab = blockRegistry.register("sandstone_cobble_slab", () -> new SlabBlock(Block.Properties.from(sandstoneCobble.get())));
	public static final RegistryObject<LCStairsBlock> sandstoneCobbleStairs = blockRegistry.register("sandstone_cobble_stairs", () -> new LCStairsBlock(sandstoneCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> sandstoneBrickSlab = blockRegistry.register("sandstone_brick_slab", () -> new SlabBlock(Block.Properties.from(sandstoneBricks.get())));
	public static final RegistryObject<LCStairsBlock> sandstoneBrickStairs = blockRegistry.register("sandstone_brick_stairs", () -> new LCStairsBlock(sandstoneBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedSandstoneSlab = blockRegistry.register("polished_sandstone_slab", () -> new SlabBlock(Block.Properties.from(polishedSandstone.get())));
	public static final RegistryObject<LCStairsBlock> polishedSandstoneStairs = blockRegistry.register("polished_sandstone_stairs", () -> new LCStairsBlock(polishedSandstone.get().getDefaultState(), Block.Properties.from(Blocks.SMOOTH_SANDSTONE_STAIRS)));

	//Marble
	public static final RegistryObject<Block> marble = blockRegistry.register("marble", () -> new Block(Block.Properties.from(Blocks.QUARTZ_BLOCK)));
	public static final RegistryObject<Block> marbleCobble = blockRegistry.register("marble_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final RegistryObject<Block> marbleBricks = blockRegistry.register("marble_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS)));
	public static final RegistryObject<Block> polishedMarble = blockRegistry.register("polished_marble", () -> new Block(Block.Properties.from(Blocks.SMOOTH_QUARTZ)));
	public static final RegistryObject<SlabBlock> marbleSlab = blockRegistry.register("marble_slab", () -> new SlabBlock(Block.Properties.from(marble.get())));
	public static final RegistryObject<LCStairsBlock> marbleStairs = blockRegistry.register("marble_stairs", () -> new LCStairsBlock(marble.get().getDefaultState(), Block.Properties.from(Blocks.QUARTZ_STAIRS)));
	public static final RegistryObject<SlabBlock> marbleCobbleSlab = blockRegistry.register("marble_cobble_slab", () -> new SlabBlock(Block.Properties.from(marbleCobble.get())));
	public static final RegistryObject<LCStairsBlock> marbleCobbleStairs = blockRegistry.register("marble_cobble_stairs", () -> new LCStairsBlock(marbleCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> marbleBrickSlab = blockRegistry.register("marble_brick_slab", () -> new SlabBlock(Block.Properties.from(marbleBricks.get())));
	public static final RegistryObject<LCStairsBlock> marbleBrickStairs = blockRegistry.register("marble_brick_stairs", () -> new LCStairsBlock(marbleBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedMarbleSlab = blockRegistry.register("polished_marble_slab", () -> new SlabBlock(Block.Properties.from(polishedMarble.get())));
	public static final RegistryObject<LCStairsBlock> polishedMarbleStairs = blockRegistry.register("polished_marble_stairs", () -> new LCStairsBlock(polishedMarble.get().getDefaultState(), Block.Properties.from(Blocks.SMOOTH_QUARTZ_STAIRS)));
	
	//Basalt
	public static final RegistryObject<Block> basalt = blockRegistry.register("basalt", () -> new Block(Block.Properties.from(Blocks.OBSIDIAN).hardnessAndResistance(10.5F)));
	public static final RegistryObject<Block> basaltCobble = blockRegistry.register("basalt_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE).hardnessAndResistance(8.0F)));
	public static final RegistryObject<Block> basaltBricks = blockRegistry.register("basalt_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS).hardnessAndResistance(11.0F)));
	public static final RegistryObject<Block> polishedBasalt = blockRegistry.register("polished_basalt", () -> new Block(Block.Properties.from(basalt.get()).hardnessAndResistance(9.5F)));
	public static final RegistryObject<SlabBlock> basaltSlabBlock = blockRegistry.register("basalt_slab", () -> new SlabBlock(Block.Properties.from(basalt.get())));
	public static final RegistryObject<LCStairsBlock> basaltLCStairsBlock = blockRegistry.register("basalt_stairs", () -> new LCStairsBlock(basalt.get().getDefaultState(), Block.Properties.from(Blocks.STONE_STAIRS)));
	public static final RegistryObject<SlabBlock> basaltCobbleSlabBlock = blockRegistry.register("basalt_cobble_slab", () -> new SlabBlock(Block.Properties.from(basaltCobble.get())));
	public static final RegistryObject<LCStairsBlock> basaltCobbleLCStairsBlock = blockRegistry.register("basalt_cobble_stairs", () -> new LCStairsBlock(basaltCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> basaltBrickSlabBlock = blockRegistry.register("basalt_brick_slab", () -> new SlabBlock(Block.Properties.from(basaltBricks.get())));
	public static final RegistryObject<LCStairsBlock> basaltBrickLCStairsBlock = blockRegistry.register("basalt_brick_stairs", () -> new LCStairsBlock(basaltBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedBasaltSlabBlock = blockRegistry.register("polished_basalt_slab", () -> new SlabBlock(Block.Properties.from(polishedBasalt.get())));
	public static final RegistryObject<LCStairsBlock> polishedBasaltLCStairsBlock = blockRegistry.register("polished_basalt_stairs", () -> new LCStairsBlock(polishedBasalt.get().getDefaultState(), Block.Properties.from(Blocks.STONE_STAIRS)));

	//Limestone
	public static final RegistryObject<Block> limestone = blockRegistry.register("limestone", () -> new Block(Block.Properties.from(Blocks.STONE)));
	public static final RegistryObject<Block> limestoneCobble = blockRegistry.register("limestone_cobble", () -> new Block(Block.Properties.from(Blocks.COBBLESTONE).hardnessAndResistance(5.3F)));
	public static final RegistryObject<Block> limestoneBricks = blockRegistry.register("limestone_bricks", () -> new Block(Block.Properties.from(Blocks.STONE_BRICKS).hardnessAndResistance(6.5F)));
	public static final RegistryObject<Block> polishedLimestone = blockRegistry.register("polished_limestone", () -> new Block(Block.Properties.from(Blocks.SMOOTH_STONE)));
	public static final RegistryObject<SlabBlock> limestoneSlab = blockRegistry.register("limestone_slab", () -> new SlabBlock(Block.Properties.from(limestone.get())));
	public static final RegistryObject<LCStairsBlock> limestoneStairs = blockRegistry.register("limestone_stairs", () -> new LCStairsBlock(limestone.get().getDefaultState(), Block.Properties.from(Blocks.STONE_STAIRS)));
	public static final RegistryObject<SlabBlock> limestoneCobbleSlab = blockRegistry.register("limestone_cobble_slab", () -> new SlabBlock(Block.Properties.from(limestoneCobble.get())));
	public static final RegistryObject<LCStairsBlock> limestoneCobbleStairs = blockRegistry.register("limestone_cobble_stairs", () -> new LCStairsBlock(limestoneCobble.get().getDefaultState(), Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	public static final RegistryObject<SlabBlock> limestoneBrickSlab = blockRegistry.register("limestone_brick_slab", () -> new SlabBlock(Block.Properties.from(limestoneBricks.get())));
	public static final RegistryObject<LCStairsBlock> limestoneBrickStairs = blockRegistry.register("limestone_brick_stairs", () -> new LCStairsBlock(limestoneBricks.get().getDefaultState(), Block.Properties.from(Blocks.STONE_BRICK_STAIRS)));
	public static final RegistryObject<SlabBlock> polishedLimestoneSlab = blockRegistry.register("polished_limestone_slab", () -> new SlabBlock(Block.Properties.from(polishedLimestone.get())));
	public static final RegistryObject<LCStairsBlock> polishedLimestoneStairs = blockRegistry.register("polished_limestone_stairs", () -> new LCStairsBlock(polishedLimestone.get().getDefaultState(), Block.Properties.from(Blocks.STONE_STAIRS)));
}