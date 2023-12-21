package net.mmmteam.minecraftmythologicalmod.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.custom.LaurelBushCrop;
import net.mmmteam.minecraftmythologicalmod.item.Moditems;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftMythologicalMod.MOD_ID);

    public static final RegistryObject<Block> STICK_BLOCK = registerBlock("stick_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> LAUREL_BUSH_CROP = BLOCKS.register("laurel_bush_crop",
            () -> new LaurelBushCrop(BlockBehaviour.Properties.copy(Blocks.CARROTS).noCollission().noOcclusion()));

    public static final RegistryObject<Block> IRIS = registerBlock("iris",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_IRIS = BLOCKS.register("potted_iris",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.IRIS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> ACONITE = registerBlock("aconite",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.TORCHFLOWER).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_ACONITE = BLOCKS.register("potted_aconite",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ACONITE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_TORCHFLOWER).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Bez tej komendy bloki nie miałyby stojego itemka w ekwipunku
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
