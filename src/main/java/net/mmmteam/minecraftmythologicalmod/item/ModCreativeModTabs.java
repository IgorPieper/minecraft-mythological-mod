package net.mmmteam.minecraftmythologicalmod.item;

import jdk.jfr.Registered;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MYTHOLOGICAL = CREATIVE_MODE_TABS.register("mythological",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.ladny_patyk.get()))
                    .title(Component.translatable("creativetab.mythological"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.ladny_patyk.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
