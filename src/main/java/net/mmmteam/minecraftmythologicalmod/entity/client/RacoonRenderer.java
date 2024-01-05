package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.RacoonEntity;

public class RacoonRenderer extends MobRenderer<RacoonEntity, RacoonModel<RacoonEntity>> {
    public RacoonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RacoonModel<>(pContext.bakeLayer(ModModelLayers.RACOON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RacoonEntity pEntity) {
        return new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "textures/entity/racoon.png");
    }

    @Override
    public void render(RacoonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
