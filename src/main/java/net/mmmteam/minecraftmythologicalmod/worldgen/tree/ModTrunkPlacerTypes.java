package net.mmmteam.minecraftmythologicalmod.worldgen.tree;

import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.worldgen.tree.custom.OliveTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<OliveTrunkPlacer>> OLIVE_TRUNK_PLACER =
            TRUNK_PLACERS.register("olive_trunk_placer", () -> new TrunkPlacerType<>(OliveTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}