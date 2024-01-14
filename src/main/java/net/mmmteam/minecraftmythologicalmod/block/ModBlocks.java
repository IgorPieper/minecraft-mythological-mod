package net.mmmteam.minecraftmythologicalmod.block;

import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.custom.*;
import net.mmmteam.minecraftmythologicalmod.fluid.ModFluids;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.mmmteam.minecraftmythologicalmod.worldgen.tree.OliveTreeGrower;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.sounds.SoundEvents;
import net.mmmteam.minecraftmythologicalmod.util.*;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<Block> LAUREL_BUSH_CROP = BLOCKS.register("laurel_bush_crop",
            () -> new LaurelBushCrop(BlockBehaviour.Properties.copy(Blocks.CARROTS).noCollission().noOcclusion()));

    public static final RegistryObject<Block> LAUREL_BUSH = registerBlock("laurel_bush",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> IRIS = registerBlock("iris",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_IRIS = BLOCKS.register("potted_iris",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.IRIS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));
    public static final RegistryObject<Block> ACONITE = registerBlock("aconite",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.TORCHFLOWER).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_ACONITE = BLOCKS.register("potted_aconite",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ACONITE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_TORCHFLOWER).noOcclusion()));
    public static final RegistryObject<Block> SPIDER_LILY = registerBlock("spider_lily",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.BLUE_ORCHID).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_SPIDER_LILY = BLOCKS.register("potted_spider_lily",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.SPIDER_LILY,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_BLUE_ORCHID).noOcclusion()));

    public static final RegistryObject<Block> OLIVE_SLAB = registerBlock("olive_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_STAIRS = registerBlock("olive_stairs",
            () -> new StairBlock(() -> ModBlocks.OLIVE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_BUTTON = registerBlock("olive_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD),
                    BlockSetType.OAK));
    public static final RegistryObject<Block> OLIVE_FENCE = registerBlock("olive_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_FENCE_GATE = registerBlock("olive_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> OLIVE_WALL = registerBlock("olive_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_DOOR = registerBlock("olive_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> OLIVE_TRAPDOOR = registerBlock("olive_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> OLIVE_LOG = registerBlock("olive_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> OLIVE_WOOD = registerBlock("olive_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
//    public static final RegistryObject<Block> OLIVE_SIGN = BLOCKS.register("olive_sign",
//            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.OLIVE));
//    public static final RegistryObject<Block> OLIVE_WALL_SIGN = BLOCKS.register("olive_wall_sign",
//            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.OLIVE));
//    public static final RegistryObject<Block> OLIVE_HANGING_SIGN = BLOCKS.register("olive_hanging_sign",
//            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.OLIVE));
//    public static final RegistryObject<Block> OLIVE_WALL_HANGING_SIGN = BLOCKS.register("olive_wall_hanging_sign",
//            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.OLIVE));
  

    public static final RegistryObject<Block> STICK_STAIRS = registerBlock("stick_stairs",
            () -> new StairBlock(() -> ModBlocks.STICK_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STICK_SLAB = registerBlock("stick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STICK_BUTTON = registerBlock("stick_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> STICK_PRESSURE_PLATE = registerBlock("stick_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD),
                    BlockSetType.OAK));
    public static final RegistryObject<Block> STICK_FENCE = registerBlock("stick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STICK_FENCE_GATE = registerBlock("stick_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> STICK_WALL = registerBlock("stick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STICK_DOOR = registerBlock("stick_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> STICK_TRAPDOOR = registerBlock("stick_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> STICK_BLOCK = registerBlock("stick_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
//    public static final RegistryObject<Block> STICK_SIGN = BLOCKS.register("stick_sign",
//            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.STICK));
//    public static final RegistryObject<Block> STICK_WALL_SIGN = BLOCKS.register("stick_wall_sign",
//            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.STICK));
//    public static final RegistryObject<Block> STICK_HANGING_SIGN = BLOCKS.register("stick_hanging_sign",
//            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.STICK));
//    public static final RegistryObject<Block> STICK_WALL_HANGING_SIGN = BLOCKS.register("stick_wall_hanging_sign",
//            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.STICK));



    public static final RegistryObject<LiquidBlock> HADES_WATER_BLOCK = BLOCKS.register("hades_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HADES_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CHISELED_CALCITE = registerBlock("chiseled_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(() -> Blocks.CALCITE.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_SLAB).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_BUTTON = registerBlock("calcite_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.WET_SPONGE),
                    BlockSetType.STONE, 10, true));
    public static final RegistryObject<Block> CALCITE_PRESSURE_PLATE = registerBlock("calcite_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.WET_SPONGE),
                    BlockSetType.STONE));


    public static final RegistryObject<Block> DIMOND_BLOCK = registerBlock("dimond_block",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> DIMOND_STAIRS = registerBlock("dimond_stairs",
            () -> new StairBlock(() -> Blocks.CALCITE.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.PINK_PETALS)));
    public static final RegistryObject<Block> DIMOND_SLAB = registerBlock("dimond_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_SLAB).sound(SoundType.PINK_PETALS)));
    public static final RegistryObject<Block> DIMOND_BUTTON = registerBlock("dimond_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.PINK_PETALS),
                    BlockSetType.STONE, 10, true));
    public static final RegistryObject<Block> DIMOND_PRESSURE_PLATE = registerBlock("dimond_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.PINK_PETALS),
                    BlockSetType.STONE));
    public static final RegistryObject<Block> DIMOND_FENCE = registerBlock("dimond_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.PINK_PETALS)));
    public static final RegistryObject<Block> DIMOND_FENCE_GATE = registerBlock("dimond_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.PINK_PETALS), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> DIMOND_WALL = registerBlock("dimond_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.PINK_PETALS)));
    public static final RegistryObject<Block> DIMOND_DOOR = registerBlock("dimond_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.PINK_PETALS).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> DIMOND_TRAPDOOR = registerBlock("dimond_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.PINK_PETALS).noOcclusion(), BlockSetType.IRON));



    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> OLIVE_LEAVES = registerBlock("olive_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> OLIVE_SAPLING = registerBlock("olive_sapling",
            () -> new SaplingBlock(new OliveTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_OLIVE_SAPLING = BLOCKS.register("potted_olive_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.OLIVE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));

    public static final RegistryObject<Block> ANCIENT_PORTAL = registerBlock("ancient_portal",
            () -> new AncientPortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable().noOcclusion().noCollission()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}