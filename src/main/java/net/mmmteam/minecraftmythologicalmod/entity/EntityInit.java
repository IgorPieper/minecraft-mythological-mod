package net.mmmteam.minecraftmythologicalmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.RacoonEntity;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MinecraftMythologicalMod.MOD_ID);

    //dodawanie moba do gry -> na razie tylko przykładowy szop
    //sized = metoda definiująca wielkość obszaru kolizji moba
    public static final RegistryObject<EntityType<RacoonEntity>> RACOON =
            ENTITY_TYPES.register("racoon", () -> EntityType.Builder.of(RacoonEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("racoon"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
