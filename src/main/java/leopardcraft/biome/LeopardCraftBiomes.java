package leopardcraft.biome;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class LeopardCraftBiomes {
	
	public static final Biome LEOPARD_SAVANNA = register(170, "leopard_savanna", new LeopardSavannaBiome());
	public static final Biome SHATTERED_LEOPARD_SAVANNA = register(171, "shattered_leopard_savanna", new ShatteredLeopardSavannaBiome());
	public static final Biome LEOPARD_SAVANNA_PLATEAU = register(172, "leopard_savanna_plateau", new LeopardSavannaPlateauBiome());
	public static final Biome SHATTERED_LEOPARD_SAVANNA_PLATEAU = register(173, "shattered_leopard_savanna_plateau", new ShatteredLeopardSavannaPlateauBiome());
	public static final Biome SNAKE_INFESTED_JUNGLE = register(174, "snake_infested_jungle", new SnakeInfestedJungleBiome());
	
	private static Biome register(int id, String key, Biome p_222369_2_) {
        Registry.register(Registry.BIOME, id, "leopardcraft:" + key, p_222369_2_);
        if (p_222369_2_.isMutation()) {
           Biome.MUTATION_TO_BASE_ID_MAP.put(p_222369_2_, Registry.BIOME.getId(Registry.BIOME.getOrDefault(new ResourceLocation(p_222369_2_.getParent()))));
        }

        return p_222369_2_;
     }
}
