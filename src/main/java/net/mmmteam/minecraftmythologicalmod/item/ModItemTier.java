package net.mmmteam.minecraftmythologicalmod.item;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {

    // Tutaj definiujemy tier
    // level: mining level (0 (drewno) - 4 (netherrite)), czyli jakie bloki może zniszczyć i zebrać item (np. drewniany kilof nie może zbierać żelaza, ale kamienny kilof już tak)
    // durability: wytrzymałość przedmiotu
    // mining speed: szybkość kopania/zadawania obrażeń
    // damage: ile zadaje obrażeń
    // enchantability: ile razy może być enchantowany (max 5 ??)
    // repair ingredient: czym możemy go naprawić w kowadle

    SWORD(1, 3000, 10.0F, 10.0F, 5, () -> {
        return Ingredient.of(Items.GOLDEN_SWORD);
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModItemTier(int level, int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = durability;
        this.speed = miningSpeed;
        this.damage = damage;
        this.enchantmentValue = enchantability;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}