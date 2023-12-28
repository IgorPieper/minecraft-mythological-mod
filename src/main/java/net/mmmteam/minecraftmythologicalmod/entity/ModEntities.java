package net.mmmteam.minecraftmythologicalmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.CyclopsEntity;
import net.mmmteam.minecraftmythologicalmod.entity.custom.RacoonEntity;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<EntityType<RacoonEntity>> RACOON =
            ENTITY_TYPES.register("racoon", () -> EntityType.Builder.of(RacoonEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("racoon"));

    public static final RegistryObject<EntityType<CyclopsEntity>> CYCLOPS =
            ENTITY_TYPES.register("cyclops", () -> EntityType.Builder.of(CyclopsEntity::new, MobCategory.CREATURE)
                    .sized(2f, 2f).build("cyclops"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
