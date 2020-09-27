package leopardcraft.base.tileentities;

import leopardcraft.base.LeopardCraft;
import leopardcraft.te.AndBlockTileEntity;
import leopardcraft.te.MapleLogTileEntity;
import leopardcraft.te.PulseExtenderBlockTileEntity;
import leopardcraft.te.SapTapperTileEntity;
import leopardcraft.te.TFlipFlopTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LCTEs {
	
	public static final DeferredRegister<TileEntityType<?>> teRegistry = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, LeopardCraft.ModId);
	
	private static final RegistryObject<TileEntityType<?>> sapTapperTe = teRegistry.register("sap_tapper_te", () -> SapTapperTileEntity.getTeType());
	private static final RegistryObject<TileEntityType<?>> mapleLogTe = teRegistry.register("maple_log_te", () -> MapleLogTileEntity.getTeType());
	private static final RegistryObject<TileEntityType<?>> andBlockTe = teRegistry.register("and_block_te", () -> AndBlockTileEntity.getTeType());
	private static final RegistryObject<TileEntityType<?>> peBlockTe = teRegistry.register("pe_block_te", () -> PulseExtenderBlockTileEntity.getTeType());
	private static final RegistryObject<TileEntityType<?>> tffBlockTe = teRegistry.register("tff_block_te", () -> TFlipFlopTileEntity.getTeType());
}