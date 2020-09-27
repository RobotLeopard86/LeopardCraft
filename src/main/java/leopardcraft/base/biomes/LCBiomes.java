package leopardcraft.base.biomes;

import leopardcraft.base.LeopardCraft;
import leopardcraft.biome.JunglemaniaBiome;
import leopardcraft.biome.LeopardSavannaBiome;
import leopardcraft.biome.LeopardSavannaPlateauBiome;
import leopardcraft.biome.ShatteredLeopardSavannaBiome;
import leopardcraft.biome.ShatteredLeopardSavannaPlateauBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LCBiomes {
	
	public static final DeferredRegister<Biome> biomeRegistry = new DeferredRegister<>(ForgeRegistries.BIOMES, LeopardCraft.ModId);
	
	public static final RegistryObject<Biome> leopardSavannah = biomeRegistry.register("leopard_savannah", () -> new LeopardSavannaBiome());
	public static final RegistryObject<Biome> leopardSavannahPlateau = biomeRegistry.register("leopard_savannah_plateau", () -> new LeopardSavannaPlateauBiome());
	public static final RegistryObject<Biome> shatteredLeopardSavannah = biomeRegistry.register("shattered_leopard_savannah", () -> new ShatteredLeopardSavannaBiome());
	public static final RegistryObject<Biome> shatteredLeopardSavannahPlateau = biomeRegistry.register("shattered_leopard_savannah_plateau", () -> new ShatteredLeopardSavannaPlateauBiome());
	public static final RegistryObject<Biome> junglemania = biomeRegistry.register("junglemania", () -> new JunglemaniaBiome());
}