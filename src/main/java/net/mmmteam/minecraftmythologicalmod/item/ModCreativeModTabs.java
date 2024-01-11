package net.mmmteam.minecraftmythologicalmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MYTHOLOGICAL = CREATIVE_MODE_TABS.register("mythological",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GRAPES.get()))
                    .title(Component.translatable("creativetab.mythological"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.OLIVE_LOG.get());
                        pOutput.accept(ModBlocks.OLIVE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_OLIVE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_OLIVE_WOOD.get());
                        pOutput.accept(ModBlocks.OLIVE_PLANKS.get());
                        pOutput.accept(ModBlocks.OLIVE_STAIRS.get());
                        pOutput.accept(ModBlocks.OLIVE_SLAB.get());
                        pOutput.accept(ModBlocks.OLIVE_BUTTON.get());
                        pOutput.accept(ModBlocks.OLIVE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.OLIVE_FENCE.get());
                        pOutput.accept(ModBlocks.OLIVE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.OLIVE_DOOR.get());
                        pOutput.accept(ModBlocks.OLIVE_TRAPDOOR.get());
                        pOutput.accept(ModItems.OLIVE_BOAT.get());
                        pOutput.accept(ModItems.OLIVE_CHEST_BOAT.get());

                        pOutput.accept(ModBlocks.STICK_BLOCK.get());
                        pOutput.accept(ModBlocks.STICK_STAIRS.get());
                        pOutput.accept(ModBlocks.STICK_SLAB.get());

                        pOutput.accept(ModBlocks.ANCIENT_PORTAL.get());

                        pOutput.accept(ModBlocks.CALCITE_STAIRS.get());
                        pOutput.accept(ModBlocks.CALCITE_SLAB.get());

                        pOutput.accept(ModBlocks.OLIVE_LEAVES.get());
                        pOutput.accept(ModBlocks.OLIVE_SAPLING.get());
                        pOutput.accept(ModBlocks.LAUREL_BUSH.get());
                        pOutput.accept(ModBlocks.IRIS.get());
                        pOutput.accept(ModBlocks.ACONITE.get());
                        pOutput.accept(ModBlocks.SPIDER_LILY.get());

                        pOutput.accept(ModItems.BAY_LEAF.get());
                        pOutput.accept(ModItems.GRAPES.get());

                        pOutput.accept(ModItems.AMBROSIA.get());
                        pOutput.accept(ModItems.ACONITE_ROOT.get());
                        pOutput.accept(ModItems.ONIGIRI.get());
                        pOutput.accept(ModItems.DANGO.get());
                        pOutput.accept(ModItems.MOCHI.get());

                        pOutput.accept(ModItems.GIFT_OF_APOLLO.get());
                        pOutput.accept(ModItems.GIFT_OF_ATHENA.get());
                        pOutput.accept(ModItems.GIFT_OF_HADES.get());
                        pOutput.accept(ModItems.GIFT_OF_HEPHAESTUS.get());
                        pOutput.accept(ModItems.GIFT_OF_POSEIDON.get());

                        pOutput.accept(ModItems.PYXIS.get());
                        pOutput.accept(ModItems.IRIS_PYXIS.get());

                        pOutput.accept(ModItems.EXCALIBUR.get());
                        pOutput.accept(ModItems.HADES_TRIDENT.get());
                        pOutput.accept(ModItems.POSEIDONS_TRIDENT.get());
                        pOutput.accept(ModItems.APOLLO_BOW.get());
                        pOutput.accept(ModItems.MINOTAUR_AXE.get());
                        pOutput.accept(ModItems.SPEAR_OF_ATHENA.get());
                        pOutput.accept(ModItems.SWORD_OF_PELEUS.get());
                        pOutput.accept(ModItems.SPARTAN_SHIELD.get());

                        pOutput.accept(ModItems.CYCLOPS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.RACOON_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BALKANLYNX_SPAWN_EGG.get());
                        pOutput.accept(ModItems.MINOTAUR_SPAWN_EGG.get());
                        pOutput.accept(ModItems.KITSUNE_SPAWN_EGG.get());

                        pOutput.accept(ModItems.HADES_WATER_BUCKET.get());
                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
