package net.mmmteam.minecraftmythologicalmod.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.mmmteam.minecraftmythologicalmod.entity.ai.AnimalAISwimBottom;

public class RissosDolphinEntity extends AbstractSchoolingFish{

    public RissosDolphinEntity(EntityType<? extends RissosDolphinEntity> p_29790_, Level p_29791_) {
        super(p_29790_, p_29791_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1));
        this.goalSelector.addGoal(3, new AnimalAISwimBottom(this, 1F, 7));
    }

    public int getMaxSchoolSize() {
        return 5;
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(Items.SALMON_BUCKET);
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

