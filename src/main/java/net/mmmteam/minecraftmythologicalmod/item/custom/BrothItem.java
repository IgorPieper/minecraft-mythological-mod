package net.mmmteam.minecraftmythologicalmod.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
;
import java.util.ArrayList;

public class BrothItem extends Item {
    public BrothItem(Properties pProperties) {
        super(pProperties.food(new FoodProperties.Builder()
                .nutrition(8)
                .saturationMod(1.2f)
                .build()));
    }

    @NotNull
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        for (MobEffectInstance effectToRemove : new ArrayList<>(pEntityLiving.getActiveEffects())) {
//            if (!effectToRemove.getEffect().isBeneficial()) {  // Usuwanie tylko złych efekty
            pEntityLiving.removeEffect(effectToRemove.getEffect());
//        }
            }
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
            pStack.shrink(1);
        }
        return pStack.isEmpty() ? new ItemStack(Items.BOWL) : pStack;
    }


    public int getUseDuration(ItemStack pStack) {
        return 32;
    }


    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @org.jetbrains.annotations.Nullable net.minecraft.nbt.CompoundTag nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }
}