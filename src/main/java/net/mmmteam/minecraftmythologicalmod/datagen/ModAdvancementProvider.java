package net.mmmteam.minecraftmythologicalmod.datagen;

import net.mmmteam.minecraftmythologicalmod.MinecraftMythologicalMod;
import net.mmmteam.minecraftmythologicalmod.block.ModBlocks;
import net.mmmteam.minecraftmythologicalmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement Mythological = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GRAPES.get()),
                        Component.literal("Mythological"), Component.literal("Immerse yourself in the world of mythology"),
                        new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "textures/block/polished_calcite.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_grapes", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GRAPES.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "grapes"), existingFileHelper);

        Advancement findOliveTree = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModBlocks.OLIVE_SAPLING.get()),
                        Component.literal("Find Olive Tree"), Component.literal("Search for it in the mountain biomes"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("has_olive_tree", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.OLIVE_SAPLING.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "olive_tree"), existingFileHelper);

        Advancement findToriiTree = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModBlocks.TORII_SAPLING.get()),
                        Component.literal("Find Torii Tree"), Component.literal("Search for it in the cherry groves"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(findOliveTree)
                .addCriterion("has_torii_tree", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.TORII_SAPLING.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "torii_tree"), existingFileHelper);

        Advancement obtainRiceSeeds = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.RICE_SEEDS.get()),
                        Component.literal("Rice Seeds"), Component.literal("Search for it in the cherry groves"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("has_rice_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RICE_SEEDS.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "rice_seeds_food"), existingFileHelper);

        Advancement obtainRice = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.RICE.get()),
                        Component.literal("Rice"), Component.literal("Grow Rice"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainRiceSeeds)
                .addCriterion("has_rice", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RICE.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "rice_food"), existingFileHelper);

        Advancement obtainRiceBowl = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.BOWL_OF_RICE.get()),
                        Component.literal("Bowl of Rice"), Component.literal("Craft Bowl of Rice"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainRice)
                .addCriterion("has_rice_bowl", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BOWL_OF_RICE.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "rice_bowl_food"), existingFileHelper);

        Advancement obtainOnigiri = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.ONIGIRI.get()),
                        Component.literal("Onigiri"), Component.literal("Craft Onigiri"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainRice)
                .addCriterion("has_onigiri", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ONIGIRI.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "onigiri_food"), existingFileHelper);

        Advancement obtainSushi = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.SUSHI.get()),
                        Component.literal("Sushi"), Component.literal("Craft Sushi"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainRice)
                .addCriterion("has_sushi", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SUSHI.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "sushi_food"), existingFileHelper);

        Advancement buyDango = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.DANGO.get()),
                        Component.literal("Dango Connoisseur"), Component.literal("Buy Dango from cake lover"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainRice)
                .addCriterion("has_dango", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DANGO.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "dango_food"), existingFileHelper);

        Advancement buyMochi = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.MOCHI.get()),
                        Component.literal("Mochi"), Component.literal("Buy Mochi from cake lover"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainRice)
                .addCriterion("has_mochi", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MOCHI.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "mochi_food"), existingFileHelper);

        Advancement obtainAmbrosia = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.AMBROSIA.get()),
                        Component.literal("Ambrosia"), Component.literal("Kill the Stony Shores Cyclops"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("has_ambrosia", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.AMBROSIA.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "ambrosia_food"), existingFileHelper);

        Advancement obtainLaura = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.BAY_LEAF.get()),
                        Component.literal("Laura"), Component.literal("Search for it in the Windswept Gravelly Hills"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("has_bay_leaf", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BAY_LEAF.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "bay_leaf_food"), existingFileHelper);

        Advancement obtainBroth = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.BROTH.get()),
                        Component.literal("Broth"), Component.literal("Craft Broth"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainLaura)
                .addCriterion("has_broth", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BROTH.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "broth_food"), existingFileHelper);

        Advancement obtainLaurelWreath = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.LAUREL_WREATH.get()),
                        Component.literal("Laurel Wreath"), Component.literal("Craft Laurel Wreath"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainLaura)
                .addCriterion("has_laurel_wreath", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAUREL_WREATH.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "laurel_wreath_armour"), existingFileHelper);

        Advancement obtainKoiFishBucket = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.KOI_FISH_BUCKET.get()),
                        Component.literal("Great Catch"), Component.literal("Catch the koi fish in a bucket "),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("has_Koi_Fish_Bucket", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.KOI_FISH_BUCKET.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "koi_fish_bucket_bucket"), existingFileHelper);

        Advancement obtainExcalibur = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.EXCALIBUR.get()),
                        Component.literal("Excalibur"), Component.literal("\n" + "Only the most persistent hero will extract it from the stone"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("has_Excalibur", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EXCALIBUR.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "excalibur_weapon"), existingFileHelper);

        Advancement obtainPoseidonGift = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GIFT_OF_POSEIDON.get()),
                        Component.literal("Poseidon Gift"), Component.literal("\n" + "Sacrifice heart of the sea at the bonfire"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainExcalibur)
                .addCriterion("has_Poseidon_Gift", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GIFT_OF_POSEIDON.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "poseidons_gift_gift"), existingFileHelper);

        Advancement obtainPoseidonTrident = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.POSEIDONS_TRIDENT.get()),
                        Component.literal("Poseidon Trident"), Component.literal("\n" + "Connect the trident with the gift of Poseidon"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainPoseidonGift)
                .addCriterion("has_Poseidon_Trident", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POSEIDONS_TRIDENT.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "poseidons_trident_weapon"), existingFileHelper);

        Advancement obtainHadesGift = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GIFT_OF_HADES.get()),
                        Component.literal("Hades Gift"), Component.literal("\n" + "Sacrifice wither rose at the bonfire"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainExcalibur)
                .addCriterion("has_Hades_Gift", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GIFT_OF_HADES.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "hades_gift_gift"), existingFileHelper);

        Advancement obtainHadesTrident = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.HADES_TRIDENT.get()),
                        Component.literal("Poseidon Trident"), Component.literal("\n" + "Connect the trident with the gift of Hades"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainHadesGift)
                .addCriterion("has_Hades_Trident", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HADES_TRIDENT.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "hades_trident_weapon"), existingFileHelper);

        Advancement obtainPyxis = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.PYXIS.get()),
                        Component.literal("Pyxis"), Component.literal("\n" + "Find pyxis in suspicious sand in the warm ocean"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainExcalibur)
                .addCriterion("has_Pyxis", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PYXIS.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "pyxis_item"), existingFileHelper);

        Advancement obtainIrisPyxis = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.IRIS_PYXIS.get()),
                        Component.literal("Iris_Pyxis"), Component.literal("\n" + "craft an iris pyxis out of pyxis and iris. Amazing!!!"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainPyxis)
                .addCriterion("has_Iris_Pyxis", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIS_PYXIS.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "iris_pyxis_item"), existingFileHelper);


        Advancement obtainHephaestusGift = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GIFT_OF_HEPHAESTUS.get()),
                        Component.literal("Hephaestus Gift"), Component.literal("\n" + "Sacrifice pyxis at the bonfire"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainPyxis)
                .addCriterion("has_Hephaestus_Gift", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GIFT_OF_HEPHAESTUS.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "hephaestus_gift_gift"), existingFileHelper);

        Advancement obtainPeleusSword = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.SWORD_OF_PELEUS.get()),
                        Component.literal("Peleus Sword"), Component.literal("\n" + "Connect the Netherite Sword with the gift of Hephaestus"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainHephaestusGift)
                .addCriterion("has_Peleus_Sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SWORD_OF_PELEUS.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "peleus_sword_weapon"), existingFileHelper);

        Advancement obtainAtenaGift = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GIFT_OF_ATHENA.get()),
                        Component.literal("Atena Gift"), Component.literal("\n" + "Sacrifice iris pyxis at the bonfire"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainIrisPyxis)
                .addCriterion("has_Atena_Gift", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GIFT_OF_ATHENA.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "atena_gift_gift"), existingFileHelper);

        Advancement obtainAtenaSpear = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.SPEAR_OF_ATHENA.get()),
                        Component.literal("Atena Spear"), Component.literal("\n" + "Connect the stick with the gift of Atena"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainAtenaGift)
                .addCriterion("has_Atena_Trident", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPEAR_OF_ATHENA.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "atena_spear_weapon"), existingFileHelper);


        Advancement obtainApolloGift = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GIFT_OF_APOLLO.get()),
                        Component.literal("Apollo Gift"), Component.literal("\n" + "Sacrifice Ambrosia at the bonfire"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainExcalibur)
                .addCriterion("has_Apollo_Gift", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GIFT_OF_APOLLO.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "apollo_gift_gift"), existingFileHelper);

        Advancement obtainApolloBow = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.APOLLO_BOW.get()),
                        Component.literal("Apollo Bow"), Component.literal("\n" + "Connect the bow with the gift of apollo"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(obtainApolloGift)
                .addCriterion("has_Apollo_Bow", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.APOLLO_BOW.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "apollo_bow_weapon"), existingFileHelper);

        Advancement defeatMinotaur = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.MINOTAUR_HORN.get()),
                        Component.literal("Defeat Minotaur"), Component.literal("Kill the Windswept Gravelly Hills Minotaur"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("defeat_minotaur", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MINOTAUR_HORN.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "defeat_minotaur"), existingFileHelper);

        Advancement buyShield = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.SPARTAN_SHIELD.get()),
                        Component.literal("Obtain Spartan Shield"), Component.literal("Buy Shield from mythology lover"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("buy_spartan_shield", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPARTAN_SHIELD.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "spartan_shield_weapon"), existingFileHelper);

        Advancement chefSecret = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.NUNCHAKU.get()),
                        Component.literal("Discover the chef's secret"), Component.literal("Buy Nunchaku from cake lover"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Mythological)
                .addCriterion("buy_nunchaku", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NUNCHAKU.get()))
                .save(saver, new ResourceLocation(MinecraftMythologicalMod.MOD_ID, "nunchaku_weapon"), existingFileHelper);

    }
}
