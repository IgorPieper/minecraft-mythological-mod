package net.mmmteam.minecraftmythologicalmod.datagen;

import net.minecraft.advancements.AdvancementHolder;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
//        Advancement rootAdvancement = Advancement.Builder.advancement()
//                .display(new DisplayInfo(new ItemStack(ModItems.GRAPES.get()),
//                        Component.literal("Mythological"), Component.literal("Immerse yourself in the world of mythology"),
//                        new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "textures/block/polished_calcite.png"), FrameType.TASK,
//                        true, true, false))
//                .addCriterion("has_grapes", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GRAPES.get()))
//                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "grapes")).value();
//
//        Advancement findOliveTree = Advancement.Builder.advancement()
//                .display(new DisplayInfo(new ItemStack(ModBlocks.OLIVE_SAPLING.get()),
//                        Component.literal("Find Olive Tree"), Component.literal("Search for her in the mountain biomes"),
//                        null, FrameType.TASK,
//                        true, true, false))
//                .addCriterion("has_olive_tree", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.OLIVE_SAPLING.get()))
//                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "olive_tree")).value();



    }
}
