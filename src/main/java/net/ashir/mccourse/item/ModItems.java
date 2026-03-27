package net.ashir.mccourse.item;

import net.ashir.mccourse.MCCourseMod;
import net.ashir.mccourse.item.custom.ChainsawItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FLOURITE = registerItem("flourite", new Item(new Item.Settings()));
    public static final Item RAW_FLOURITE = registerItem("raw_flourite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw", new ChainsawItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLOURITE);
        entries.add(RAW_FLOURITE);

    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);
    }
}
