package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.CyclopsEntity;

public class CyclopsRenderer extends MobRenderer<CyclopsEntity, CyclopsModel<CyclopsEntity>> {
    public CyclopsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CyclopsModel<>(pContext.bakeLayer(ModModelLayers.CYCLOPS_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(CyclopsEntity pEntity) {
        return new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "textures/entity/cyclops.png");
    }

    @Override
    public void render(CyclopsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}

