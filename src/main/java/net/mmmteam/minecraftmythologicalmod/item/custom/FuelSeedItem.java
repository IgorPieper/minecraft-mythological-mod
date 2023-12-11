package net.mmmteam.minecraftmythologicalmod.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelSeedItem extends Item {
    private int burnTime = 0;
    private BlockItem blockItem;

    public FuelSeedItem(Properties pProperties, int burnTime, BlockItem blockItem) {
        super(pProperties);
        this.burnTime = burnTime;
        this.blockItem = blockItem;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    public BlockItem getBlockItem() {
        return blockItem;
    }
}
