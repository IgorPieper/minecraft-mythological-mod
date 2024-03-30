package net.mmmteam.minecraftmythologicalmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.mmmteam.minecraftmythologicalmod.villager.ModVillager;

import java.util.List;

@Mod.EventBusSubscriber(modid = MinecraftMythologicalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == ModVillager.ModVillagers.GODS_SMITH.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            ItemStack stack = new ItemStack(Items.BRUSH, 1);

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3), stack, 2, 5, 0.06f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModBlocks.IRIS.get()), 10, 5, 0.02f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModBlocks.ACONITE.get()), 10, 5, 0.02f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(Blocks.DECORATED_POT), 5, 10, 0.02f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(Blocks.VINE), 10, 5, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.BLADE_POTTERY_SHERD), 4, 7, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.BURN_POTTERY_SHERD), 4, 7, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.ARMS_UP_POTTERY_SHERD), 4, 7, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.PYXIS.get()), 10, 4, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(Items.BRUSH), 3, 10, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.ACONITE_ROOT.get(), 2),
                    new ItemStack(Items.EMERALD, 5), 5, 3, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModBlocks.OLIVE_SAPLING.get()), 10, 5, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.GRAPES.get()), 10, 5, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BAY_LEAF.get(), 2),
                    new ItemStack(Items.EMERALD), 13, 3, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.ECHO_SHARD, 1),
                    new ItemStack(Items.EMERALD, 9), 13, 3, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ModItems.AMBROSIA.get()), 3, 15, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.ARCHER_POTTERY_SHERD), 4, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.SHEAF_POTTERY_SHERD), 4, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.IRIS_PYXIS.get(), 1),
                    new ItemStack(Items.EMERALD, 4), 5, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.WITHER_ROSE), 4, 7, 0.02f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 50),
                    new ItemStack(ModItems.EXCALIBUR.get()), 3, 2, 0.02f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ModItems.SPARTAN_SHIELD.get()), 3, 2, 0.02f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.HEART_OF_THE_SEA, 1),
                    new ItemStack(Items.EMERALD, 45), 1, 2, 0.02f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SWORD_OF_PELEUS.get()),
                    new ItemStack(Items.EMERALD, 15 ), 1, 2, 0.02f
            ));
        }

        if(event.getType() == ModVillager.ModVillagers.JAP_SMITH.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModBlocks.SPIDER_LILY.get()), 10, 5, 0.02f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.RICE_SEEDS.get()), 10, 5, 0.02f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.BOWL_OF_RICE.get(), 1),
                    new ItemStack(Items.EMERALD, 5), 10, 5, 0.02f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.SUSPICIOUS_STEW), 10, 5, 0.02f
            ));


            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.SUSHI.get()), 10, 4, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(Items.BELL), 3, 10, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.ONIGIRI.get()), 10, 5, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.KOI_FISH_BUCKET.get()), 10, 5, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModBlocks.TORII_SAPLING.get()), 10, 5, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.DANGO.get()), 4, 7, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.MOCHI.get()), 4, 7, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.INK_SAC, 3), 4, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(Blocks.CAKE), 4, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GLOW_INK_SAC, 4),
                    new ItemStack(Items.EMERALD, 4), 5, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.BAMBOO), 4, 7, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.PAINTING), 4, 7, 0.02f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 52),
                    new ItemStack(ModItems.NUNCHAKU.get()), 3, 2, 0.02f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.PUFFERFISH, 1),
                    new ItemStack(Items.EMERALD, 10), 3, 2, 0.02f
            ));

        }
    }
}


