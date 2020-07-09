package leopardcraft.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import leopardcraft.entity.LeopardEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class LeopardEntityModel<U extends LeopardEntity> extends AgeableModel<U> {
	private final ModelRenderer Body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg4;
	private final ModelRenderer leg3;
	private final ModelRenderer leg2;
	private final ModelRenderer mainbody;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer ear1;
	private final ModelRenderer outer;
	private final ModelRenderer inner;
	private final ModelRenderer ear2;
	private final ModelRenderer outer2;
	private final ModelRenderer inner2;
	private final ModelRenderer nose;
	private final ModelRenderer tail;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;

	public LeopardEntityModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, -10.0F);
		

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(leg1);
		leg1.setTextureOffset(0, 43).func_228303_a_(-7.0F, -6.0F, -6.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(12.0F, 0.0F, 10.0F);
		Body.addChild(leg4);
		leg4.setTextureOffset(0, 0).func_228303_a_(-7.0F, -6.0F, 14.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(0.0F, 0.0F, 10.0F);
		Body.addChild(leg3);
		leg3.setTextureOffset(18, 25).func_228303_a_(-7.0F, -6.0F, 14.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(leg2);
		leg2.setTextureOffset(26, 26).func_228303_a_(5.0F, -6.0F, -6.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		mainbody = new ModelRenderer(this);
		mainbody.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(mainbody);
		mainbody.setTextureOffset(0, 0).func_228303_a_(-8.0F, -15.0F, -6.0F, 16.0F, 9.0F, 34.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 4.0F, 1.0F);
		Body.addChild(neck);
		setRotationAngle(neck, 0.5236F, 0.0F, 0.0F);
		neck.setTextureOffset(42, 53).func_228303_a_(-6.0F, -6.0F, 23.1244F, 12.0F, 7.0F, 14.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, -7.0F, -14.0F);
		Body.addChild(head);
		head.setTextureOffset(0, 43).func_228303_a_(-7.0F, -18.2942F, 42.4904F, 16.0F, 12.0F, 12.0F, 0.0F, false);

		ear1 = new ModelRenderer(this);
		ear1.setRotationPoint(1.0F, 0.0F, -1.0F);
		head.addChild(ear1);
		

		outer = new ModelRenderer(this);
		outer.setRotationPoint(-3.0F, -21.0F, -9.0F);
		ear1.addChild(outer);
		setRotationAngle(outer, 0.0F, 0.0F, -0.2618F);
		outer.setTextureOffset(23, 0).func_228303_a_(-3.8105F, -2.8434F, 61.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		inner = new ModelRenderer(this);
		inner.setRotationPoint(-9.0F, 0.0F, 0.0F);
		ear1.addChild(inner);
		setRotationAngle(inner, 0.0F, 0.0F, -0.2618F);
		inner.setTextureOffset(11, 14).func_228303_a_(8.7131F, -20.7997F, 54.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		ear2 = new ModelRenderer(this);
		ear2.setRotationPoint(2.0F, 1.0F, -1.0F);
		head.addChild(ear2);
		setRotationAngle(ear2, 0.0F, 0.0F, 0.4363F);
		

		outer2 = new ModelRenderer(this);
		outer2.setRotationPoint(-3.0F, -21.0F, -9.0F);
		ear2.addChild(outer2);
		setRotationAngle(outer2, 0.0F, 0.0F, -0.2618F);
		outer2.setTextureOffset(22, 14).func_228303_a_(-3.8105F, -2.8434F, 61.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		inner2 = new ModelRenderer(this);
		inner2.setRotationPoint(-9.0F, 0.0F, 0.0F);
		ear2.addChild(inner2);
		setRotationAngle(inner2, 0.0F, 0.0F, -0.2618F);
		inner2.setTextureOffset(0, 14).func_228303_a_(8.7131F, -20.7997F, 54.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(nose);
		nose.setTextureOffset(0, 0).func_228303_a_(-2.0F, -12.0F, 54.0F, 7.0F, 5.0F, 9.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(tail);
		

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 0.0F, 2.0F);
		tail.addChild(tail1);
		setRotationAngle(tail1, 0.1745F, 0.0F, 0.0F);
		tail1.setTextureOffset(0, 23).func_228303_a_(-2.0F, -11.0F, -13.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 3.0F, -5.0F);
		tail.addChild(tail2);
		tail2.setTextureOffset(11, 16).func_228303_a_(-2.0F, -11.75F, -13.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 5.0F, -13.0F);
		tail.addChild(tail3);
		setRotationAngle(tail3, -0.1745F, 0.0F, 0.0F);
		tail3.setTextureOffset(0, 14).func_228303_a_(-2.0F, -12.75F, -13.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);
	} 

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void func_225597_a_(U entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void func_225598_a_(MatrixStack matrixStackIn, IVertexBuilder vertexBuilderIn, int integer_1, int integer_2,
			float float_1, float float_2, float float_3, float float_4) {
		Body.func_228309_a_(matrixStackIn, vertexBuilderIn, integer_1, integer_2, float_1, float_2, float_3, float_4);
	}

	@Override
	protected Iterable<ModelRenderer> func_225602_a_() {
		return null;
	}

	@Override
	protected Iterable<ModelRenderer> func_225600_b_() {
		return null;
	}
}