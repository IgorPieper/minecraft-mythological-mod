package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.SikaDeerEntity;

public class SikaDeerRenderer extends MobRenderer<SikaDeerEntity, SikaDeerModel<SikaDeerEntity>> {
    public SikaDeerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SikaDeerModel<>(pContext.bakeLayer(ModModelLayers.SIKADEER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SikaDeerEntity pEntity) {
        return new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "textures/entity/sikadeer.png");
    }

    @Override
    public void render(SikaDeerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
