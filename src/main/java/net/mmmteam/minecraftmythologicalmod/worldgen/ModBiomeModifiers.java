package net.mmmteam.minecraftmythologicalmod.worldgen;

import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_OLIVE = registerKey("add_tree_olive");

    public static final ResourceKey<BiomeModifier> ADD_IRIS = registerKey("add_iris");
    public static final ResourceKey<BiomeModifier> ADD_ACONITE = registerKey("add_aconite");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_OLIVE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OLIVE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_IRIS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.IRIS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ACONITE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ACONITE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, name));
    }
}