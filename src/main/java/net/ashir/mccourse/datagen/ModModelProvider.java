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
        BlockStateModelGenerator.BlockTexturePool flouriteTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLOURITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_NETHER_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        flouriteTexturePool.stairs(ModBlocks.FLOURITE_STAIRS);
        flouriteTexturePool.slab(ModBlocks.FLOURITE_SLAB);

        flouriteTexturePool.button(ModBlocks.FLOURITE_BUTTON);
        flouriteTexturePool.pressurePlate(ModBlocks.FLOURITE_PRESSURE_PLATE);

        flouriteTexturePool.fence(ModBlocks.FLOURITE_FENCE);
        flouriteTexturePool.fenceGate(ModBlocks.FLOURITE_FENCE_GATE);
        flouriteTexturePool.wall(ModBlocks.FLOURITE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.FLOURITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.FLOURITE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLOURITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLOURITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAINSAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);

        itemModelGenerator.register(ModItems.FLOURITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_HAMMER, Models.HANDHELD);
    }
}
