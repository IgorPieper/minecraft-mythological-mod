package net.mmmteam.minecraftmythologicalmod.datagen.loot;
import net.minecraft.world.level.storage.loot.LootTable;
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
import java.util.function.Function;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LAUREL_BUSH_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LaurelBushCrop.AGE, 4));
        this.add(ModBlocks.LAUREL_BUSH_CROP.get(), this.createCropDrops(ModBlocks.LAUREL_BUSH_CROP.get(), ModItems.BAY_LEAF.get(),
                ModItems.BAY_LEAF.get(), lootitemcondition$builder1));

        this.add(ModBlocks.LAUREL_BUSH.get(),
                block -> createOreDrop(ModBlocks.LAUREL_BUSH.get(), ModItems.BAY_LEAF.get()));

        this.dropSelf(ModBlocks.IRIS.get());
        this.add(ModBlocks.POTTED_IRIS.get(), createPotFlowerItemTable(ModBlocks.IRIS.get()));
        this.dropSelf(ModBlocks.ACONITE.get());
        this.add(ModBlocks.POTTED_ACONITE.get(), createPotFlowerItemTable(ModBlocks.ACONITE.get()));
        this.dropSelf(ModBlocks.SPIDER_LILY.get());
        this.add(ModBlocks.POTTED_SPIDER_LILY.get(), createPotFlowerItemTable(ModBlocks.SPIDER_LILY.get()));

        this.dropSelf(ModBlocks.OLIVE_LOG.get());
        this.dropSelf(ModBlocks.OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.OLIVE_PLANKS.get());
        this.dropSelf(ModBlocks.OLIVE_SAPLING.get());
        this.add(ModBlocks.POTTED_OLIVE_SAPLING.get(),
                createPotFlowerItemTable(ModBlocks.OLIVE_SAPLING.get()));

        this.add(ModBlocks.OLIVE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.OLIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.OLIVE_STAIRS.get());
        this.dropSelf(ModBlocks.OLIVE_BUTTON.get());
        this.dropSelf(ModBlocks.OLIVE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.OLIVE_WALL.get());
        this.dropSelf(ModBlocks.OLIVE_TRAPDOOR.get());
        this.add(ModBlocks.OLIVE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_SLAB.get()));
        this.add(ModBlocks.OLIVE_DOOR.get(),
                block -> createDoorTable(ModBlocks.OLIVE_DOOR.get()));
//        this.add(ModBlocks.OLIVE_SIGN.get(), block ->
//                createSingleItemTable(ModItems.OLIVE_SIGN.get()));
//        this.add(ModBlocks.OLIVE_WALL_SIGN.get(), block ->
//                createSingleItemTable(ModItems.OLIVE_SIGN.get()));
//        this.add(ModBlocks.OLIVE_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.OLIVE_HANGING_SIGN.get()));
//        this.add(ModBlocks.OLIVE_WALL_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.OLIVE_HANGING_SIGN.get()));


        this.dropSelf(ModBlocks.CALCITE_BRICKS.get());
        this.dropSelf(ModBlocks.POLISHED_CALCITE.get());
        this.dropSelf(ModBlocks.CHISELED_CALCITE.get());
        this.dropSelf(ModBlocks.CALCITE_STAIRS.get());
        this.add(ModBlocks.CALCITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CALCITE_SLAB.get()));
        this.dropSelf(ModBlocks.CALCITE_BUTTON.get());
        this.dropSelf(ModBlocks.CALCITE_PRESSURE_PLATE.get());


        this.dropSelf(ModBlocks.STICK_BLOCK.get());
        this.dropSelf(ModBlocks.STICK_STAIRS.get());
        this.dropSelf(ModBlocks.STICK_BUTTON.get());
        this.dropSelf(ModBlocks.STICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.STICK_FENCE.get());
        this.dropSelf(ModBlocks.STICK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STICK_WALL.get());
        this.dropSelf(ModBlocks.STICK_TRAPDOOR.get());
        this.add(ModBlocks.STICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STICK_SLAB.get()));
        this.add(ModBlocks.STICK_DOOR.get(),
                block -> createDoorTable(ModBlocks.STICK_DOOR.get()));
//        this.add(ModBlocks.STICK_SIGN.get(), block ->
//                createSingleItemTable(ModItems.STICK_SIGN.get()));
//        this.add(ModBlocks.STICK_WALL_SIGN.get(), block ->
//                createSingleItemTable(ModItems.STICK_SIGN.get()));
//        this.add(ModBlocks.STICK_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.STICK_HANGING_SIGN.get()));
//        this.add(ModBlocks.STICK_WALL_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.STICK_HANGING_SIGN.get()));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
