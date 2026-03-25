package net.ashir.mccourse.item;

import net.ashir.mccourse.MCCourseMod;
import net.ashir.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FLOURITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCourseMod.MOD_ID, "flourite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.flourite"))
                    .icon(() -> new ItemStack(ModItems.FLOURITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FLOURITE);
                        entries.add(ModItems.RAW_FLOURITE);

                    }).build());

    public static final ItemGroup FLOURITE_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCourseMod.MOD_ID, "flourite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.flourite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.FLOURITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FLOURITE_BLOCK);
                        entries.add(ModBlocks.FLOURITE_ORE);
                        entries.add(ModBlocks.FLOURITE_DEEPSLATE_ORE);


                    }).build());

    public static void registerItemGroups() {
        MCCourseMod.LOGGER.info("Registering Item Groups for " + MCCourseMod.MOD_ID);
    }
}
