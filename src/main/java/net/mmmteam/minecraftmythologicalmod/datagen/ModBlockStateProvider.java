package net.mmmteam.minecraftmythologicalmod.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.block.custom.LaurelBushCrop;

import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MinecraftMythologicalMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(ModBlocks.STICK_BLOCK);

        makeCrop((LaurelBushCrop) ModBlocks.LAUREL_BUSH_CROP.get(), "laurel_bush_stage", "laurel_bush_stage");

        simpleBlockWithItem(ModBlocks.IRIS.get(), models().cross(blockTexture(ModBlocks.IRIS.get()).getPath(),
                blockTexture(ModBlocks.IRIS.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_IRIS.get(), models().singleTexture("potted_iris", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.IRIS.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.ACONITE.get(), models().cross(blockTexture(ModBlocks.ACONITE.get()).getPath(),
                blockTexture(ModBlocks.ACONITE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_ACONITE.get(), models().singleTexture("potted_aconite", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.ACONITE.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LaurelBushCrop) block).getAgeProperty()),
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/" + textureName + state.getValue(((LaurelBushCrop) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
