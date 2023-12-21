package net.mmmteam.minecraftmythologicalmod.datagen.loot;
import net.minecraft.world.level.storage.loot.LootTable;
import net.mmmteam.minecraftmythologicalmod.block.custom.LaurelBushCrop;
import net.mmmteam.minecraftmythologicalmod.item.Moditems;
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
        this.add(ModBlocks.LAUREL_BUSH_CROP.get(), this.createCropDrops(ModBlocks.LAUREL_BUSH_CROP.get(), Moditems.BAY_LEAF.get(),
                Moditems.BAY_LEAF.get(), lootitemcondition$builder1));

        this.dropSelf(ModBlocks.IRIS.get());
        this.add(ModBlocks.POTTED_IRIS.get(), createPotFlowerItemTable(ModBlocks.IRIS.get()));
        this.dropSelf(ModBlocks.ACONITE.get());
        this.add(ModBlocks.POTTED_ACONITE.get(), createPotFlowerItemTable(ModBlocks.ACONITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
