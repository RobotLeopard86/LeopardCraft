package leopardcraft.entity.model;
// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import leopardcraft.entity.MonkeyEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MonkeyEntityModel<M extends MonkeyEntity> extends EntityModel<M> {
	private final ModelRenderer MainMonkeyBody;
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Leg1;
	private final ModelRenderer MainLeg1;
	private final ModelRenderer Foot1;
	private final ModelRenderer Leg2;
	private final ModelRenderer MainLeg2;
	private final ModelRenderer Foot2;
	private final ModelRenderer Leg3;
	private final ModelRenderer MainLeg3;
	private final ModelRenderer Foot3;
	private final ModelRenderer Leg4;
	private final ModelRenderer MainLeg4;
	private final ModelRenderer Foot4;
	private final ModelRenderer Neck;
	private final ModelRenderer Head;
	private final ModelRenderer MainHead;
	private final ModelRenderer Ears;
	private final ModelRenderer Ear1;
	private final ModelRenderer Ear2;
	private final ModelRenderer Tail;
	private final ModelRenderer MainTail;
	private final ModelRenderer TailEnd;

	public MonkeyEntityModel() {
		textureWidth = 128;
		textureHeight = 128;

		MainMonkeyBody = new ModelRenderer(this);
		MainMonkeyBody.setRotationPoint(-2.0F, 24.0F, 0.0F);
		

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainMonkeyBody.addChild(Body);
		setRotationAngle(Body, -0.2618F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 0).func_228303_a_(-4.0F, -16.0F, -20.0F, 13.0F, 6.0F, 26.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainMonkeyBody.addChild(Legs);
		

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(-4.0F, 0.0F, 2.0F);
		Legs.addChild(Leg1);
		

		MainLeg1 = new ModelRenderer(this);
		MainLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(MainLeg1);
		MainLeg1.setTextureOffset(44, 44).func_228303_a_(1.0F, -9.0F, 5.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		Foot1 = new ModelRenderer(this);
		Foot1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(Foot1);
		Foot1.setTextureOffset(10, 22).func_228303_a_(0.0F, -1.0F, 4.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(6.0F, 0.0F, 2.0F);
		Legs.addChild(Leg2);
		

		MainLeg2 = new ModelRenderer(this);
		MainLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(MainLeg2);
		MainLeg2.setTextureOffset(40, 44).func_228303_a_(1.0F, -9.0F, 5.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		Foot2 = new ModelRenderer(this);
		Foot2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(Foot2);
		Foot2.setTextureOffset(0, 22).func_228303_a_(0.0F, -1.0F, 4.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(-4.0F, 0.0F, -15.0F);
		Legs.addChild(Leg3);
		

		MainLeg3 = new ModelRenderer(this);
		MainLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg3.addChild(MainLeg3);
		MainLeg3.setTextureOffset(36, 44).func_228303_a_(1.0F, -14.0F, 5.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		Foot3 = new ModelRenderer(this);
		Foot3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg3.addChild(Foot3);
		Foot3.setTextureOffset(10, 19).func_228303_a_(0.0F, -1.0F, 4.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(6.0F, 0.0F, -15.0F);
		Legs.addChild(Leg4);
		

		MainLeg4 = new ModelRenderer(this);
		MainLeg4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg4.addChild(MainLeg4);
		MainLeg4.setTextureOffset(22, 0).func_228303_a_(1.0F, -14.0F, 5.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		Foot4 = new ModelRenderer(this);
		Foot4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg4.addChild(Foot4);
		Foot4.setTextureOffset(0, 19).func_228303_a_(0.0F, -1.0F, 4.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 2.0F, -1.0F);
		MainMonkeyBody.addChild(Neck);
		setRotationAngle(Neck, -0.0873F, 0.0F, 0.0F);
		Neck.setTextureOffset(0, 11).func_228303_a_(-1.0F, -23.0F, -19.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainMonkeyBody.addChild(Head);
		

		MainHead = new ModelRenderer(this);
		MainHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(MainHead);
		MainHead.setTextureOffset(0, 32).func_228303_a_(-3.0F, -30.0F, -24.0F, 11.0F, 8.0F, 7.0F, 0.0F, false);

		Ears = new ModelRenderer(this);
		Ears.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Ears);
		

		Ear1 = new ModelRenderer(this);
		Ear1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ears.addChild(Ear1);
		Ear1.setTextureOffset(13, 0).func_228303_a_(-2.0F, -34.0F, -23.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		Ear2 = new ModelRenderer(this);
		Ear2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ears.addChild(Ear2);
		Ear2.setTextureOffset(0, 0).func_228303_a_(4.0F, -34.0F, -23.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainMonkeyBody.addChild(Tail);
		

		MainTail = new ModelRenderer(this);
		MainTail.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(MainTail);
		MainTail.setTextureOffset(0, 0).func_228303_a_(1.0F, -12.0F, 8.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		TailEnd = new ModelRenderer(this);
		TailEnd.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailEnd);
		TailEnd.setTextureOffset(36, 36).func_228303_a_(0.0F, -13.0F, 14.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void func_225597_a_(M entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		MainMonkeyBody.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}