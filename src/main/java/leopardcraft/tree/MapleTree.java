/*package leopardcraft.tree;

import java.util.Random;

import leopardcraft.base.LeopardCraft;
import leopardcraft.base.blocks.LCBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class MapleTree extends Tree {
	public static final TreeFeatureConfig MAPLE_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(LCBlocks.mapleLog.get().getDefaultState()),
			new SimpleBlockStateProvider(LCBlocks.mapleLeaves.get().getDefaultState()),
			new BlobFoliagePlacer(1,1)).func_225569_d_(7).func_227354_b_(0).func_227360_i_(1).func_227352_a_().setSapling((IPlantable) LCBlocks.mapleSapling.get()).func_225568_b_();//.baseHeight(6).heightRandA(5) .foliageHeight(1).ignoreVines().build();
	public static final TreeFeatureConfig MAPLE_TREE_CONFIG_OTHER = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(LCBlocks.mapleLog.get().getDefaultState()),
			new SimpleBlockStateProvider(LCBlocks.mapleLeaves.get().getDefaultState()),
			new BlobFoliagePlacer(2, 1)).func_225569_d_(6).func_227354_b_(1).func_227360_i_(2).func_227352_a_().setSapling((IPlantable) LCBlocks.mapleSapling.get()).func_225568_b_();


	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> func_225546_b_(Random p_225546_1_, boolean p_225546_2_) {
		return p_225546_1_.nextInt(10) == 0 ? Feature.FANCY_TREE.func_225566_b_(MAPLE_TREE_CONFIGp_225546_2_ ? DefaultBiomeFeatures.field_226817_l_ : DefaultBiomeFeatures.field_226815_j_) : Feature.NORMAL_TREE.func_225566_b_(MAPLE_TREE_CONFIG_OTHER);
	}
}*/