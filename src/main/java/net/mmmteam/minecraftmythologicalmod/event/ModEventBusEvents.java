package net.mmmteam.minecraftmythologicalmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.ModEntities;
import net.mmmteam.minecraftmythologicalmod.entity.client.BalkanLynxModel;
import net.mmmteam.minecraftmythologicalmod.entity.custom.BalkanLynxEntity;
import net.mmmteam.minecraftmythologicalmod.entity.custom.CyclopsEntity;
import net.mmmteam.minecraftmythologicalmod.entity.custom.MinotaurEntity;
import net.mmmteam.minecraftmythologicalmod.entity.custom.RacoonEntity;

@Mod.EventBusSubscriber(modid = MinecraftMythologicalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RACOON.get(), RacoonEntity.createAttributes().build());
        event.put(ModEntities.CYCLOPS.get(), CyclopsEntity.createAttributes().build());
        event.put(ModEntities.BALKANLYNX.get(), BalkanLynxEntity.createAttributes().build());
        event.put(ModEntities.MINOTAUR.get(), MinotaurEntity.createAttributes().build());
    }
}
