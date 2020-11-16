package me.redstoneguy129.gillygogs.bokunoheroesunited.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DarkShadowModel extends EntityModel<Entity> {
	private final ModelRenderer bipedHead;
	private final ModelRenderer bipedBody;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedRightLeg;
	private final ModelRenderer bipedLeftLeg;
	private final ModelRenderer ShadowBody;
	private final ModelRenderer bone33;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer Shadowrightarm;
	private final ModelRenderer bone8;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer Shadowleftarm;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer Shadowhead;
	private final ModelRenderer bone29;
	private final ModelRenderer bone31;
	private final ModelRenderer bone30;
	private final ModelRenderer bone32;
	private final ModelRenderer bone26;
	private final ModelRenderer bone28;
	private final ModelRenderer bone27;
	private final ModelRenderer bone22;
	private final ModelRenderer bone25;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;

	public DarkShadowModel() {
		textureWidth = 128;
		textureHeight = 128;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		

		ShadowBody = new ModelRenderer(this);
		ShadowBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(ShadowBody, -0.1745F, 0.0F, 0.0F);
		ShadowBody.setTextureOffset(26, 44).addBox(-3.5F, -16.3704F, -27.5318F, 7.0F, 8.0F, 4.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
		ShadowBody.addChild(bone33);
		setRotationAngle(bone33, 0.3491F, 0.0F, 0.0F);
		bone33.setTextureOffset(68, 0).addBox(-3.5F, -26.4315F, -20.5137F, 7.0F, 3.0F, 4.0F, -0.002F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		ShadowBody.addChild(bone);
		setRotationAngle(bone, 0.3491F, 0.0F, 0.0F);
		bone.setTextureOffset(63, 14).addBox(-3.5F, -17.282F, -23.0086F, 7.0F, 3.0F, 4.0F, -0.002F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.6109F, 0.0F, 0.0F);
		bone2.setTextureOffset(68, 30).addBox(-3.0F, -24.8964F, -10.6557F, 6.0F, 3.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.48F, 0.0F, 0.0F);
		bone3.setTextureOffset(20, 72).addBox(-2.5F, -24.3426F, 0.6589F, 5.0F, 5.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
		bone4.setTextureOffset(72, 72).addBox(-2.0F, -16.4217F, 10.2419F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.3927F, 0.0F, 0.0F);
		bone5.setTextureOffset(44, 80).addBox(-1.5F, -5.709F, 13.4505F, 3.0F, 6.0F, 4.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.5F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, -0.3054F, 0.0F, 0.0F);
		bone6.setTextureOffset(79, 47).addBox(-0.5F, -4.9699F, 12.7303F, 2.0F, 5.0F, 4.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.5F, 0.0F, 0.0F);
		bone6.addChild(bone7);
		setRotationAngle(bone7, 0.2182F, 0.0F, 0.0F);
		bone7.setTextureOffset(80, 37).addBox(-0.5F, 2.7847F, 12.4221F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		Shadowrightarm = new ModelRenderer(this);
		Shadowrightarm.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Shadowrightarm, 0.3054F, 0.0F, 0.1745F);
		Shadowrightarm.setTextureOffset(0, 16).addBox(-9.1811F, -27.1173F, -16.3498F, 2.0F, 5.0F, 2.0F, 0.101F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowrightarm.addChild(bone8);
		setRotationAngle(bone8, 0.9163F, 0.0F, 0.0F);
		bone8.setTextureOffset(57, 76).addBox(-9.1811F, -26.8486F, 2.8113F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone8.addChild(bone12);
		setRotationAngle(bone12, 0.7418F, 0.0F, 0.0F);
		bone12.setTextureOffset(24, 4).addBox(-9.199F, -19.4828F, 19.1493F, 2.0F, 3.0F, 1.0F, 0.1F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(bone13);
		setRotationAngle(bone13, 0.0F, 0.6545F, 0.0F);
		bone13.setTextureOffset(30, 0).addBox(-18.159F, -19.7828F, 10.9432F, 2.0F, 1.0F, 1.0F, -0.19F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 0.6545F, 0.0F);
		bone14.setTextureOffset(29, 22).addBox(-20.3273F, -19.7828F, -1.4422F, 2.0F, 1.0F, 1.0F, -0.2F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(bone9);
		setRotationAngle(bone9, 0.7418F, 0.0F, 0.0F);
		bone9.setTextureOffset(48, 10).addBox(-9.499F, -2.5577F, 27.3593F, 1.0F, 2.0F, 1.0F, -0.19F, false);
		bone9.setTextureOffset(48, 48).addBox(-7.899F, -2.5577F, 27.3593F, 1.0F, 2.0F, 1.0F, -0.19F, false);
		bone9.setTextureOffset(44, 25).addBox(-8.699F, -2.5577F, 27.3593F, 1.0F, 2.0F, 1.0F, -0.19F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.48F, 0.0F, 0.0F);
		bone10.setTextureOffset(44, 44).addBox(-9.499F, 9.1112F, 25.2662F, 1.0F, 2.0F, 1.0F, -0.2F, false);
		bone10.setTextureOffset(43, 21).addBox(-8.699F, 9.1112F, 25.2662F, 1.0F, 2.0F, 1.0F, -0.2F, false);
		bone10.setTextureOffset(25, 43).addBox(-7.899F, 9.1112F, 25.2662F, 1.0F, 2.0F, 1.0F, -0.2F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.5672F, 0.0F, 0.0F);
		bone11.setTextureOffset(21, 42).addBox(-7.899F, 20.0584F, 16.1811F, 1.0F, 2.0F, 1.0F, -0.201F, false);
		bone11.setTextureOffset(0, 42).addBox(-8.699F, 20.0584F, 16.1811F, 1.0F, 2.0F, 1.0F, -0.201F, false);
		bone11.setTextureOffset(26, 46).addBox(-9.499F, 21.0584F, 16.1811F, 1.0F, 1.0F, 1.0F, -0.201F, false);
		bone11.setTextureOffset(0, 45).addBox(-9.499F, 20.4584F, 16.1811F, 1.0F, 1.0F, 1.0F, -0.201F, false);

		Shadowleftarm = new ModelRenderer(this);
		Shadowleftarm.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Shadowleftarm, 0.3054F, 0.0F, -0.1745F);
		Shadowleftarm.setTextureOffset(0, 0).addBox(7.211F, -27.1123F, -16.3514F, 2.0F, 5.0F, 2.0F, 0.101F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowleftarm.addChild(bone15);
		setRotationAngle(bone15, 0.9163F, 0.0F, 0.0F);
		bone15.setTextureOffset(32, 75).addBox(7.211F, -26.8468F, 2.8063F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.7418F, 0.0F, 0.0F);
		bone16.setTextureOffset(24, 0).addBox(7.211F, -19.4836F, 19.1473F, 2.0F, 3.0F, 1.0F, 0.1F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone16.addChild(bone17);
		setRotationAngle(bone17, 0.0F, -0.6545F, 0.0F);
		bone17.setTextureOffset(29, 3).addBox(16.1674F, -19.7836F, 10.9344F, 2.0F, 1.0F, 1.0F, -0.19F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -0.6545F, 0.0F);
		bone18.setTextureOffset(24, 21).addBox(18.3285F, -19.7836F, -1.4543F, 2.0F, 1.0F, 1.0F, -0.2F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone16.addChild(bone19);
		setRotationAngle(bone19, 0.7418F, 0.0F, 0.0F);
		bone19.setTextureOffset(40, 24).addBox(6.911F, -2.5596F, 27.3584F, 1.0F, 2.0F, 1.0F, -0.19F, false);
		bone19.setTextureOffset(21, 32).addBox(8.511F, -2.5596F, 27.3584F, 1.0F, 2.0F, 1.0F, -0.19F, false);
		bone19.setTextureOffset(0, 32).addBox(7.711F, -2.5596F, 27.3584F, 1.0F, 2.0F, 1.0F, -0.19F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.48F, 0.0F, 0.0F);
		bone20.setTextureOffset(39, 21).addBox(6.911F, 9.1091F, 25.2663F, 1.0F, 2.0F, 1.0F, -0.2F, false);
		bone20.setTextureOffset(36, 24).addBox(7.711F, 9.1091F, 25.2663F, 1.0F, 2.0F, 1.0F, -0.2F, false);
		bone20.setTextureOffset(35, 21).addBox(8.511F, 9.1091F, 25.2663F, 1.0F, 2.0F, 1.0F, -0.2F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.5672F, 0.0F, 0.0F);
		bone21.setTextureOffset(21, 45).addBox(8.511F, 21.0566F, 16.1823F, 1.0F, 1.0F, 1.0F, -0.201F, false);
		bone21.setTextureOffset(0, 35).addBox(8.511F, 20.4566F, 16.1823F, 1.0F, 1.0F, 1.0F, -0.201F, false);
		bone21.setTextureOffset(24, 34).addBox(7.711F, 20.0566F, 16.1823F, 1.0F, 2.0F, 1.0F, -0.201F, false);
		bone21.setTextureOffset(32, 24).addBox(6.911F, 20.0566F, 16.1823F, 1.0F, 2.0F, 1.0F, -0.201F, false);

		Shadowhead = new ModelRenderer(this);
		Shadowhead.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Shadowhead, 0.1745F, 0.0F, 0.0F);
		Shadowhead.setTextureOffset(0, 0).addBox(-4.0F, -33.0082F, -22.4212F, 8.0F, 8.0F, 8.0F, -1.4F, false);
		Shadowhead.setTextureOffset(0, 68).addBox(-2.5F, -30.429F, -24.2157F, 5.0F, 4.0F, 5.0F, -1.402F, false);

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowhead.addChild(bone29);
		setRotationAngle(bone29, 0.0F, -0.829F, 0.0F);
		bone29.setTextureOffset(0, 42).addBox(-15.2071F, -30.3628F, -17.6035F, 8.0F, 5.0F, 5.0F, -1.7F, false);

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowhead.addChild(bone31);
		setRotationAngle(bone31, 0.0F, -0.829F, -0.2618F);
		bone31.setTextureOffset(0, 32).addBox(-9.9112F, -31.3838F, -23.0312F, 8.0F, 5.0F, 5.0F, -1.7F, false);

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowhead.addChild(bone30);
		setRotationAngle(bone30, 0.0F, 0.8325F, 0.0F);
		bone30.setTextureOffset(32, 0).addBox(7.2626F, -30.3628F, -17.5562F, 8.0F, 5.0F, 5.0F, -1.7F, false);

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowhead.addChild(bone32);
		setRotationAngle(bone32, 0.0F, 0.8325F, 0.2182F);
		bone32.setTextureOffset(27, 11).addBox(2.7978F, -31.778F, -22.1098F, 8.0F, 5.0F, 5.0F, -1.7F, false);

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowhead.addChild(bone26);
		setRotationAngle(bone26, -0.9599F, 0.0F, 0.0F);
		bone26.setTextureOffset(64, 38).addBox(-2.0F, -8.5101F, -39.3492F, 4.0F, 9.0F, 4.0F, -1.4F, false);

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone28);
		setRotationAngle(bone28, 0.0F, 0.0F, 0.0873F);
		bone28.setTextureOffset(32, 56).addBox(-0.3795F, -8.8898F, -38.7835F, 4.0F, 9.0F, 4.0F, -1.4F, false);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, 0.0F, 0.0F, -0.0873F);
		bone27.setTextureOffset(60, 60).addBox(-3.6623F, -8.8934F, -38.7835F, 4.0F, 9.0F, 4.0F, -1.4F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shadowhead.addChild(bone22);
		setRotationAngle(bone22, 0.3491F, 0.0F, 0.0F);
		bone22.setTextureOffset(64, 51).addBox(-2.5F, -36.5817F, -15.0112F, 5.0F, 4.0F, 5.0F, -1.5F, false);
		bone22.setTextureOffset(53, 5).addBox(-2.5F, -37.2219F, -14.988F, 5.0F, 4.0F, 5.0F, -1.502F, false);

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone22.addChild(bone25);
		setRotationAngle(bone25, 0.1309F, 0.0F, 0.0F);
		bone25.setTextureOffset(64, 21).addBox(-2.5F, -35.8309F, -11.1521F, 5.0F, 4.0F, 5.0F, -1.5F, false);
		bone25.setTextureOffset(43, 68).addBox(-2.5F, -35.7309F, -9.0521F, 5.0F, 4.0F, 5.0F, -1.4F, false);
		bone25.setTextureOffset(76, 60).addBox(-2.0F, -36.5175F, -11.6825F, 4.0F, 5.0F, 4.0F, -1.7F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, -11.9507F, -39.8294F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, -0.8727F, 0.0F, 0.0F);
		bone23.setTextureOffset(0, 77).addBox(-2.0F, -36.8866F, -2.5533F, 4.0F, 5.0F, 4.0F, -1.6F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone22.addChild(bone24);
		setRotationAngle(bone24, 0.3491F, 0.0F, 0.0F);
		bone24.setTextureOffset(47, 15).addBox(-2.5F, -39.1255F, -0.3858F, 5.0F, 5.0F, 6.0F, -1.4F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		ShadowBody.render(matrixStack, buffer, packedLight, packedOverlay);
		Shadowrightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		Shadowleftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		Shadowhead.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}