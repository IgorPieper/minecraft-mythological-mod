package net.mmmteam.minecraftmythologicalmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.client.ModModelLayers;
import net.mmmteam.minecraftmythologicalmod.entity.client.RacoonModel;

@Mod.EventBusSubscriber(modid = MinecraftMythologicalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RACOON_LAYER, RacoonModel::createBodyLayer);
    }
}
