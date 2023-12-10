package net.mmmteam.minecraftmythologicalmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.EntityInit;
import net.mmmteam.minecraftmythologicalmod.entity.custom.RacoonEntity;

@Mod.EventBusSubscriber(modid = MinecraftMythologicalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.RACOON.get(), RacoonEntity.createAttributes().build());
    }
}
