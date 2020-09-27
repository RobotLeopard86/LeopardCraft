package leopardcraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.common.ToolType;

public class LeopardCraftHelpers {

	
	public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
		VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };

		int times = (to.getHorizontalIndex() - from.getHorizontalIndex() + 4) % 4;
		for (int i = 0; i < times; i++) {
			buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1], VoxelShapes.create(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = VoxelShapes.empty();
		}
		return buffer[0];
	}
	
	public static Block.Properties lcRedstoneBlockProperties = Block.Properties.create(Material.PISTON).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS);
	
	public enum HorizontalAxis implements IStringSerializable {
		X("x"),
		Z("z");

		private String name;
		
		private HorizontalAxis(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
	}
}