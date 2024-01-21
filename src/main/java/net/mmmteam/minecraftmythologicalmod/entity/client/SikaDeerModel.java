package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.mmmteam.minecraftmythologicalmod.entity.custom.SikaDeerEntity;

public class SikaDeerModel<T extends SikaDeerEntity> extends HierarchicalModel<T> {

	private final ModelPart sikadeer;

	public SikaDeerModel(ModelPart root) {
		this.sikadeer = root.getChild("sikadeer");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sikadeer = partdefinition.addOrReplaceChild("sikadeer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = sikadeer.addOrReplaceChild("head", CubeListBuilder.create().texOffs(2, 61).addBox(-6.0F, -11.0F, -10.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -10.0F, 0.0F));

		PartDefinition mirror = head.addOrReplaceChild("mirror", CubeListBuilder.create().texOffs(2, 61).mirror().addBox(2.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 10.0F, 0.0F));

		PartDefinition nose = sikadeer.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(34, 46).addBox(-3.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -18.0F, -8.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition left_horn = sikadeer.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(12, 55).addBox(-0.01F, -16.0F, -10.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(1.99F, -20.0F, -10.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(3.99F, -20.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(3.99F, -16.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(1.99F, -22.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -10.0F, 0.0F));

		PartDefinition right_horn = sikadeer.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(12, 55).addBox(-2.99F, -16.0F, -10.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(-4.99F, -20.0F, -10.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(-4.99F, -22.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(-6.99F, -20.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 55).addBox(-6.99F, -16.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -10.0F, 0.0F));

		PartDefinition body = sikadeer.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, -17.0F, -7.0F, 9.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition leg1 = sikadeer.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(49, 29).addBox(0.0F, 2.0F, 0.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -10.0F, 4.0F));

		PartDefinition leg2 = sikadeer.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(36, 29).addBox(0.0F, 2.0F, 0.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -10.0F, 4.0F));

		PartDefinition leg3 = sikadeer.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(49, 2).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -10.0F, -6.0F));

		PartDefinition leg4 = sikadeer.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(35, 2).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -10.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		sikadeer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return sikadeer;
	}
}