package net.ashir.mccourse.datagen;

import net.ashir.mccourse.block.ModBlocks;
import net.ashir.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLOURITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLOURITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAINSAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
    }
}
