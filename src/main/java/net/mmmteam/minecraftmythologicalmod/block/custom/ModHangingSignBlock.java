
package net.mmmteam.minecraftmythologicalmod.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.mmmteam.minecraftmythologicalmod.block.entity.ModHangingSignBlockEntity;

public class ModHangingSignBlock extends CeilingHangingSignBlock {
    public ModHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity(pPos, pState);
    }
}