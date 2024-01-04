package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.BalkanLynxEntity;

public class BalkanLynxRenderer extends MobRenderer<BalkanLynxEntity, BalkanLynxModel<BalkanLynxEntity>> {
    public BalkanLynxRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BalkanLynxModel<>(pContext.bakeLayer(ModModelLayers.BALKANLYNX_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BalkanLynxEntity pEntity) {
        return new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "textures/entity/balkanlynx.png");
    }

    @Override
    public void render(BalkanLynxEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
