package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.mmmteam.minecraftmythologicalmod.entity.animations.KitsuneModAnimationDefinitions;
import net.mmmteam.minecraftmythologicalmod.entity.animations.KoiFishModAnimationDefinitions;
import net.mmmteam.minecraftmythologicalmod.entity.custom.KoiFishEntity;

public class KoiFishModel<T extends KoiFishEntity> extends HierarchicalModel<T> {

	private final ModelPart koi_fish;

	public KoiFishModel(ModelPart root) {
		this.koi_fish = root.getChild("koi_fish");
	}

		public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition koi_fish = partdefinition.addOrReplaceChild("koi_fish", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body_front = koi_fish.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -8.5F, 0.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, -4.0F));

		PartDefinition body_back = koi_fish.addOrReplaceChild("body_back", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, -8.5F, 0.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 4.0F));

		PartDefinition dorsal_back = body_back.addOrReplaceChild("dorsal_back", CubeListBuilder.create().texOffs(2, 3).addBox(0.0F, -5.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition tailfin = body_back.addOrReplaceChild("tailfin", CubeListBuilder.create().texOffs(20, 10).addBox(0.0F, -8.5F, 0.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition dorsal_front = body_front.addOrReplaceChild("dorsal_front", CubeListBuilder.create().texOffs(4, 2).addBox(0.0F, -5.5F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 6.0F));

		PartDefinition head = body_front.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -5.5F, -3.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition leftFin = body_front.addOrReplaceChild("leftFin", CubeListBuilder.create().texOffs(2, 0).addBox(-2.0075F, -2.867F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition rightFin = body_front.addOrReplaceChild("rightFin", CubeListBuilder.create().texOffs(-2, 0).addBox(0.0074F, -2.867F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(KoiFishModAnimationDefinitions.KOI_FISH_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		koi_fish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return koi_fish;
	}
}

