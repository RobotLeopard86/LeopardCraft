package leopardcraft.entity.render;

import leopardcraft.base.LeopardCraft;
import leopardcraft.entity.MonkeyEntity;
import leopardcraft.entity.model.MonkeyEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MonkeyEntityRender extends MobRenderer<MonkeyEntity, MonkeyEntityModel<MonkeyEntity>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(LeopardCraft.ModId, "textures/entity/monkey/monkey_texture.png");
	
	public MonkeyEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MonkeyEntityModel<MonkeyEntity>(), 0.827F);
	}
	
	
	public ResourceLocation getEntityTexture(MonkeyEntity monkey) {
		return TEXTURE;
	}
}
