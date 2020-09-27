package leopardcraft.base;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.base.biomes.LCBiomes;
import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.base.items.LCItems;
import leopardcraft.base.tileentities.LCTEs;
import leopardcraft.entity.LeopardEntity;
import leopardcraft.entity.MonkeyEntity;
import leopardcraft.entity.SnakeEntity;
import leopardcraft.entity.render.LeopardEntityRender;
import leopardcraft.entity.render.MonkeyEntityRender;
import leopardcraft.entity.render.SnakeEntityRender;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
    /*public static MapleLog mapleLogBlock;
    private static BlockItem mapleLogItem;
    public static LeavesBlock mapleLeavesBlock;
    private static BlockItem mapleLeavesItem;
    public static Item sapBottleItem;
    public static Item syrupBottleItem;
    public static SapTapperBlock sapTapperBlock;
    private static BlockItem sapTapperItem;
    private static Item batter;
    public static Item pancake;
    public static Item pancakeWithSyrup;
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
    public static SpawnEggItem leopardSpawnEgg;
    private static SpawnEggItem snakeSpawnEgg;
    public static Item snakeSkin;
    public static Item banana;
    public static Item venom;
    private static SpawnEggItem monkeySpawnEgg;
    private static ChainsawItem chainsaw;
    private static MagnetItem magnet;
    private static Tunneler tunneler;
    private static Tunneler supaTunneler;
    private static PickaxeItem emeraldPickaxe;
    private static AxeItem emeraldAxe;
    private static HoeItem emeraldHoe;
    private static ShovelItem emeraldShovel;
    private static SwordItem emeraldSword;
    private static ArmorItem emeraldHelmet;
    private static ArmorItem emeraldChestplate;
    private static ArmorItem emeraldLeggings;
    private static ArmorItem emeraldBoots;
    //Declare custom foods
    private static Food pancakeFood;
    private static Food syrupPancakeFood;
    private static Food bananaFood;
    private static Food venomFood;*/
    //Create Mod Id
    public static String ModId = "leopardcraft";
    
    
    public LeopardCraft() {
        LOGGER.info("Welcome to LeopardCraft!");

        final IEventBus eventbus = FMLJavaModLoadingContext.get().getModEventBus();
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
        
        LCItems.itemRegistry.register(eventbus);
        LCBlocks.blockRegistry.register(eventbus);
        LCBiomes.biomeRegistry.register(eventbus);
        LCTEs.teRegistry.register(eventbus);
        //mapleSapling = new MapleSapling(new MapleTree(), Block.Properties.from(Blocks.JUNGLE_SAPLING));
        //Create custom foods
        /*pancakeFood = (new Food.Builder()).hunger(8).saturation(8.0f).build();
        syrupPancakeFood = (new Food.Builder()).hunger(20).saturation(20.0f).effect(new EffectInstance(Effects.SATURATION, 3600, 0), 1.0f).build();
        bananaFood = (new Food.Builder()).hunger(5).saturation(5.0f).build(); 
        venomFood = (new Food.Builder()).hunger(0).saturation(0.0f).setAlwaysEdible().effect(new EffectInstance(Effects.WITHER, 600), 1.0f).effect(new EffectInstance(Effects.BLINDNESS, 600), 1.0f).effect(new EffectInstance(Effects.NAUSEA, 600), 1.0f).build();
        // Initialize our blocks & items
        mapleLogBlock = new MapleLog(Block.Properties.from(Blocks.JUNGLE_LOG));
        mapleLogBlock.setRegistryName("maple_log");
        mapleLogItem = new BlockItem(mapleLogBlock,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleLogItem.setRegistryName("maple_log");
        mapleLeavesBlock = new LeavesBlock(Block.Properties.from(Blocks.JUNGLE_LEAVES));
        mapleLeavesBlock.setRegistryName("maple_leaves");
        mapleLeavesItem = new BlockItem(mapleLeavesBlock, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleLeavesItem.setRegistryName("maple_leaves");
        sapBottleItem = new Item(new Item.Properties().group(ItemGroup.MISC));
        syrupBottleItem = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.GOLDEN_CARROT));
        sapBottleItem.setRegistryName("sap_bottle");
        syrupBottleItem.setRegistryName("syrup_bottle");
        sapTapperBlock = new SapTapperBlock();
        sapTapperItem = new BlockItem(sapTapperBlock, new Item.Properties().group(ItemGroup.MISC));
        sapTapperItem.setRegistryName("sap_tapper");
        pancake = new Item(new Item.Properties().group(ItemGroup.FOOD).food(pancakeFood));
        pancakeWithSyrup = new Item(new Item.Properties().group(ItemGroup.FOOD).food(syrupPancakeFood));
        pancake.setRegistryName("pancake");
        pancakeWithSyrup.setRegistryName("pancake_with_syrup");
        batter = new Item(new Item.Properties().group(ItemGroup.MISC));
        batter.setRegistryName("batter");
        mapleSaplingBlock = new MapleSapling();
        mapleSaplingItem = new BlockItem(mapleSaplingBlock, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleSaplingItem.setRegistryName("maple_sapling");
        maplePlanksBlock = new Block(Block.Properties.from(Blocks.JUNGLE_PLANKS));
        maplePlanksBlock.setRegistryName("maple_planks");
        mapleSlabBlock = new SlabBlock(Block.Properties.from(Blocks.JUNGLE_SLAB));
        mapleSlabBlock.setRegistryName("maple_slab");
        mapleStairsBlock = new MapleStairs();
        mapleTrapdoorBlock = new MapleTrapdoor();
        mapleDoorBlock = new MapleDoor();
        mapleFence = new FenceBlock(Block.Properties.from(Blocks.JUNGLE_FENCE));
        mapleFence.setRegistryName("maple_fence");
        mapleFenceGate = new FenceGateBlock(Block.Properties.from(Blocks.JUNGLE_FENCE_GATE));
        mapleFenceGate.setRegistryName("maple_fence_gate");
        maplePressurePlate = new MaplePressurePlate();
        mapleButton = new MapleButtonBlock();
        strippedMapleLog = new DirectionalBlock(Block.Properties.from(mapleLogBlock));
        strippedMapleLog.setRegistryName("stripped_maple_log");
        mapleWoodBlock = new MapleWood(Block.Properties.from(Blocks.JUNGLE_WOOD));
        mapleWoodBlock.setRegistryName("maple_wood");
        strippedMapleWood = new DirectionalBlock(Block.Properties.from(mapleWoodBlock));
        strippedMapleWood.setRegistryName("stripped_maple_wood");
        mapleSignStanding = new StandingSignBlock(Block.Properties.from(Blocks.JUNGLE_SIGN), WoodType.field_227042_e_);
        mapleSignStanding.setRegistryName("maple_sign_standing");
        mapleSignWall = new WallSignBlock(Block.Properties.from(Blocks.JUNGLE_SIGN), WoodType.field_227042_e_);
        mapleSignWall.setRegistryName("maple_sign_wall");
        maplePlanksItem = new BlockItem(maplePlanksBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        maplePlanksItem.setRegistryName("maple_planks");
        mapleSlabItem = new BlockItem(mapleSlabBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleSlabItem.setRegistryName("maple_slab");
        mapleStairsItem = new BlockItem(mapleStairsBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleStairsItem.setRegistryName("maple_stairs");
        mapleTrapdoorItem = new BlockItem(mapleTrapdoorBlock, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleTrapdoorItem.setRegistryName("maple_trapdoor");
        mapleDoorItem = new BlockItem(mapleDoorBlock, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleDoorItem.setRegistryName("maple_door");
        mapleSignItem = new SignItem((new Item.Properties()).maxStackSize(16).group(ItemGroup.DECORATIONS), mapleSignStanding, mapleSignWall);
        mapleSignItem.setRegistryName("maple_sign");
        maplePressurePlateItem = new BlockItem(maplePressurePlate, new Item.Properties().group(ItemGroup.REDSTONE));
        maplePressurePlateItem.setRegistryName("maple_pressure_plate");
        mapleButtonItem = new BlockItem(mapleButton, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleButtonItem.setRegistryName("maple_button");
        mapleFenceItem = new BlockItem(mapleFence, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleFenceItem.setRegistryName("maple_fence");
        mapleFenceGateItem = new BlockItem(mapleFenceGate, new Item.Properties().group(ItemGroup.REDSTONE));
        mapleFenceGateItem.setRegistryName("maple_fence_gate");
        strippedMapleLogItem = new BlockItem(strippedMapleLog, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        strippedMapleLogItem.setRegistryName("stripped_maple_log");
        mapleWoodItem = new BlockItem(mapleWoodBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleWoodItem.setRegistryName("maple_wood");
        strippedMapleWoodItem = new BlockItem(strippedMapleWood, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        strippedMapleWoodItem.setRegistryName("stripped_maple_wood");
        leopardSpawnEgg = new SpawnEggItem(LeopardEntity.getEntityType(), 15585032, 0, new Item.Properties().group(ItemGroup.MISC));
        leopardSpawnEgg.setRegistryName("leopard_spawn_egg");
        snakeSpawnEgg = new SpawnEggItem(SnakeEntity.SNAKE, 894731, 8978176, new Item.Properties().group(ItemGroup.MISC));
        snakeSpawnEgg.setRegistryName("snake_spawn_egg");
        snakeSkin = new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16));
        snakeSkin.setRegistryName("snakeskin");
        banana = new Item(new Item.Properties().group(ItemGroup.FOOD).food(bananaFood));
        banana.setRegistryName("banana");
        monkeySpawnEgg = new SpawnEggItem(MonkeyEntity.MONKEY, 7555121, 16579584, new Item.Properties().group(ItemGroup.MISC));
        monkeySpawnEgg.setRegistryName("monkey_spawn_egg");
        venom = new Item(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1).food(venomFood));
        venom.setRegistryName("venom");
        chainsaw = new ChainsawItem();
        magnet = new MagnetItem();
        tunneler = new Tunneler(false);
        supaTunneler = new Tunneler(true);
        emeraldHelmet = new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT));
        emeraldChestplate = new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT));
        emeraldLeggings = new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT));
        emeraldBoots = new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT));
        emeraldPickaxe = new PickaxeItem(EmeraldItemTier.EMERALD, -1, -3.4F, (new Item.Properties()).group(ItemGroup.TOOLS));
        emeraldAxe = new AxeItem(EmeraldItemTier.EMERALD, -0.5F, -2F, (new Item.Properties().group(ItemGroup.TOOLS)));
        emeraldHoe = new HoeItem(EmeraldItemTier.EMERALD, -0F, (new Item.Properties().group(ItemGroup.TOOLS)));
        emeraldShovel = new ShovelItem(EmeraldItemTier.EMERALD, 1.2F, -1F, (new Item.Properties().group(ItemGroup.TOOLS)));
        emeraldSword = new SwordItem(EmeraldItemTier.EMERALD, 9, -5.2F, (new Item.Properties().group(ItemGroup.COMBAT)));
        emeraldHelmet.setRegistryName("emerald_helmet");
        emeraldChestplate.setRegistryName("emerald_chestplate");
        emeraldLeggings.setRegistryName("emerald_leggings");
        emeraldBoots.setRegistryName("emerald_boots");
        emeraldPickaxe.setRegistryName("emerald_pickaxe");
        emeraldAxe.setRegistryName("emerald_axe");
        emeraldShovel.setRegistryName("emerald_shovel");
        emeraldHoe.setRegistryName("emerald_hoe");
        emeraldSword.setRegistryName("emerald_sword");*/
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code ( just for looks, these log statements are )
        LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("PANCAKES...YUM >> {}", pancake.getRegistryName());
        /*addMapleTrees(Biomes.TAIGA);
        addMapleTrees(Biomes.TAIGA_HILLS);
        addMapleTrees(Biomes.TAIGA_MOUNTAINS);
        addMapleTrees(Biomes.SNOWY_TAIGA);
        addMapleTrees(Biomes.SNOWY_TAIGA_HILLS);
        addMapleTrees(Biomes.SNOWY_TAIGA_MOUNTAINS);
        addMapleTrees(Biomes.GIANT_SPRUCE_TAIGA);
        addMapleTrees(Biomes.GIANT_SPRUCE_TAIGA_HILLS);
        addMapleTrees(Biomes.GIANT_TREE_TAIGA_HILLS);
        addMapleTrees(Biomes.GIANT_TREE_TAIGA_HILLS);*/
        LOGGER.info("Sucessfully added maple trees to taiga biomes!");
    }
    
    /*public static void addMapleTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.func_225566_b_(MapleTree.MAPLE_TREE_CONFIG).func_227228_a_(Placement.COUNT_EXTRA_HEIGHTMAP.func_227446_a_(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
    }*/
    
    public static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, "leopardcraft:" + key, builder.build(key));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        minecraft = event.getMinecraftSupplier().get();
        LOGGER.info("Got game settings {}", minecraft.gameSettings);
        RenderingRegistry.registerEntityRenderingHandler(LeopardEntity.getEntityType(), LeopardEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(SnakeEntity.SNAKE, SnakeEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(MonkeyEntity.MONKEY, MonkeyEntityRender::new);
        //RenderTypeLookup.setRenderLayer(mapleSaplingBlock, RenderType.func_228643_e_());
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
}
