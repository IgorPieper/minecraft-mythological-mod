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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ladny_patyk.get()))
                    .title(Component.translatable("creativetab.mythological"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.ladny_patyk.get());
                        pOutput.accept(ModItems.BAY_LEAF.get());

                        pOutput.accept(ModItems.GRAPES.get());

                        pOutput.accept(ModBlocks.STICK_BLOCK.get());

                        pOutput.accept(ModItems.EXCALIBUR.get());

                        pOutput.accept(ModBlocks.IRIS.get());

                        pOutput.accept(ModBlocks.ACONITE.get());

                        pOutput.accept(ModBlocks.OLIVE_LOG.get());
                        pOutput.accept(ModBlocks.OLIVE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_OLIVE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_OLIVE_WOOD.get());
                        pOutput.accept(ModBlocks.OLIVE_PLANKS.get());
                        pOutput.accept(ModBlocks.OLIVE_SAPLING.get());
                        pOutput.accept(ModBlocks.OLIVE_LEAVES.get());

                        pOutput.accept(ModItems.PYXIS.get());
                        pOutput.accept(ModItems.IRIS_PYXIS.get());

                        pOutput.accept(ModBlocks.ANCIENT_PORTAL.get());

                        pOutput.accept(ModItems.CYCLOPS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.RACOON_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BALKANLYNX_SPAWN_EGG.get());

                        pOutput.accept(ModItems.HADES_TRIDENT.get());

                        pOutput.accept(ModItems.POSEIDONS_TRIDENT.get());

                        pOutput.accept(ModItems.APOLLO_BOW.get());

                        pOutput.accept(ModItems.MINOTAUR_AXE.get());

                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
