package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.mmmteam.minecraftmythologicalmod.entity.animations.CyclopsModAnimationDefinitions;
import net.mmmteam.minecraftmythologicalmod.entity.custom.CyclopsEntity;

public class CyclopsModel<T extends CyclopsEntity> extends HierarchicalModel<T> {
	private final ModelPart cyclops;

	public CyclopsModel(ModelPart root) {
		this.cyclops = root.getChild("cyclops");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cyclops = partdefinition.addOrReplaceChild("cyclops", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = cyclops.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-7.5F, 10.0F, -4.0F, 15.0F, 9.0F, 7.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -31.0F, 0.0F));

		PartDefinition head = cyclops.addOrReplaceChild("head", CubeListBuilder.create().texOffs(50, 15).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(1.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -31.0F, -2.0F));

		PartDefinition right_arm = cyclops.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 39).addBox(-13.0F, -7.5F, -3.0F, 4.0F, 25.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(47, 0).addBox(-9.0F, -7.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -31.0F, 0.0F));

		PartDefinition left_arm = cyclops.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(38, 33).addBox(9.0F, -7.5F, -3.0F, 4.0F, 25.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 58).addBox(4.0F, -7.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -31.0F, 0.0F));

		PartDefinition right_leg = cyclops.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(58, 50).addBox(-3.5F, 1.0F, -3.0F, 6.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -13.0F, 0.0F));

		PartDefinition left_leg = cyclops.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(58, 33).addBox(-3.5F, 1.0F, -3.0F, 6.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -13.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(CyclopsEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(CyclopsModAnimationDefinitions.CYCLOPS_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.attackAnimationState, CyclopsModAnimationDefinitions.CYCLOPS_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cyclops.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return cyclops;
	}
}