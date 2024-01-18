package net.mmmteam.minecraftmythologicalmod.event;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.entity.client.*;
import net.mmmteam.minecraftmythologicalmod.block.entity.ModBlockEntities;


@Mod.EventBusSubscriber(modid = MinecraftMythologicalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RACOON_LAYER, RacoonModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CYCLOPS_LAYER, CyclopsModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BALKANLYNX_LAYER, BalkanLynxModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MINOTAUR_LAYER, MinotaurModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.KITSUNE_LAYER, KitsuneModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ONI_LAYER, OniModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.KOI_FISH_LAYER, KoiFishModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.OLIVE_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.OLIVE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        event.registerLayerDefinition(ModModelLayers.STICK_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.STICK_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        event.registerLayerDefinition(ModModelLayers.TORII_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.TORII_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

    }
//    @SubscribeEvent
//    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//
//        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
//        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
//    }

    @SubscribeEvent
    public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null &&
                pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), ModBlocks.OLIVE_LEAVES.get());
    }

    @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.register((pStack, pTintIndex) -> {
            BlockState state = ((BlockItem)pStack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, null, null, pTintIndex);
        }, ModBlocks.OLIVE_LEAVES.get());
    }
}
