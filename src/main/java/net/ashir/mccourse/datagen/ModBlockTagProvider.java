package net.ashir.mccourse.datagen;

import net.ashir.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FLOURITE_BLOCK,
                        ModBlocks.FLOURITE_DEEPSLATE_ORE,
                        ModBlocks.FLOURITE_END_ORE,
                        ModBlocks.FLOURITE_NETHER_ORE,
                        ModBlocks.FLOURITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FLOURITE_END_ORE,
                        ModBlocks.FLOURITE_NETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FLOURITE_DEEPSLATE_ORE);
    }
}
