package net.mmmteam.minecraftmythologicalmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftMythologicalMod.MOD_ID);

    // Przykład dodania nowego itemka, na tym etapie tylko teoretycznie
    public static final RegistryObject<Item> ladny_patyk = ITEMS.register("ladny_patyk",
            () -> new Item(new Item.Properties()));

    // Prosty miecz
    // pTier: tier przedmiotu zdefinioway w ModItemsTier
    // pAttackDamageModifier: DODATKOWA wartość ataku do tej bazowej ustawionej w tierze
    // pAttackSpeedModifier: DODATKOWA wartość szybkości ataku do tej bazowej ustawionej w tierze
    public static final RegistryObject<SwordItem> excalibur = ITEMS.register("excalibur",
            () -> new SwordItem(ModItemTier.SWORD, 9, -3f, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
