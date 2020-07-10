package leopardcraft.biome;

import leopardcraft.entity.SnakeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class SnakeInfestedJungleBiome extends Biome {

	public SnakeInfestedJungleBiome() {
		super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.JUNGLE).depth(0.1F).scale(0.2F).temperature(0.95F).downfall(0.9F).waterColor(4159204).waterFogColor(329011).parent((String)null));
		this.func_226711_a_(Feature.JUNGLE_TEMPLE.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
	    this.func_226711_a_(Feature.MINESHAFT.func_225566_b_(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
	    this.func_226711_a_(Feature.STRONGHOLD.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
	    DefaultBiomeFeatures.addCarvers(this);
	    DefaultBiomeFeatures.addStructures(this);
	    DefaultBiomeFeatures.addLakes(this);
	    DefaultBiomeFeatures.addMonsterRooms(this);
	    DefaultBiomeFeatures.addStoneVariants(this);
	    DefaultBiomeFeatures.addOres(this);
	    DefaultBiomeFeatures.addSedimentDisks(this);
	    DefaultBiomeFeatures.addBamboo(this);
	    DefaultBiomeFeatures.func_222323_C(this);
	    DefaultBiomeFeatures.addExtraDefaultFlowers(this);
	    DefaultBiomeFeatures.addJungleGrass(this);
	    DefaultBiomeFeatures.addMushrooms(this);
	    DefaultBiomeFeatures.addReedsAndPumpkins(this);
	    DefaultBiomeFeatures.addSprings(this);
	    DefaultBiomeFeatures.addJunglePlants(this);
	    DefaultBiomeFeatures.addFreezeTopLayer(this);
	    this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
	    this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
	    this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 40, 1, 2));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(SnakeEntity.SNAKE, 12, 4, 10));
	}

}
