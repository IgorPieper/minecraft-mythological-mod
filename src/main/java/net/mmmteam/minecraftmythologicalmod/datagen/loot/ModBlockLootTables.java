package net.mmmteam.minecraftmythologicalmod.datagen.loot;
import net.mmmteam.minecraftmythologicalmod.block.custom.LaurelBushCrop;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.STICK_BLOCK.get());

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LAUREL_BUSH_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LaurelBushCrop.AGE, 4));
        this.add(ModBlocks.LAUREL_BUSH_CROP.get(), this.createCropDrops(ModBlocks.LAUREL_BUSH_CROP.get(), ModItems.BAY_LEAF.get(),
                ModItems.BAY_LEAF.get(), lootitemcondition$builder1));

        this.dropSelf(ModBlocks.IRIS.get());
        this.add(ModBlocks.POTTED_IRIS.get(), createPotFlowerItemTable(ModBlocks.IRIS.get()));
        this.dropSelf(ModBlocks.ACONITE.get());
        this.add(ModBlocks.POTTED_ACONITE.get(), createPotFlowerItemTable(ModBlocks.ACONITE.get()));

        this.dropSelf(ModBlocks.OLIVE_LOG.get());
        this.dropSelf(ModBlocks.OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.OLIVE_PLANKS.get());
        this.dropSelf(ModBlocks.OLIVE_SAPLING.get());

        this.add(ModBlocks.OLIVE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.OLIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.STICK_STAIRS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
