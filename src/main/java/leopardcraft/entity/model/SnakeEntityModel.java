package leopardcraft.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import leopardcraft.entity.SnakeEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class SnakeEntityModel<S extends SnakeEntity> extends EntityModel<S> {
	private final ModelRenderer SnakeBody;
	private final ModelRenderer MainBody;
	private final ModelRenderer Body1;
	private final ModelRenderer Body2;
	private final ModelRenderer Body3;
	private final ModelRenderer Body4;
	private final ModelRenderer Body5;
	private final ModelRenderer Head;
	private final ModelRenderer MainHead;
	private final ModelRenderer OuterHeadFrame;
	private final ModelRenderer Vertical;
	private final ModelRenderer Top;
	private final ModelRenderer Bottom;
	private final ModelRenderer Horizontal;
	private final ModelRenderer Left;
	private final ModelRenderer Right;
	private final ModelRenderer MouthArea;
	private final ModelRenderer Mouth;
	private final ModelRenderer Fangs;
	private final ModelRenderer Fang1;
	private final ModelRenderer Fang2;
	private final ModelRenderer Tongue;
	private final ModelRenderer MainTongue;
	private final ModelRenderer ForkLeft;
	private final ModelRenderer ForkRight;

	public SnakeEntityModel() {
		textureWidth = 128;
		textureHeight = 128;

		SnakeBody = new ModelRenderer(this);
		SnakeBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		SnakeBody.addChild(MainBody);
		

		Body1 = new ModelRenderer(this);
		Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainBody.addChild(Body1);
		Body1.setTextureOffset(29, 1).func_228303_a_(-1.0F, -1.0F, -20.0F, 4.0F, 1.0F, 21.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainBody.addChild(Body2);
		setRotationAngle(Body2, 0.0F, 0.7854F, 0.0F);
		Body2.setTextureOffset(0, 44).func_228303_a_(-1.0F, -1.0F, -14.0F, 4.0F, 1.0F, 15.0F, 0.0F, false);

		Body3 = new ModelRenderer(this);
		Body3.setRotationPoint(-10.0F, 0.0F, 8.0F);
		MainBody.addChild(Body3);
		Body3.setTextureOffset(29, 29).func_228303_a_(-1.0F, -1.0F, -20.0F, 4.0F, 1.0F, 21.0F, 0.0F, false);

		Body4 = new ModelRenderer(this);
		Body4.setRotationPoint(-5.0F, 0.0F, 25.0F);
		MainBody.addChild(Body4);
		setRotationAngle(Body4, 0.0F, 0.2618F, 0.0F);
		Body4.setTextureOffset(0, 22).func_228303_a_(-1.0F, -1.0F, -20.0F, 4.0F, 1.0F, 21.0F, 0.0F, false);

		Body5 = new ModelRenderer(this);
		Body5.setRotationPoint(-5.0F, 0.0F, 44.0F);
		MainBody.addChild(Body5);
		Body5.setTextureOffset(0, 0).func_228303_a_(-1.0F, -1.0F, -20.0F, 4.0F, 1.0F, 21.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		SnakeBody.addChild(Head);
		

		MainHead = new ModelRenderer(this);
		MainHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(MainHead);
		MainHead.setTextureOffset(38, 51).func_228303_a_(-1.0F, -6.0F, -23.0F, 7.0F, 6.0F, 5.0F, 0.0F, false);

		OuterHeadFrame = new ModelRenderer(this);
		OuterHeadFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(OuterHeadFrame);
		

		Vertical = new ModelRenderer(this);
		Vertical.setRotationPoint(0.0F, 0.0F, 0.0F);
		OuterHeadFrame.addChild(Vertical);
		

		Top = new ModelRenderer(this);
		Top.setRotationPoint(0.0F, 0.0F, 0.0F);
		Vertical.addChild(Top);
		Top.setTextureOffset(0, 0).func_228303_a_(-1.0F, -6.0F, -26.0F, 7.0F, 1.0F, 3.0F, 0.0F, false);

		Bottom = new ModelRenderer(this);
		Bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		Vertical.addChild(Bottom);
		Bottom.setTextureOffset(0, 4).func_228303_a_(-1.0F, -1.0F, -26.0F, 7.0F, 1.0F, 3.0F, 0.0F, false);

		Horizontal = new ModelRenderer(this);
		Horizontal.setRotationPoint(0.0F, 0.0F, 0.0F);
		OuterHeadFrame.addChild(Horizontal);
		

		Left = new ModelRenderer(this);
		Left.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horizontal.addChild(Left);
		Left.setTextureOffset(8, 22).func_228303_a_(-1.0F, -6.0F, -26.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);

		Right = new ModelRenderer(this);
		Right.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horizontal.addChild(Right);
		Right.setTextureOffset(0, 22).func_228303_a_(5.0F, -6.0F, -26.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);

		MouthArea = new ModelRenderer(this);
		MouthArea.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(MouthArea);
		

		Mouth = new ModelRenderer(this);
		Mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		MouthArea.addChild(Mouth);
		Mouth.setTextureOffset(0, 14).func_228303_a_(0.0F, -5.0F, -24.0F, 5.0F, 4.0F, 0.0F, 0.0F, false);

		Fangs = new ModelRenderer(this);
		Fangs.setRotationPoint(0.0F, 0.0F, 0.0F);
		MouthArea.addChild(Fangs);
		

		Fang1 = new ModelRenderer(this);
		Fang1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Fangs.addChild(Fang1);
		Fang1.setTextureOffset(8, 8).func_228303_a_(0.0F, -5.0F, -25.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Fang2 = new ModelRenderer(this);
		Fang2.setRotationPoint(4.0F, 0.0F, 0.0F);
		Fangs.addChild(Fang2);
		Fang2.setTextureOffset(0, 8).func_228303_a_(0.0F, -5.0F, -25.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Tongue = new ModelRenderer(this);
		Tongue.setRotationPoint(0.0F, 0.0F, 0.0F);
		MouthArea.addChild(Tongue);
		

		MainTongue = new ModelRenderer(this);
		MainTongue.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tongue.addChild(MainTongue);
		MainTongue.setTextureOffset(53, 53).func_228303_a_(1.0F, -2.0F, -32.0F, 2.0F, 1.0F, 9.0F, 0.0F, false);

		ForkLeft = new ModelRenderer(this);
		ForkLeft.setRotationPoint(8.0F, 0.0F, 3.0F);
		Tongue.addChild(ForkLeft);
		setRotationAngle(ForkLeft, 0.0F, 0.2618F, 0.0F);
		ForkLeft.setTextureOffset(8, 9).func_228303_a_(1.0F, -2.0F, -38.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		ForkRight = new ModelRenderer(this);
		ForkRight.setRotationPoint(-12.0F, 0.0F, -1.0F);
		Tongue.addChild(ForkRight);
		setRotationAngle(ForkRight, 0.0F, -0.2618F, 0.0F);
		ForkRight.setTextureOffset(0, 8).func_228303_a_(4.8637F, -2.0F, -36.9647F, 2.0F, 1.0F, 4.0F, 0.0F, false);
	}
	
	@Override
	public void func_225597_a_(S entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}
	
	@Override
	public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		SnakeBody.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}