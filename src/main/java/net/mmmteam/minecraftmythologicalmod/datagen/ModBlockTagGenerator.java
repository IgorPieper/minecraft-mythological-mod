package net.mmmteam.minecraftmythologicalmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MinecraftMythologicalMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.OLIVE_LOG.get())
                .add(ModBlocks.OLIVE_WOOD.get())
                .add(ModBlocks.STRIPPED_OLIVE_LOG.get())
                .add(ModBlocks.STRIPPED_OLIVE_WOOD.get())
                .add(ModBlocks.TORII_LOG.get())
                .add(ModBlocks.TORII_WOOD.get())
                .add(ModBlocks.STRIPPED_TORII_LOG.get())
                .add(ModBlocks.STRIPPED_TORII_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.OLIVE_PLANKS.get())
                .add(ModBlocks.TORII_PLANKS.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CALCITE_STAIRS.get(),
                        ModBlocks.CALCITE_SLAB.get(),
                        ModBlocks.CALCITE_BRICKS.get(),
                        ModBlocks.POLISHED_CALCITE.get(),
                        ModBlocks.CHISELED_CALCITE.get(),
                        ModBlocks.CALCITE_BUTTON.get(),
                        ModBlocks.CALCITE_PRESSURE_PLATE.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.OLIVE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.OLIVE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.OLIVE_WALL.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.STICK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.STICK_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.STICK_WALL.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.TORII_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.TORII_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.TORII_WALL.get());

    }



    @Override
    public String getName() {
        return "Block Tags";
    }
}
