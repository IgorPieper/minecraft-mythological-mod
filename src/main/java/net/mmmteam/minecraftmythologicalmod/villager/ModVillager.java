package net.mmmteam.minecraftmythologicalmod.villager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;

public class ModVillager {
    public class ModVillagers {
        public static final DeferredRegister<PoiType> POI_TYPES =
                DeferredRegister.create(ForgeRegistries.POI_TYPES, MinecraftMythologicalMod.MOD_ID);
        public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
                DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MinecraftMythologicalMod.MOD_ID);

        public static final RegistryObject<PoiType> GOD_POI = POI_TYPES.register("god_poi",
                () -> new PoiType(ImmutableSet.copyOf(Blocks.CAMPFIRE.getStateDefinition().getPossibleStates()),
                        1, 1));

        public static final RegistryObject<VillagerProfession> GODS_SMITH =
                VILLAGER_PROFESSIONS.register("gods_smith", () -> new VillagerProfession("gods_smith",
                        x -> x.get() == GOD_POI.get(), x -> x.get() == GOD_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                        SoundEvents.VILLAGER_WORK_TOOLSMITH));

        public static final RegistryObject<PoiType> JAP_POI = POI_TYPES.register("jap_poi",
                () -> new PoiType(ImmutableSet.copyOf(Blocks.CAKE.getStateDefinition().getPossibleStates()),
                        1, 1));

        public static final RegistryObject<VillagerProfession> JAP_SMITH =
                VILLAGER_PROFESSIONS.register("jap_smith", () -> new VillagerProfession("jap_smith",
                        x -> x.get() == JAP_POI.get(), x -> x.get() == JAP_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                        SoundEvents.VILLAGER_WORK_TOOLSMITH));



        public static void register(IEventBus eventBus) {
            POI_TYPES.register(eventBus);
            VILLAGER_PROFESSIONS.register(eventBus);
        }
    }
}
