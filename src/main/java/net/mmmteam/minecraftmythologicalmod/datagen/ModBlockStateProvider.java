package net.mmmteam.minecraftmythologicalmod.datagen;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.block.custom.LaurelBushCrop;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.block.custom.RiceCropBlock;


import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MinecraftMythologicalMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){

        makeCrop((LaurelBushCrop) ModBlocks.LAUREL_BUSH_CROP.get(), "laurel_bush_stage", "laurel_bush_stage");

        makeRiceCrop(((RiceCropBlock) ModBlocks.RICE_CROP.get()), "rice_crop_stage", "rice_crop_stage");

        simpleBlockWithItem(ModBlocks.LAUREL_BUSH.get(), models().cross(blockTexture(ModBlocks.LAUREL_BUSH.get()).getPath(),
                blockTexture(ModBlocks.LAUREL_BUSH.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.RICE_BUSH.get(), models().cross(blockTexture(ModBlocks.RICE_BUSH.get()).getPath(),
                blockTexture(ModBlocks.RICE_BUSH.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.IRIS.get(), models().cross(blockTexture(ModBlocks.IRIS.get()).getPath(),
                blockTexture(ModBlocks.IRIS.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_IRIS.get(), models().singleTexture("potted_iris", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.IRIS.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.ACONITE.get(), models().cross(blockTexture(ModBlocks.ACONITE.get()).getPath(),
                blockTexture(ModBlocks.ACONITE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_ACONITE.get(), models().singleTexture("potted_aconite", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.ACONITE.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.SPIDER_LILY.get(), models().cross(blockTexture(ModBlocks.SPIDER_LILY.get()).getPath(),
                blockTexture(ModBlocks.SPIDER_LILY.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_SPIDER_LILY.get(), models().singleTexture("potted_spider_lily", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.SPIDER_LILY.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_OLIVE_SAPLING.get(), models().singleTexture("potted_olive_sapling", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.OLIVE_SAPLING.get())).renderType("cutout"));


        logBlock(((RotatedPillarBlock) ModBlocks.OLIVE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.OLIVE_WOOD.get()), blockTexture(ModBlocks.OLIVE_LOG.get()), blockTexture(ModBlocks.OLIVE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_OLIVE_LOG.get(), new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/stripped_olive_log"),
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/stripped_olive_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_OLIVE_WOOD.get(), new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/stripped_olive_log"),
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/stripped_olive_log"));

        blockItem(ModBlocks.OLIVE_LOG);
        blockItem(ModBlocks.OLIVE_WOOD);
        leavesBlock(ModBlocks.OLIVE_LEAVES);
        saplingBlock(ModBlocks.OLIVE_SAPLING);
        blockItem(ModBlocks.STRIPPED_OLIVE_LOG);
        blockItem(ModBlocks.STRIPPED_OLIVE_WOOD);
        blockWithItem(ModBlocks.OLIVE_PLANKS);
        slabBlock(((SlabBlock) ModBlocks.OLIVE_SLAB.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.OLIVE_STAIRS.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.OLIVE_BUTTON.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.OLIVE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.OLIVE_FENCE.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.OLIVE_FENCE_GATE.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.OLIVE_WALL.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.OLIVE_DOOR.get()), modLoc("block/olive_door_bottom"), modLoc("block/olive_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.OLIVE_TRAPDOOR.get(), modLoc("block/olive_trapdoor"), true, "cutout");
        blockItem(ModBlocks.OLIVE_TRAPDOOR, "_bottom");
//        signBlock(((StandingSignBlock) ModBlocks.OLIVE_SIGN.get()), ((WallSignBlock) ModBlocks.OLIVE_WALL_SIGN.get()),
//                blockTexture(ModBlocks.OLIVE_PLANKS.get()));
//
//        hangingSignBlock(ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.OLIVE_PLANKS.get()));


        blockWithItem(ModBlocks.STICK_BLOCK);
        slabBlock(((SlabBlock) ModBlocks.STICK_SLAB.get()), blockTexture(ModBlocks.STICK_BLOCK.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        stairsBlock(((StairBlock) ModBlocks.STICK_STAIRS.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.STICK_BUTTON.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.STICK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.STICK_FENCE.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.STICK_FENCE_GATE.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.STICK_WALL.get()), blockTexture(ModBlocks.STICK_BLOCK.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.STICK_DOOR.get()), modLoc("block/stick_door_bottom"), modLoc("block/stick_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.STICK_TRAPDOOR.get(), modLoc("block/stick_trapdoor"), true, "cutout");
        blockItem(ModBlocks.STICK_TRAPDOOR, "_bottom");
//        signBlock(((StandingSignBlock) ModBlocks.STICK_SIGN.get()), ((WallSignBlock) ModBlocks.STICK_WALL_SIGN.get()),
//                blockTexture(ModBlocks.STICK_BLOCK.get()));
//
//        hangingSignBlock(ModBlocks.STICK_HANGING_SIGN.get(), ModBlocks.STICK_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STICK_BLOCK.get()));



        blockWithItem(ModBlocks.ANCIENT_PORTAL);



        stairsBlock(((StairBlock) ModBlocks.CALCITE_STAIRS.get()), blockTexture(Blocks.CALCITE));
        slabBlock(((SlabBlock) ModBlocks.CALCITE_SLAB.get()), blockTexture(Blocks.CALCITE), blockTexture(Blocks.CALCITE));
        buttonBlock(((ButtonBlock) ModBlocks.CALCITE_BUTTON.get()), blockTexture(Blocks.CALCITE));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CALCITE_PRESSURE_PLATE.get()), blockTexture(Blocks.CALCITE));
        blockWithItem(ModBlocks.CALCITE_BRICKS);
        blockWithItem(ModBlocks.POLISHED_CALCITE);
        blockWithItem(ModBlocks.CHISELED_CALCITE);

//        blockItem(ModBlocks.TORII_LOG);
//        blockItem(ModBlocks.TORII_WOOD);
//        blockItem(ModBlocks.STRIPPED_TORII_LOG);
//        blockItem(ModBlocks.STRIPPED_TORII_WOOD);
        blockWithItem(ModBlocks.TORII_PLANKS);
        slabBlock(((SlabBlock) ModBlocks.TORII_SLAB.get()), blockTexture(ModBlocks.TORII_PLANKS.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.TORII_STAIRS.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.TORII_BUTTON.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.TORII_PRESSURE_PLATE.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.TORII_FENCE.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.TORII_FENCE_GATE.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.TORII_WALL.get()), blockTexture(ModBlocks.TORII_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.TORII_DOOR.get()), modLoc("block/torii_door_bottom"), modLoc("block/torii_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.TORII_TRAPDOOR.get(), modLoc("block/torii_trapdoor"), true, "cutout");
        blockItem(ModBlocks.TORII_TRAPDOOR, "_bottom");




    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    public void makeRiceCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> riceStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }


    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LaurelBushCrop) block).getAgeProperty()),
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/" + textureName + state.getValue(((LaurelBushCrop) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private ConfiguredModel[] riceStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((RiceCropBlock) block).getAgeProperty()),
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/" + textureName + state.getValue(((RiceCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("minecraftmythologicalmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("minecraftmythologicalmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

}
