package net.mmmteam.minecraftmythologicalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.KoiFishEntity;

public class KoiFishRenderer extends MobRenderer<KoiFishEntity, KoiFishModel<KoiFishEntity>> {
    private static final ResourceLocation KOI_FISH_LOCATION = new ResourceLocation(MinecraftMythologicalMod.MOD_ID,"textures/entity/koi_fish.png");

    public KoiFishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new KoiFishModel<>(pContext.bakeLayer(ModModelLayers.KOI_FISH_LAYER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(KoiFishEntity pEntity) {
        return KOI_FISH_LOCATION;
    }

    @Override
    public void render(KoiFishEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}