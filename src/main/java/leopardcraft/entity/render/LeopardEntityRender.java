package leopardcraft.entity.render;

import leopardcraft.base.LeopardCraft;
import leopardcraft.entity.LeopardEntity;
import leopardcraft.entity.model.LeopardEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.minecraft.util.ResourceLocation;

public class LeopardEntityRender extends MobRenderer<LeopardEntity, LeopardEntityModel<LeopardEntity>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(LeopardCraft.ModId, "textures/entity/leopard/leopard_texture.png");
	
	public LeopardEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LeopardEntityModel<LeopardEntity>(), 0.5F);
	}
	
	
	public ResourceLocation getEntityTexture(LeopardEntity leopard) {
		return TEXTURE;
	}
}
