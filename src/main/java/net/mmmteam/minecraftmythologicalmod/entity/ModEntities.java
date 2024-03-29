package net.mmmteam.minecraftmythologicalmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.entity.custom.*;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<EntityType<RacoonEntity>> RACOON =
            ENTITY_TYPES.register("racoon", () -> EntityType.Builder.of(RacoonEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("racoon"));

    public static final RegistryObject<EntityType<CyclopsEntity>> CYCLOPS =
            ENTITY_TYPES.register("cyclops", () -> EntityType.Builder.of(CyclopsEntity::new, MobCategory.MONSTER)
                    .sized(2.5f, 2f).build("cyclops"));

    public static final RegistryObject<EntityType<BalkanLynxEntity>> BALKANLYNX =
            ENTITY_TYPES.register("balkanlynx", () -> EntityType.Builder.of(BalkanLynxEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("balkanlynx"));

    public static final RegistryObject<EntityType<MinotaurEntity>> MINOTAUR =
            ENTITY_TYPES.register("minotaur", () -> EntityType.Builder.of(MinotaurEntity::new, MobCategory.MONSTER)
                    .sized(2f, 3f).build("minotaur"));

    public static final RegistryObject<EntityType<KitsuneEntity>> KITSUNE =
            ENTITY_TYPES.register("kitsune", () -> EntityType.Builder.of(KitsuneEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("kitsune"));

    public static final RegistryObject<EntityType<OniEntity>> ONI =
            ENTITY_TYPES.register("oni", () -> EntityType.Builder.of(OniEntity::new, MobCategory.MONSTER)
                    .sized(1.5f, 2f).build("oni"));

    public static final RegistryObject<EntityType<KoiFishEntity>> KOI_FISH =
            ENTITY_TYPES.register("koi_fish", () -> EntityType.Builder.of(KoiFishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7f, 0.4f).build("koi_fish"));

    public static final RegistryObject<EntityType<SikaDeerEntity>> SIKADEER =
            ENTITY_TYPES.register("sikadeer", () -> EntityType.Builder.of(SikaDeerEntity::new, MobCategory.CREATURE)
                    .sized(1.7f, 2f).build("sikadeer"));

    public static final RegistryObject<EntityType<RissosDolphinEntity>> RISSOSDOLPHIN =
            ENTITY_TYPES.register("rissosdolphin", () -> EntityType.Builder.of(RissosDolphinEntity::new, MobCategory.WATER_CREATURE)
                    .sized(1f, 1f).build("rissosdolphin"));

    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
