package net.mmmteam.minecraftmythologicalmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MinecraftMythologicalMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GOOD_LOOKING_STICK);
        simpleItem(ModItems.BAY_LEAF);
        simpleItem(ModItems.GRAPES);
        simpleBlockItemBlockTexture(ModBlocks.IRIS);
        simpleBlockItemBlockTexture(ModBlocks.ACONITE);

        saplingItem(ModBlocks.OLIVE_SAPLING);

        simpleItem(ModItems.PYXIS);
        simpleItem(ModItems.IRIS_PYXIS);

        withExistingParent(ModItems.CYCLOPS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.RACOON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BALKANLYNX_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MINOTAUR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        //simpleBlockItemBlockTexture(ModBlocks.ANCIENT_PORTAL);

        simpleItem(ModItems.AMBROSIA);
        simpleItem(ModItems.ACONITE_ROOT);

        evenSimplerBlockItem(ModBlocks.STICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.CALCITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.STICK_SLAB);
        evenSimplerBlockItem(ModBlocks.CALCITE_SLAB);



    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath())));
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MinecraftMythologicalMod.MOD_ID,"block/" + item.getId().getPath()));
    }
}
