package net.mmmteam.minecraftmythologicalmod.entity.custom;

import net.mmmteam.minecraftmythologicalmod.entity.ModEntities;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ModChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ModEntities.MOD_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case OLIVE -> {
                return ModItems.OLIVE_CHEST_BOAT.get();
            }
            case STICK -> {
                return ModItems.STICK_CHEST_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(ModBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.OLIVE.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public ModBoatEntity.Type getModVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}