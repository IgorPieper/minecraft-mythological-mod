package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.mmmteam.minecraftmythologicalmod.entity.animations.BalkanLynxModAnimationDefinitions;
import net.mmmteam.minecraftmythologicalmod.entity.custom.BalkanLynxEntity;

public class BalkanLynxModel<T extends BalkanLynxEntity> extends HierarchicalModel<T> {

	private final ModelPart balkanlynx;

	public BalkanLynxModel(ModelPart root) {
		this.balkanlynx = root.getChild("balkanlynx");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition balkanlynx = partdefinition.addOrReplaceChild("balkanlynx", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = balkanlynx.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 14).addBox(3.0F, -5.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 14).addBox(-2.0F, -5.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 12).addBox(-0.5F, -0.02F, -3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -10.5F, -7.0F));

		PartDefinition body = balkanlynx.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 2.0F));

		PartDefinition body_rotation = body.addOrReplaceChild("body_rotation", CubeListBuilder.create().texOffs(18, 14).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition mane = balkanlynx.addOrReplaceChild("mane", CubeListBuilder.create(), PartPose.offset(-1.0F, -10.0F, 2.0F));

		PartDefinition mane_rotation = mane.addOrReplaceChild("mane_rotation", CubeListBuilder.create().texOffs(22, 1).addBox(-3.0F, -4.5F, -0.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.5F, -2.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = balkanlynx.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -8.0F, 7.0F));

		PartDefinition leg2 = balkanlynx.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -8.0F, 7.0F));

		PartDefinition leg3 = balkanlynx.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -8.0F, -4.0F));

		PartDefinition leg4 = balkanlynx.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -8.0F, -4.0F));

		PartDefinition tail = balkanlynx.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(9, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -12.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(BalkanLynxModAnimationDefinitions.BALKANLYNX_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		balkanlynx.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return balkanlynx;
	}
}