package net.mmmteam.minecraftmythologicalmod.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_HADES_WATER = FLUIDS.register("hades_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HADES_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HADES_WATER = FLUIDS.register("flowing_hades_water_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HADES_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties HADES_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.HADES_WATER_FLUID_TYPE, SOURCE_HADES_WATER, FLOWING_HADES_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.HADES_WATER_BLOCK)
            .bucket(ModItems.HADES_WATER_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
