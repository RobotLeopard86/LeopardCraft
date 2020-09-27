package leopardcraft.base.items;

import leopardcraft.base.LeopardCraft;
import leopardcraft.base.blocks.LCBlocks;
import leopardcraft.entity.LeopardEntity;
import leopardcraft.entity.MonkeyEntity;
import leopardcraft.entity.SnakeEntity;
import leopardcraft.item.ChainsawItem;
import leopardcraft.item.MagnetItem;
import leopardcraft.item.Tunneler;
import leopardcraft.util.EmeraldArmorMaterial;
import leopardcraft.util.EmeraldItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SignItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LCItems {

	public static final DeferredRegister<Item> itemRegistry = new DeferredRegister<>(ForgeRegistries.ITEMS, LeopardCraft.ModId); 
	
	//BlockItems
	public static final RegistryObject<BlockItem> mapleLog = itemRegistry.register("maple_log", () -> new BlockItem(LCBlocks.mapleLog.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))); 
	public static final RegistryObject<BlockItem> mapleLeaves = itemRegistry.register("maple_leaves", () -> new BlockItem(LCBlocks.mapleLeaves.get(), new Item.Properties().group(ItemGroup.DECORATIONS))); 
	public static final RegistryObject<BlockItem> sapTapper = itemRegistry.register("sap_tapper", () -> new BlockItem(LCBlocks.sapTapper.get(), new Item.Properties().group(ItemGroup.MISC))); 
	public static final RegistryObject<BlockItem> mapleDoor = itemRegistry.register("maple_door", () -> new BlockItem(LCBlocks.mapleDoor.get(), new Item.Properties().group(ItemGroup.REDSTONE))); 
	public static final RegistryObject<BlockItem> mapleTrapdoor = itemRegistry.register("maple_trapdoor", () -> new BlockItem(LCBlocks.mapleTrapdoor.get(), new Item.Properties().group(ItemGroup.REDSTONE))); 
	public static final RegistryObject<BlockItem> mapleSlab = itemRegistry.register("maple_slab", () -> new BlockItem(LCBlocks.mapleSlab.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))); 
	public static final RegistryObject<BlockItem> mapleStairs = itemRegistry.register("maple_stairs", () -> new BlockItem(LCBlocks.mapleStairs.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))); 
	public static final RegistryObject<BlockItem> maplePressurePlate = itemRegistry.register("maple_pressure_plate", () -> new BlockItem(LCBlocks.maplePressurePlate.get(), new Item.Properties().group(ItemGroup.REDSTONE))); 
	public static final RegistryObject<BlockItem> mapleButton = itemRegistry.register("maple_button", () -> new BlockItem(LCBlocks.mapleButton.get(), new Item.Properties().group(ItemGroup.REDSTONE))); 
	public static final RegistryObject<BlockItem> mapleFence = itemRegistry.register("maple_fence", () -> new BlockItem(LCBlocks.mapleFence.get(), new Item.Properties().group(ItemGroup.DECORATIONS))); 
	public static final RegistryObject<BlockItem> mapleFenceGate = itemRegistry.register("maple_fence_gate", () -> new BlockItem(LCBlocks.mapleFenceGate.get(), new Item.Properties().group(ItemGroup.REDSTONE))); 
	public static final RegistryObject<BlockItem> mapleWood = itemRegistry.register("maple_wood", () -> new BlockItem(LCBlocks.mapleWood.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))); 
	public static final RegistryObject<BlockItem> strippedMapleWood = itemRegistry.register("stripped_maple_wood", () -> new BlockItem(LCBlocks.strippedMapleWood.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))); 
	public static final RegistryObject<BlockItem> strippedMapleLog = itemRegistry.register("stripped_maple_log", () -> new BlockItem(LCBlocks.strippedMapleLog.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))); 
	public static final RegistryObject<SignItem> mapleSign = itemRegistry.register("maple_sign", () -> new SignItem(new Item.Properties().group(ItemGroup.DECORATIONS), LCBlocks.mapleSignS.get(), LCBlocks.mapleSignW.get()));	
	public static final RegistryObject<BlockItem> andBlockItem = itemRegistry.register("and_block", () -> new BlockItem(LCBlocks.andBlock.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
	public static final RegistryObject<BlockItem> peBlockItem = itemRegistry.register("pe_block", () -> new BlockItem(LCBlocks.peBlock.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
	public static final RegistryObject<BlockItem> tffBlockItem = itemRegistry.register("t_flip_flop_block", () -> new BlockItem(LCBlocks.tffBlock.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
	
	//FoodItems
	//Food Def
	private static Food pancakeFood = (new Food.Builder()).hunger(8).saturation(8.0f).build();
	private static Food syrupPancakeFood = (new Food.Builder()).hunger(20).saturation(20.0f).effect(new EffectInstance(Effects.SATURATION, 3600, 0), 1.0f).build();
	private static Food bananaFood = (new Food.Builder()).hunger(5).saturation(5.0f).build(); 
	private static Food venomFood = (new Food.Builder()).hunger(0).saturation(0.0f).setAlwaysEdible().effect(new EffectInstance(Effects.WITHER, 600), 1.0f).effect(new EffectInstance(Effects.BLINDNESS, 600), 1.0f).effect(new EffectInstance(Effects.NAUSEA, 600), 1.0f).build();
	//Actual Foods
	public static final RegistryObject<Item> syrupBottle = itemRegistry.register("syrup_bottle", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.GOLDEN_CARROT)));
	public static final RegistryObject<Item> pancake = itemRegistry.register("pancake", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(pancakeFood)));
	public static final RegistryObject<Item> pancakeWithSyrup = itemRegistry.register("syrup_pancake", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(syrupPancakeFood)));
	public static final RegistryObject<Item> banana = itemRegistry.register("banana", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(bananaFood)));
	public static final RegistryObject<Item> snakeVenom = itemRegistry.register("venom", () -> new Item(new Item.Properties().group(ItemGroup.MISC).food(venomFood))); //Very bad
	
	//Tools
	public static final RegistryObject<AxeItem> emeraldAxe = itemRegistry.register("emerald_axe", () -> new AxeItem(EmeraldItemTier.EMERALD, -0.5F, -2F, (new Item.Properties().group(ItemGroup.TOOLS))));
	public static final RegistryObject<PickaxeItem> emeraldPickaxe = itemRegistry.register("emerald_pickaxe", () -> new PickaxeItem(EmeraldItemTier.EMERALD, -1, -3.4F, (new Item.Properties().group(ItemGroup.TOOLS))));
	public static final RegistryObject<HoeItem> emeraldHoe = itemRegistry.register("emerald_hoe", () -> new HoeItem(EmeraldItemTier.EMERALD, -0F, (new Item.Properties().group(ItemGroup.TOOLS))));
	public static final RegistryObject<ShovelItem> emeraldShovel = itemRegistry.register("emerald_shovel", () -> new ShovelItem(EmeraldItemTier.EMERALD, -1.2F, -1F, (new Item.Properties().group(ItemGroup.TOOLS))));
	public static final RegistryObject<ChainsawItem> chainsaw = itemRegistry.register("chainsaw", () -> new ChainsawItem());
	public static final RegistryObject<MagnetItem> magnet = itemRegistry.register("magnet", () -> new MagnetItem());
	public static final RegistryObject<Tunneler> tunneler = itemRegistry.register("tunneler", () -> new Tunneler(false));
	public static final RegistryObject<Tunneler> supaTunneler = itemRegistry.register("supa_tunneler", () -> new Tunneler(true));
	
	//Weapon
	public static final RegistryObject<SwordItem> emeraldSword = itemRegistry.register("emerald_sword", () -> new SwordItem(EmeraldItemTier.EMERALD, 9, -5.2F, (new Item.Properties().group(ItemGroup.COMBAT))));
	
	//Armor
	public static final RegistryObject<ArmorItem> emeraldHelmet = itemRegistry.register("emerald_helmet", () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.HEAD, (new Item.Properties().group(ItemGroup.COMBAT))));
	public static final RegistryObject<ArmorItem> emeraldChestplate = itemRegistry.register("emerald_chestplate", () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.CHEST, (new Item.Properties().group(ItemGroup.COMBAT))));
	public static final RegistryObject<ArmorItem> emeraldLeggings = itemRegistry.register("emerald_leggings", () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.LEGS, (new Item.Properties().group(ItemGroup.COMBAT))));
	public static final RegistryObject<ArmorItem> emeraldBoots = itemRegistry.register("emerald_boots", () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.FEET, (new Item.Properties().group(ItemGroup.COMBAT))));

	//SpawnEggs
	public static final RegistryObject<SpawnEggItem> leopardSpawnEgg = itemRegistry.register("leopard_spawn_egg", () -> new SpawnEggItem(LeopardEntity.getEntityType(), 15585032, 0, new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<SpawnEggItem> snakeSpawnEgg = itemRegistry.register("snake_spawn_egg", () -> new SpawnEggItem(SnakeEntity.getEntityType(), 894731, 8978176, new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<SpawnEggItem> monkeySpawnEgg = itemRegistry.register("monkey_spawn_egg", () -> new SpawnEggItem(MonkeyEntity.getEntityType(), 7555121, 16579584, new Item.Properties().group(ItemGroup.MISC)));
	
	//OtherItems
	public static final RegistryObject<Item> sapBottle = itemRegistry.register("sap_bottle", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> batter = itemRegistry.register("batter", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> snakeskin = itemRegistry.register("snakeskin", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

}