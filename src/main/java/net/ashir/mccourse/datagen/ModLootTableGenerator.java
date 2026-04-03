package net.ashir.mccourse.datagen;

import net.ashir.mccourse.block.ModBlocks;
import net.ashir.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FLOURITE_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.FLOURITE_ORE, oreDrops(ModBlocks.FLOURITE_ORE, ModItems.RAW_FLOURITE));
        addDrop(ModBlocks.FLOURITE_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.FLOURITE_DEEPSLATE_ORE, ModItems.RAW_FLOURITE, 2, 5));
        addDrop(ModBlocks.FLOURITE_NETHER_ORE, multipleOreDrops(ModBlocks.FLOURITE_NETHER_ORE, ModItems.RAW_FLOURITE, 1, 7));
        addDrop(ModBlocks.FLOURITE_END_ORE, multipleOreDrops(ModBlocks.FLOURITE_END_ORE, ModItems.RAW_FLOURITE, 4, 8));

        addDrop(ModBlocks.FLOURITE_STAIRS);
        addDrop(ModBlocks.FLOURITE_SLAB, slabDrops(ModBlocks.FLOURITE_SLAB));
        addDrop(ModBlocks.FLOURITE_BUTTON);
        addDrop(ModBlocks.FLOURITE_PRESSURE_PLATE);

        addDrop(ModBlocks.FLOURITE_DOOR, doorDrops(ModBlocks.FLOURITE_DOOR));
        addDrop(ModBlocks.FLOURITE_TRAPDOOR);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
