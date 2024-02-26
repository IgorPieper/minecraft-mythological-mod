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

    public static final FoodProperties ONIGIRI = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f)
            .build();

    public static final FoodProperties DANGO = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f)
            .build();

    public static final FoodProperties MOCHI = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f)
            .build();

    public static final FoodProperties SUSHI = new FoodProperties.Builder().nutrition(5)
            .saturationMod(1.6f)
            .build();

    public static final FoodProperties BOWL_OF_RICE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(1.2f)
            .build();

//    public static final FoodProperties BROTH = new FoodProperties.Builder().nutrition(8)
 //           .saturationMod(1.2f)
  //          .build();

    public static final FoodProperties GRAPE_JUICE = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 2000), 0.5f)
            .build();

    public static final FoodProperties RAW_KOI = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f)
            .build();
    public static final FoodProperties COOKED_KOI = new FoodProperties.Builder().nutrition(6)
            .saturationMod(1.6f)
            .build();
}
