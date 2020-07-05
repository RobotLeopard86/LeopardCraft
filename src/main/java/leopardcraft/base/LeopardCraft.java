package leopardcraft.base;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.block.DirectionalBlock;
import leopardcraft.block.MapleButtonBlock;
import leopardcraft.block.MapleDoor;
import leopardcraft.block.MapleLog;
import leopardcraft.block.MaplePressurePlate;
import leopardcraft.block.MapleSapling;
import leopardcraft.block.MapleStairs;
import leopardcraft.block.MapleTrapdoor;
import leopardcraft.block.MapleWood;
import leopardcraft.block.SapTapperBlock;
import leopardcraft.entity.LeopardEntity;
import leopardcraft.te.MapleLogTileEntity;
import leopardcraft.te.SapTapperTileEntity;
import leopardcraft.tree.MapleTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("leopardcraft")
public class LeopardCraft {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    private Minecraft minecraft;
    //Declare our items and blocks
    public static MapleLog mapleLogBlock;
    private static BlockItem mapleLogItem;
    public static Block mapleLeavesBlock;
    private static BlockItem mapleLeavesItem;
    public static Item sapBottleItem;
    private static Item syrupBottleItem;
    public static SapTapperBlock sapTapperBlock;
    private static BlockItem sapTapperItem;
    private static Item batter;
    private static Item pancake;
    private static Item pancakeWithSyrup;
    public static MapleSapling mapleSaplingBlock;
    private static BlockItem mapleSaplingItem;
    public static Block maplePlanksBlock;
    private static SlabBlock mapleSlabBlock;
    private static MapleStairs mapleStairsBlock;
    private static MapleTrapdoor mapleTrapdoorBlock;
    private static MapleDoor mapleDoorBlock;
    private static StandingSignBlock mapleSignStanding;
    private static WallSignBlock mapleSignWall;
    private static MaplePressurePlate maplePressurePlate;
    private static MapleButtonBlock mapleButton;
    public static DirectionalBlock strippedMapleLog;
    private static MapleWood mapleWoodBlock;
    public static DirectionalBlock strippedMapleWood;
    private static FenceBlock mapleFence;
    private static FenceGateBlock mapleFenceGate;
    private static BlockItem maplePlanksItem;
    private static BlockItem mapleSlabItem;
    private static BlockItem mapleStairsItem;
    private static BlockItem mapleTrapdoorItem;
    private static BlockItem mapleDoorItem;
    private static SignItem mapleSignItem;
    private static BlockItem maplePressurePlateItem;
    private static BlockItem mapleButtonItem;
    private static BlockItem strippedMapleLogItem;
    private static BlockItem mapleWoodItem;
    private static BlockItem strippedMapleWoodItem;
    private static BlockItem mapleFenceItem;
    private static BlockItem mapleFenceGateItem;
    //Declare custom foods
    private static Food pancakeFood;
    private static Food syrupPancakeFood;
    //Get entity types
    private static EntityType<LeopardEntity> leopardType;
    
    
    public LeopardCraft() {
        LOGGER.info("Welcome to LeopardCraft!");


        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //Create custom foods
        pancakeFood = (new Food.Builder()).hunger(8).saturation(8.0f).build();
        syrupPancakeFood = (new Food.Builder()).hunger(20).saturation(20.0f).effect(new EffectInstance(Effects.SATURATION, 3600, 0), 1.0f).build();
        // Initialize our blocks & items
        mapleLogBlock = new MapleLog(Block.Properties.from(Blocks.JUNGLE_LOG));
        mapleLogBlock.setRegistryName("maple_log");
        LOGGER.info("Maple Log: " + mapleLogBlock.getRegistryName());
        mapleLogItem = new BlockItem(mapleLogBlock,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleLogItem.setRegistryName("maple_log");
        LOGGER.info("Maple Log Item: " + mapleLogItem.getRegistryName());
        mapleLeavesBlock = new Block(Block.Properties.from(Blocks.JUNGLE_LEAVES));
        mapleLeavesBlock.setRegistryName("maple_leaves");
        LOGGER.info("Maple Leaves: " + mapleLeavesBlock.getRegistryName());
        mapleLeavesItem = new BlockItem(mapleLeavesBlock, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleLeavesItem.setRegistryName("maple_leaves");
        LOGGER.info("Maple Leaves Item: " + mapleLeavesItem.getRegistryName());
        sapBottleItem = new Item(new Item.Properties().group(ItemGroup.MISC));
        syrupBottleItem = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.GOLDEN_CARROT));
        sapBottleItem.setRegistryName("sap_bottle");
        syrupBottleItem.setRegistryName("syrup_bottle");
        LOGGER.info("Sap: " + sapBottleItem.getRegistryName() + " and here is the Syrup: " + syrupBottleItem.getRegistryName());
        sapTapperBlock = new SapTapperBlock();
        LOGGER.info("Sap Tapper: " + sapTapperBlock.getRegistryName());
        sapTapperItem = new BlockItem(sapTapperBlock, new Item.Properties().group(ItemGroup.MISC));
        sapTapperItem.setRegistryName("sap_tapper");
        LOGGER.info("Sap Tapper Item: " + sapTapperItem.getRegistryName());
        pancake = new Item(new Item.Properties().group(ItemGroup.FOOD).food(pancakeFood));
        pancakeWithSyrup = new Item(new Item.Properties().group(ItemGroup.FOOD).food(syrupPancakeFood));
        pancake.setRegistryName("pancake");
        pancakeWithSyrup.setRegistryName("pancake_with_syrup");
        batter = new Item(new Item.Properties().group(ItemGroup.MISC));
        batter.setRegistryName("batter");
        LOGGER.info("Maple Eats: " + pancake.getRegistryName() + " (this one with syrup): " + pancakeWithSyrup.getRegistryName() + " and batter now: " + batter.getRegistryName());
        mapleSaplingBlock = new MapleSapling();
        LOGGER.info("Maple Sapling: " + mapleSaplingBlock.getRegistryName());
        mapleSaplingItem = new BlockItem(mapleSaplingBlock, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleSaplingItem.setRegistryName("maple_sapling");
        LOGGER.info("The sapling item: " + mapleSaplingItem.getRegistryName());
        maplePlanksBlock = new Block(Block.Properties.from(Blocks.JUNGLE_PLANKS));
        maplePlanksBlock.setRegistryName("maple_planks");
        LOGGER.info("Maple Planks: " + maplePlanksBlock.getRegistryName());
        mapleSlabBlock = new SlabBlock(Block.Properties.from(Blocks.JUNGLE_SLAB));
        mapleSlabBlock.setRegistryName("maple_slab");
        LOGGER.info("Maple Slab: " + mapleSlabBlock.getRegistryName());
        mapleStairsBlock = new MapleStairs();
        LOGGER.info("Maple Stairs: " + mapleStairsBlock.getRegistryName());
        mapleTrapdoorBlock = new MapleTrapdoor();
        LOGGER.info("Maple Trapdoor: " + mapleTrapdoorBlock.getRegistryName());
        mapleDoorBlock = new MapleDoor();
        LOGGER.info("Maple Door: " + mapleDoorBlock.getRegistryName());
        mapleFence = new FenceBlock(Block.Properties.from(Blocks.JUNGLE_FENCE));
        mapleFence.setRegistryName("maple_fence");
        LOGGER.info("Maple Fence: " + mapleFence.getRegistryName());
        mapleFenceGate = new FenceGateBlock(Block.Properties.from(Blocks.JUNGLE_FENCE_GATE));
        mapleFenceGate.setRegistryName("maple_fence_gate");
        LOGGER.info("Maple Fence Gate: " + mapleFenceGate.getRegistryName());
        maplePressurePlate = new MaplePressurePlate();
        LOGGER.info("Maple Pressure Plate: " + maplePressurePlate.getRegistryName());
        mapleButton = new MapleButtonBlock();
        LOGGER.info("Maple Button: " + mapleButton.getRegistryName());
        strippedMapleLog = new DirectionalBlock(Block.Properties.from(mapleLogBlock));
        strippedMapleLog.setRegistryName("stripped_maple_log");
        LOGGER.info("Stripped Maple Log: " + strippedMapleLog.getRegistryName());
        mapleWoodBlock = new MapleWood(Block.Properties.from(Blocks.JUNGLE_WOOD));
        mapleWoodBlock.setRegistryName("maple_wood");
        LOGGER.info("Maple Wood: " + mapleWoodBlock.getRegistryName());
        strippedMapleWood = new DirectionalBlock(Block.Properties.from(mapleWoodBlock));
        strippedMapleWood.setRegistryName("stripped_maple_wood");
        LOGGER.info("Stripped Maple Wood: " + strippedMapleWood.getRegistryName());
        mapleSignStanding = new StandingSignBlock(Block.Properties.from(Blocks.JUNGLE_SIGN), WoodType.field_227042_e_);
        mapleSignStanding.setRegistryName("maple_sign_standing");
        LOGGER.info("Maple Sign (standing): " + mapleSignStanding.getRegistryName());
        mapleSignWall = new WallSignBlock(Block.Properties.from(Blocks.JUNGLE_SIGN), WoodType.field_227042_e_);
        mapleSignWall.setRegistryName("maple_sign_wall");
        LOGGER.info("Maple Sign (wall): " + mapleSignWall.getRegistryName());
        LOGGER.info("Now for the other items!");
        maplePlanksItem = new BlockItem(maplePlanksBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        maplePlanksItem.setRegistryName("maple_planks");
        LOGGER.info("Maple Planks: " + maplePlanksItem.getRegistryName());
        mapleSlabItem = new BlockItem(mapleSlabBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleSlabItem.setRegistryName("maple_slab");
        LOGGER.info("Maple Slab: " + mapleSlabItem.getRegistryName());
        mapleStairsItem = new BlockItem(mapleStairsBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleStairsItem.setRegistryName("maple_stairs");
        LOGGER.info("Maple Stairs: " + mapleStairsItem.getRegistryName());
        mapleTrapdoorItem = new BlockItem(mapleTrapdoorBlock, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleTrapdoorItem.setRegistryName("maple_trapdoor");
        LOGGER.info("Maple Trapdoor: " + mapleTrapdoorItem.getRegistryName());
        mapleDoorItem = new BlockItem(mapleDoorBlock, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleDoorItem.setRegistryName("maple_door");
        LOGGER.info("Maple Door: " + mapleDoorItem.getRegistryName());
        mapleSignItem = new SignItem((new Item.Properties()).maxStackSize(16).group(ItemGroup.DECORATIONS), mapleSignStanding, mapleSignWall);
        mapleSignItem.setRegistryName("maple_sign");
        LOGGER.info("Maple Sign: " + mapleSignItem.getRegistryName());
        maplePressurePlateItem = new BlockItem(maplePressurePlate, new Item.Properties().group(ItemGroup.REDSTONE));
        maplePressurePlateItem.setRegistryName("maple_pressure_plate");
        LOGGER.info("Maple Pressure Plate: " + maplePressurePlateItem.getRegistryName());
        mapleButtonItem = new BlockItem(mapleButton, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleButtonItem.setRegistryName("maple_button");
        LOGGER.info("Maple Button Too: " + mapleButtonItem.getRegistryName());
        mapleFenceItem = new BlockItem(mapleFence, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleFenceItem.setRegistryName("maple_fence");
        LOGGER.info("Maple Fence: " + mapleFenceItem.getRegistryName());
        mapleFenceGateItem = new BlockItem(mapleFenceGate, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleFenceGateItem.setRegistryName("maple_fence_gate");
        LOGGER.info("The Fence's Gate: " + mapleFenceGateItem.getRegistryName());
        strippedMapleLogItem = new BlockItem(strippedMapleLog, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        strippedMapleLogItem.setRegistryName("stripped_maple_log");
        LOGGER.info("Stripped Maple Log: " + strippedMapleLogItem.getRegistryName());
        mapleWoodItem = new BlockItem(mapleWoodBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleWoodItem.setRegistryName("maple_wood");
        LOGGER.info("Maple Wood: " + mapleWoodItem.getRegistryName());
        strippedMapleWoodItem = new BlockItem(strippedMapleWood, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        strippedMapleWoodItem.setRegistryName("stripped_maple_wood");
        LOGGER.info("Stripped Maple Wood: " + strippedMapleWoodItem.getRegistryName());
        //Create value of entity types
        leopardType = LeopardEntity.getEntityType();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code ( just for looks, these log statements are )
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("PANCAKES...YUM >> {}", pancake.getRegistryName());
        addMapleTrees(Biomes.TAIGA);
        addMapleTrees(Biomes.TAIGA_HILLS);
        addMapleTrees(Biomes.TAIGA_MOUNTAINS);
        addMapleTrees(Biomes.SNOWY_TAIGA);
        addMapleTrees(Biomes.SNOWY_TAIGA_HILLS);
        addMapleTrees(Biomes.SNOWY_TAIGA_MOUNTAINS);
        addMapleTrees(Biomes.GIANT_SPRUCE_TAIGA);
        addMapleTrees(Biomes.GIANT_SPRUCE_TAIGA_HILLS);
        addMapleTrees(Biomes.GIANT_TREE_TAIGA_HILLS);
        addMapleTrees(Biomes.GIANT_TREE_TAIGA_HILLS);
        LOGGER.info("Sucessfully added maple trees to taiga biomes!");
    }
    
    public static void addMapleTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.func_225566_b_(MapleTree.MAPLE_TREE_CONFIG).func_227228_a_(Placement.COUNT_EXTRA_HEIGHTMAP.func_227446_a_(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
    }
    
    public static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, "leopardcraft:" + key, builder.build(key));
     }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        minecraft = event.getMinecraftSupplier().get();
        LOGGER.info("Got game settings {}", minecraft.gameSettings);

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("leopardcraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(final FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().registerAll(mapleLogBlock, mapleLeavesBlock, sapTapperBlock, mapleSaplingBlock, maplePlanksBlock, mapleSlabBlock, mapleStairsBlock, mapleTrapdoorBlock, mapleDoorBlock, mapleSignStanding, mapleSignWall, maplePressurePlate, mapleButton, mapleWoodBlock, strippedMapleLog, strippedMapleWood, mapleFence, mapleFenceGate);
            LOGGER.info("Successfully registered LeopardCraft blocks!");
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent){
            itemRegistryEvent.getRegistry().registerAll(mapleLogItem, mapleLeavesItem, sapBottleItem, syrupBottleItem, sapTapperItem, pancake, pancakeWithSyrup, batter, mapleSaplingItem, maplePlanksItem, mapleSlabItem, mapleStairsItem, mapleTrapdoorItem, mapleDoorItem, mapleSignItem, maplePressurePlateItem, mapleButtonItem, mapleWoodItem, strippedMapleLogItem, strippedMapleWoodItem, mapleFenceItem, mapleFenceGateItem );
            LOGGER.info("Successfully registered LeopardCraft items!");
        }
        
        @SubscribeEvent
        public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> teRegisterEvent) {
        	teRegisterEvent.getRegistry().register(SapTapperTileEntity.getTileEntityType());
        	teRegisterEvent.getRegistry().register(MapleLogTileEntity.getTileEntityType());
        	LOGGER.info("Sucessfully registered LeopardCraft tile entities!");
        }
        
        @SubscribeEvent
        public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> entityRegistryEvent) {
        	entityRegistryEvent.getRegistry().register(LeopardEntity.getEntityType());
        	LOGGER.info("Sucessfully registered LeopardCraft entities!");
        }
    }
}
