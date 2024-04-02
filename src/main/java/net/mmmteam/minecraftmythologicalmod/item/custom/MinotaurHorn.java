package net.mmmteam.minecraftmythologicalmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MinotaurHorn extends Item{
    public MinotaurHorn(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();

            assert player != null;
            pContext.getLevel().playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PILLAGER_CELEBRATE, SoundSource.BLOCKS, 1f, 1f, 0);
        }
        return InteractionResult.SUCCESS;
    }
}
