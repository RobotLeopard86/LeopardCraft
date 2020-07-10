package leopardcraft.entity.render;

import leopardcraft.base.LeopardCraft;
import leopardcraft.entity.SnakeEntity;
import leopardcraft.entity.model.SnakeEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SnakeEntityRender extends MobRenderer<SnakeEntity, SnakeEntityModel<SnakeEntity>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(LeopardCraft.ModId, "textures/entity/snake/snake_texture.png");
	
	public SnakeEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SnakeEntityModel<SnakeEntity>(), 0.827F);
	}
	
	
	public ResourceLocation getEntityTexture(SnakeEntity snake) {
		return TEXTURE;
	}
}
