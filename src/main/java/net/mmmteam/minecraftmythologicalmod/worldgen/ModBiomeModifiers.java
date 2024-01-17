package net.mmmteam.minecraftmythologicalmod.worldgen;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
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
import net.mmmteam.minecraftmythologicalmod.entity.ModEntities;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_OLIVE = registerKey("add_tree_olive");

    public static final ResourceKey<BiomeModifier> ADD_IRIS = registerKey("add_iris");
    public static final ResourceKey<BiomeModifier> ADD_ACONITE = registerKey("add_aconite");
    public static final ResourceKey<BiomeModifier> ADD_SPIDER_LILY = registerKey("add_spider_lily");
    public static final ResourceKey<BiomeModifier> ADD_LAUREL = registerKey("add_laurel");

    public static final ResourceKey<BiomeModifier> SPAWN_RACOON = registerKey("spawn_racoon");
    public static final ResourceKey<BiomeModifier> SPAWN_CYCLOP = registerKey("spawn_cyclop");
    public static final ResourceKey<BiomeModifier> SPAWN_LYNX = registerKey("spawn_lynx");
    public static final ResourceKey<BiomeModifier> SPAWN_MINOTAUR = registerKey("spawn_minotaur");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_OLIVE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OLIVE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_IRIS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.IRIS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ACONITE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ACONITE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SPIDER_LILY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CHERRY_GROVE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SPIDER_LILY_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));;

        context.register(ADD_LAUREL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LAUREL_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SPAWN_RACOON, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.RACOON.get(), 40, 1, 6))));

        context.register(SPAWN_CYCLOP, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CYCLOPS.get(), 5, 1, 1))));

        context.register(SPAWN_LYNX, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.BALKANLYNX.get(), 20, 1, 2))));

        context.register(SPAWN_MINOTAUR, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MINOTAUR.get(), 5, 1, 1))));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, name));
    }

    //public static final TagKey<Biome> IS_CHERRY = TagKey.create(ForgeRegistries.Keys.BIOMES, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "is_cherry"));

}