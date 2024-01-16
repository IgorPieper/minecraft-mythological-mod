package net.mmmteam.minecraftmythologicalmod.worldgen;

import net.minecraft.world.level.levelgen.placement.*;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OLIVE_PLACED_KEY = registerKey("olive_placed");
    public static final ResourceKey<PlacedFeature> IRIS_PLACED_KEY = registerKey("iris_placed");
    public static final ResourceKey<PlacedFeature> ACONITE_PLACED_KEY = registerKey("aconite_placed");
    public static final ResourceKey<PlacedFeature> SPIDER_LILY_PLACED_KEY = registerKey("spider_lily_placed");
    public static final ResourceKey<PlacedFeature> LAUREL_PLACED_KEY = registerKey("laurel_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OLIVE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLIVE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.OLIVE_SAPLING.get()));

        register(context, IRIS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.IRIS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, ACONITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ACONITE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, SPIDER_LILY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPIDER_LILY_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, LAUREL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAUREL_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}