package net.mmmteam.minecraftmythologicalmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.entity.EntityInit;
import net.mmmteam.minecraftmythologicalmod.entity.client.RacoonRenderer;
import net.mmmteam.minecraftmythologicalmod.item.ModCreativeModTabs;
import net.mmmteam.minecraftmythologicalmod.item.Moditems;
import org.slf4j.Logger;

@Mod(MinecraftMythologicalMod.MOD_ID)
public class MinecraftMythologicalMod
{
    // Nadajemy id dla naszej modyfikacji
    public static final String MOD_ID = "minecraftmythologicalmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MinecraftMythologicalMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);
        EntityInit.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        // Dzięki temu przedmioty z pliku item/Moditems działają
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.IRIS.getId(), ModBlocks.POTTED_IRIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ACONITE.getId(), ModBlocks.POTTED_ACONITE);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //dodawanie moba do gry
            //żeby mob pojawił się w grze wpisujemy "/summon minecraftmythologicalmod:racoon"
            EntityRenderers.register(EntityInit.RACOON.get(), RacoonRenderer::new);
        }
    }
}
