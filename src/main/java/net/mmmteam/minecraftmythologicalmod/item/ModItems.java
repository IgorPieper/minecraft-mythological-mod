package net.mmmteam.minecraftmythologicalmod.item;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.entity.ModEntities;
import net.mmmteam.minecraftmythologicalmod.item.custom.ImmobilizingSwordItem;
import net.mmmteam.minecraftmythologicalmod.item.custom.ObscuringSwordItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<Item> ladny_patyk = ITEMS.register("ladny_patyk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes",
            () -> new Item(new Item.Properties().food(ModFoods.GRAPES)));

    public static final RegistryObject<SwordItem> EXCALIBUR = ITEMS.register("excalibur",
            () -> new SwordItem(ModItemTier.SWORD, 9, -3f, new Item.Properties()));

    public static final RegistryObject<Item> BAY_LEAF = ITEMS.register("bay_leaf",
            () -> new ItemNameBlockItem(ModBlocks.LAUREL_BUSH_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> PYXIS = ITEMS.register("pyxis",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRIS_PYXIS = ITEMS.register("iris_pyxis",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CYCLOPS_SPAWN_EGG = ITEMS.register("cyclops_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CYCLOPS, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static final RegistryObject<Item> RACOON_SPAWN_EGG = ITEMS.register("racoon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RACOON, 0x7d6057, 0x000000,
                    new Item.Properties()));

    public static final RegistryObject<Item> BALKANLYNX_SPAWN_EGG = ITEMS.register("balkanlynx_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BALKANLYNX, 0xffffff, 0x000000,
                    new Item.Properties()));

    public static final RegistryObject<Item> HADES_TRIDENT = ITEMS.register("hades_trident",
            () -> new ObscuringSwordItem(ModItemTier.SWORD, 9, -3f, new Item.Properties()));

    public static final RegistryObject<Item> POSEIDONS_TRIDENT = ITEMS.register("poseidons_trident",
            () -> new ImmobilizingSwordItem(ModItemTier.SWORD, 9, -3f, new Item.Properties()));

    public static final RegistryObject<Item> APOLLO_BOW = ITEMS.register("apollo_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> MINOTAUR_AXE = ITEMS.register("minotaur_axe",
            () -> new ImmobilizingSwordItem(ModItemTier.SWORD, 7, -3f, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
