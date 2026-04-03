package net.ashir.mccourse.datagen;

import net.ashir.mccourse.MCCourseMod;
import net.ashir.mccourse.block.ModBlocks;
import net.ashir.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> FLOURITE_SMELTABLES = List.of(ModItems.RAW_FLOURITE, ModBlocks.FLOURITE_ORE,
                ModBlocks.FLOURITE_END_ORE, ModBlocks.FLOURITE_NETHER_ORE, ModBlocks.FLOURITE_DEEPSLATE_ORE);
        offerSmelting(exporter, FLOURITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLOURITE, 0.2f, 200, "flourite");
        offerBlasting(exporter, FLOURITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLOURITE, 0.2f, 100, "flourite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FLOURITE, RecipeCategory.DECORATIONS, ModBlocks.FLOURITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLOURITE)
                .pattern("SFS")
                .pattern("SFS")
                .pattern("SFS")
                .input('S', Blocks.STONE)
                .input('F', ModItems.FLOURITE)
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(ModItems.FLOURITE), conditionsFromItem(ModItems.FLOURITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLOURITE)
                .pattern("SSS")
                .pattern("FFF")
                .pattern("SSS")
                .input('S', Blocks.STONE)
                .input('F', ModItems.FLOURITE)
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(ModItems.FLOURITE), conditionsFromItem(ModItems.FLOURITE))
                .offerTo(exporter, Identifier.of(MCCourseMod.MOD_ID, "raw_flourite_2"));
    }
}
