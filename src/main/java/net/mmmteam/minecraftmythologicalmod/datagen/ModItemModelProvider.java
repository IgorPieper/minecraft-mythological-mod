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
        simpleBlockItemBlockTexture(ModBlocks.LAUREL_BUSH);
        simpleItem(ModItems.GRAPES);
        simpleBlockItemBlockTexture(ModBlocks.IRIS);
        simpleBlockItemBlockTexture(ModBlocks.ACONITE);
        simpleBlockItemBlockTexture(ModBlocks.SPIDER_LILY);

        saplingItem(ModBlocks.OLIVE_SAPLING);

        simpleItem(ModItems.PYXIS);
        simpleItem(ModItems.IRIS_PYXIS);

        withExistingParent(ModItems.CYCLOPS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.RACOON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BALKANLYNX_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MINOTAUR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.KITSUNE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        //simpleBlockItemBlockTexture(ModBlocks.ANCIENT_PORTAL);

        simpleItem(ModItems.AMBROSIA);
        simpleItem(ModItems.ACONITE_ROOT);

        evenSimplerBlockItem(ModBlocks.STICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.CALCITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.OLIVE_STAIRS);

        evenSimplerBlockItem(ModBlocks.STICK_SLAB);
        evenSimplerBlockItem(ModBlocks.OLIVE_SLAB);
        evenSimplerBlockItem(ModBlocks.CALCITE_SLAB);

        simpleBlockItem(ModBlocks.OLIVE_DOOR);
        fenceItem(ModBlocks.OLIVE_FENCE, ModBlocks.OLIVE_PLANKS);
        buttonItem(ModBlocks.OLIVE_BUTTON, ModBlocks.OLIVE_PLANKS);
        wallItem(ModBlocks.OLIVE_WALL, ModBlocks.OLIVE_PLANKS);
        evenSimplerBlockItem(ModBlocks.OLIVE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.OLIVE_FENCE_GATE);
        simpleItem(ModItems.OLIVE_BOAT);
        simpleItem(ModItems.OLIVE_CHEST_BOAT);



        simpleItem(ModItems.GIFT_OF_APOLLO);
        simpleItem(ModItems.GIFT_OF_ATHENA);
        simpleItem(ModItems.GIFT_OF_HADES);
        simpleItem(ModItems.GIFT_OF_HEPHAESTUS);
        simpleItem(ModItems.GIFT_OF_POSEIDON);

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

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
