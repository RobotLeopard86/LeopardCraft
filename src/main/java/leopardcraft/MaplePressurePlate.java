package leopardcraft;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;

public class MaplePressurePlate extends PressurePlateBlock {
	
	public MaplePressurePlate() {
		super(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.JUNGLE_PRESSURE_PLATE));
		this.setRegistryName("maple_pressure_plate");
	}
}