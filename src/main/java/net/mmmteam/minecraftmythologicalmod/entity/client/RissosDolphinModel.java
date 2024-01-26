package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.mmmteam.minecraftmythologicalmod.entity.animations.RissosDolphinModAnimationDefinitions;
import net.mmmteam.minecraftmythologicalmod.entity.custom.RissosDolphinEntity;

public class RissosDolphinModel<T extends RissosDolphinEntity> extends HierarchicalModel<T> {
	private final ModelPart rissosdolphin;

	public RissosDolphinModel(ModelPart root) {
		this.rissosdolphin = root.getChild("rissosdolphin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rissosdolphin = partdefinition.addOrReplaceChild("rissosdolphin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = rissosdolphin.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -6.0F));

		PartDefinition whole_tail = rissosdolphin.addOrReplaceChild("whole_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = whole_tail.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, -2.5F, -1.0F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 11.0F));

		PartDefinition tail_fin = whole_tail.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(19, 20).addBox(-5.0F, -0.5F, -1.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 20.0F));

		PartDefinition whole_torso = rissosdolphin.addOrReplaceChild("whole_torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = whole_torso.addOrReplaceChild("body", CubeListBuilder.create().texOffs(22, 0).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition right_fin = whole_torso.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(48, 20).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 0.0F, -2.0F));

		PartDefinition left_fin = whole_torso.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(48, 20).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, -2.0F));

		PartDefinition back_fin = whole_torso.addOrReplaceChild("back_fin", CubeListBuilder.create().texOffs(51, 0).addBox(-0.5F, 0.0F, 8.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(RissosDolphinModAnimationDefinitions.RISSOSDOLPHIN_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rissosdolphin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return rissosdolphin;
	}
}