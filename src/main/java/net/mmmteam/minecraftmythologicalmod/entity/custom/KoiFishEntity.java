package net.mmmteam.minecraftmythologicalmod.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;

public class KoiFishEntity extends AbstractSchoolingFish {
    public KoiFishEntity(EntityType<? extends KoiFishEntity> p_27523_, Level p_27524_) {
        super(p_27523_, p_27524_);
    }

    public int getMaxSchoolSize() {
        return 5;
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.KOI_FISH_BUCKET.get());
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SALMON_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SALMON_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_29795_) {
        return SoundEvents.SALMON_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }
}