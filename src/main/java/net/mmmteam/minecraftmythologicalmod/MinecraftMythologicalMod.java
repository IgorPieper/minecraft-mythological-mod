package net.mmmteam.minecraftmythologicalmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
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
import net.mmmteam.minecraftmythologicalmod.block.entity.ModBlockEntities;
import net.mmmteam.minecraftmythologicalmod.entity.ModEntities;
import net.mmmteam.minecraftmythologicalmod.entity.client.*;
import net.mmmteam.minecraftmythologicalmod.fluid.ModFluidTypes;
import net.mmmteam.minecraftmythologicalmod.fluid.ModFluids;
import net.mmmteam.minecraftmythologicalmod.item.ModCreativeModTabs;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.mmmteam.minecraftmythologicalmod.loot.ModLootModifiers;
import net.mmmteam.minecraftmythologicalmod.item.ModItemProperties;
import net.mmmteam.minecraftmythologicalmod.potion.BrewingRecipe;
import net.mmmteam.minecraftmythologicalmod.villager.ModVillager;
import net.mmmteam.minecraftmythologicalmod.worldgen.tree.ModTrunkPlacerTypes;
import net.mmmteam.minecraftmythologicalmod.util.ModWoodTypes;
import org.slf4j.Logger;

@Mod(MinecraftMythologicalMod.MOD_ID)
public class MinecraftMythologicalMod
{
    public static final String MOD_ID = "minecraftmythologicalmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MinecraftMythologicalMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        ModVillager.ModVillagers.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModTrunkPlacerTypes.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.IRIS.getId(), ModBlocks.POTTED_IRIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ACONITE.getId(), ModBlocks.POTTED_ACONITE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SPIDER_LILY.getId(), ModBlocks.POTTED_SPIDER_LILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.OLIVE_SAPLING.getId(), ModBlocks.POTTED_OLIVE_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TORII_SAPLING.getId(), ModBlocks.POTTED_TORII_SAPLING);
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
            event.enqueueWork(() -> {
                Sheets.addWoodType(ModWoodTypes.OLIVE);
                Sheets.addWoodType(ModWoodTypes.STICK);
                Sheets.addWoodType(ModWoodTypes.TORII);

                EntityRenderers.register(ModEntities.RACOON.get(), RacoonRenderer::new);
                EntityRenderers.register(ModEntities.CYCLOPS.get(), CyclopsRenderer::new);
                EntityRenderers.register(ModEntities.BALKANLYNX.get(), BalkanLynxRenderer::new);
                EntityRenderers.register(ModEntities.MINOTAUR.get(), MinotaurRenderer::new);
                EntityRenderers.register(ModEntities.KITSUNE.get(), KitsuneRenderer::new);
                EntityRenderers.register(ModEntities.ONI.get(), OniRenderer::new);
                EntityRenderers.register(ModEntities.KOI_FISH.get(), KoiFishRenderer::new);
                EntityRenderers.register(ModEntities.SIKADEER.get(), SikaDeerRenderer::new);
                EntityRenderers.register(ModEntities.RISSOSDOLPHIN.get(), RissosDolphinRenderer::new);
                EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
                Sheets.addWoodType(ModWoodTypes.OLIVE);

                ModItemProperties.addCustomItemProperties();

                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_HADES_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_HADES_WATER.get(), RenderType.translucent());

                ComposterBlock.COMPOSTABLES.put(ModBlocks.OLIVE_SAPLING.get(), 0.3f);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.TORII_SAPLING.get(), 0.3f);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.OLIVE_LEAVES.get(), 0.3f);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.TORII_LEAVES.get(), 0.3f);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.IRIS.get(), 0.65f);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.ACONITE.get(), 0.65f);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.SPIDER_LILY.get(), 0.65f);
                ComposterBlock.COMPOSTABLES.put(ModItems.BAY_LEAF.get(), 0.3f);
                ComposterBlock.COMPOSTABLES.put(ModItems.GRAPES.get(), 1f);
                ComposterBlock.COMPOSTABLES.put(ModItems.RICE_SEEDS.get(), 0.3f);
                ComposterBlock.COMPOSTABLES.put(ModItems.ACONITE_ROOT.get(), 0.85f);

                BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Potions.WATER, ModItems.ACONITE_ROOT.get(), Potions.STRONG_POISON));
            });
        }
    }
}
