package leopardcraft.base;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import leopardcraft.base.biomes.LCBiomes;
import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.base.items.LCItems;
import leopardcraft.base.tileentities.LCTEs;
import leopardcraft.block.MapleLog;
import leopardcraft.block.MapleSapling;
import leopardcraft.entity.LeopardEntity;
import leopardcraft.entity.MonkeyEntity;
import leopardcraft.entity.SnakeEntity;
import leopardcraft.entity.render.LeopardEntityRender;
import leopardcraft.entity.render.MonkeyEntityRender;
import leopardcraft.entity.render.SnakeEntityRender;
import leopardcraft.tree.MapleTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
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
    public static Minecraft minecraft;
    //Create Mod Id
    public static String ModId = "leopardcraft";
    
    public static final MapleLog mapleLog = new MapleLog(Block.Properties.from(Blocks.JUNGLE_LOG));
    public static final LeavesBlock mapleLeaves = new LeavesBlock(Block.Properties.from(Blocks.JUNGLE_LEAVES));
    public static final MapleSapling mapleSapling = new MapleSapling(new MapleTree(), Block.Properties.from(Blocks.JUNGLE_SAPLING));
    
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
        
        mapleLog.setRegistryName("maple_log");
        mapleLeaves.setRegistryName("maple_leaves");
        mapleSapling.setRegistryName("maple_sapling");
        
        LCItems.itemRegistry.register(eventbus);
        LCBlocks.blockRegistry.register(eventbus);
        LCBiomes.biomeRegistry.register(eventbus);
        LCTEs.teRegistry.register(eventbus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code ( just for looks, these log statements are )
        LOGGER.info("HELLO FROM PREINIT");
    }
    
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
        RenderTypeLookup.setRenderLayer(mapleSapling, RenderType.func_228643_e_());
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
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	@SubscribeEvent
    	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    		blockRegistryEvent.getRegistry().registerAll(mapleLog, mapleLeaves, mapleSapling);
    	}
    }
}
