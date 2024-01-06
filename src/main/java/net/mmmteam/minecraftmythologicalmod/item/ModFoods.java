package net.mmmteam.minecraftmythologicalmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GRAPES = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.1f)
            .build();

    public static final FoodProperties AMBROSIA = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 100), 1f)
            .build();

    public static final FoodProperties ACONITE_ROOT = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 1f)
            .build();



}
