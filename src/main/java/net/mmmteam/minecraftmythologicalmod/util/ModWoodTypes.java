package net.mmmteam.minecraftmythologicalmod.util;

import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType OLIVE = WoodType.register(new WoodType(MinecraftMythologicalMod.MOD_ID + ":olive", BlockSetType.OAK));
}
