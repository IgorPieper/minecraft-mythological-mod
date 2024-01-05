package net.mmmteam.minecraftmythologicalmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;

public class ModTags {

    public static class Items{

        public static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MinecraftMythologicalMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks{

        // Przykładowy customowy tag dla bloków
        // public static final TagKey<Block> nazwa = tag("nazwa");

        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MinecraftMythologicalMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }

}
