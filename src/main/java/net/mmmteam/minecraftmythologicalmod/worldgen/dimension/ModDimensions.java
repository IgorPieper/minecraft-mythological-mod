package net.mmmteam.minecraftmythologicalmod.worldgen.dimension;

import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
//import net.mmmteam.minecraftmythologicalmod.worldgen.biome.ModBiomes;

import java.util.List;
import java.util.OptionalLong;


public class ModDimensions {

    public static final ResourceKey<LevelStem> ANCIENT_WORLD_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "ancient_world"));
    public static final ResourceKey<Level> ANCIENT_WORLD_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "ancient_world"));
    public static final ResourceKey<DimensionType> ANCIENT_WORLD_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "ancient_world_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(ANCIENT_WORLD_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }
    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        //NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
        //new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.TEST_BIOME_2)),
        //noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                // Tutaj dodajemy z jakich biomów będzie składał się nasz świat
                                Pair.of(Climate.parameters(0.1F, 0F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.PLAINS)),
                                //Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.15F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.GREEK_ISLAND)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, -0.5F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.CHERRY_GROVE))
                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.ANCIENT_WORLD_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(ANCIENT_WORLD_KEY, stem);
    }
}


