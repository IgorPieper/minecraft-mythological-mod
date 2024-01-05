package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.mmmteam.minecraftmythologicalmod.entity.animations.MinotaurModAnimationDefinitions;
import net.mmmteam.minecraftmythologicalmod.entity.custom.MinotaurEntity;

public class MinotaurModel<T extends MinotaurEntity> extends HierarchicalModel<T> {

	private final ModelPart minotaur;

	public MinotaurModel(ModelPart root) {
		this.minotaur = root.getChild("minotaur");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition minotaur = partdefinition.addOrReplaceChild("minotaur", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leg1 = minotaur.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition thigh1 = leg1.addOrReplaceChild("thigh1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = thigh1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(72, 61).addBox(-8.0F, -25.0F, -14.0F, 8.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition knee1 = leg1.addOrReplaceChild("knee1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 5.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r2 = knee1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -12.0F, -1.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition ankle1 = leg1.addOrReplaceChild("ankle1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = ankle1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 51).addBox(3.0F, -10.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition hoof1 = leg1.addOrReplaceChild("hoof1", CubeListBuilder.create().texOffs(97, 28).addBox(-6.0F, -3.0F, -5.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = minotaur.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition thigh2 = leg2.addOrReplaceChild("thigh2", CubeListBuilder.create(), PartPose.offset(8.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = thigh2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(72, 83).addBox(-7.0F, -25.0F, -14.0F, 8.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition knee2 = leg2.addOrReplaceChild("knee2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = knee2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -12.0F, -1.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 5.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition hoof2 = leg2.addOrReplaceChild("hoof2", CubeListBuilder.create().texOffs(64, 105).addBox(-6.0F, -3.0F, -5.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, 0.0F));

		PartDefinition ankle2 = leg2.addOrReplaceChild("ankle2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = ankle2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 107).addBox(-6.0F, -10.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition stomach = minotaur.addOrReplaceChild("stomach", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = stomach.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(67, 0).addBox(-7.0F, -38.0F, -2.0F, 15.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition chest = minotaur.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition cube_r8 = chest.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -44.0F, -7.0F, 25.0F, 16.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition arm1 = minotaur.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(36, 67).addBox(13.0F, 6.0F, -4.0F, 9.0F, 31.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -59.0F, -1.0F));

		PartDefinition arm2 = minotaur.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(0, 67).addBox(-4.5F, -15.5F, -4.5F, 9.0F, 31.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.5F, -37.5F, -0.5F));

		PartDefinition head = minotaur.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 33).addBox(-10.0906F, 0.5171F, -7.15F, 20.0F, 15.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(59, 33).addBox(-7.0906F, 7.5171F, -17.15F, 14.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(94, 51).addBox(9.9094F, -1.4829F, 0.85F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(84, 17).addBox(-22.0906F, -1.4829F, 0.85F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(100, 82).addBox(16.9094F, -12.4829F, -4.15F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(100, 62).addBox(-22.0906F, -12.4829F, -4.15F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(17.9094F, -14.4829F, -3.15F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-21.0906F, -14.4829F, -3.15F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0906F, -69.5171F, -5.85F));

		PartDefinition ear2_r1 = head.addOrReplaceChild("ear2_r1", CubeListBuilder.create().texOffs(95, 102).addBox(11.0F, -62.0F, -4.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0906F, 69.5171F, 5.85F, 0.0F, 0.0F, -0.4363F));

		PartDefinition ear1_r1 = head.addOrReplaceChild("ear1_r1", CubeListBuilder.create().texOffs(104, 0).addBox(-20.0F, -62.0F, -4.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0906F, 69.5171F, 5.85F, 0.0F, 0.0F, 0.4363F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(MinotaurModAnimationDefinitions.MINOTAUR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.attackAnimationState, MinotaurModAnimationDefinitions.MINOTAUR_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		minotaur.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return minotaur;
	}
}