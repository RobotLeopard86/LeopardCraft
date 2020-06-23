package leopardcraft;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
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
    private static MapleLog mapleLogBlock;
    private static BlockItem mapleLogItem;
    private static Block mapleLeavesBlock;
    private static BlockItem mapleLeavesItem;
    public static Item sapBottleItem;
    private static Item syrupBottleItem;
    public static SapTapperBlock sapTapperBlock;
    private static BlockItem sapTapperItem;
    private static Item batter;
    private static Item pancake;
    private static Item pancakeWithSyrup;
    private static Block mapleSaplingBlock;
    private static BlockItem mapleSaplingItem;
    //Declare custom foods
    private static Food pancakeFood;
    private static Food syrupPancakeFood;
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
        mapleLogBlock = new MapleLog(Block.Properties.create(Material.WOOD));
        mapleLogBlock.setRegistryName("maple_log");
        mapleLogItem = new BlockItem(mapleLogBlock,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        mapleLogItem.setRegistryName("maple_log");
        mapleLeavesBlock = new Block(Block.Properties.create(Material.LEAVES)).setRegistryName("maple_leaves");
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
        mapleSaplingBlock = new Block(Block.Properties.from(Blocks.JUNGLE_SAPLING));
        mapleSaplingBlock.setRegistryName("maple_sapling");
        mapleSaplingItem = new BlockItem(mapleSaplingBlock, new Item.Properties().group(ItemGroup.DECORATIONS));
        mapleSaplingItem.setRegistryName("maple_sapling");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code ( just for looks, these log statements are )
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("PANCAKES...YUM >> {}", pancake.getRegistryName());


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
            blockRegistryEvent.getRegistry().registerAll(mapleLogBlock, mapleLeavesBlock, sapTapperBlock, mapleSaplingBlock);
            LOGGER.info("Successfully registered LeopardCraft blocks!");
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent){
            itemRegistryEvent.getRegistry().registerAll(mapleLogItem, mapleLeavesItem, sapBottleItem, syrupBottleItem, sapTapperItem, pancake, pancakeWithSyrup, batter, mapleSaplingItem);
            LOGGER.info("Successfully registered LeopardCraft items!");
        }
        
        @SubscribeEvent
        public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> teRegisterEvent) {
        	teRegisterEvent.getRegistry().register(SapTapperTileEntity.getTileEntityType());
        	LOGGER.info("Sucessfully registered LeopardCraft tile entities!");
        }
    }
}
