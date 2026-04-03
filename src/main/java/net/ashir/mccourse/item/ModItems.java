package net.ashir.mccourse.item;

import net.ashir.mccourse.MCCourseMod;
import net.ashir.mccourse.item.custom.ChainsawItem;
import net.ashir.mccourse.item.custom.HammerItem;
import net.ashir.mccourse.item.custom.PaxelItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item FLOURITE = registerItem("flourite", new Item(new Item.Settings()));
    public static final Item RAW_FLOURITE = registerItem("raw_flourite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw", new ChainsawItem(new Item.Settings().maxDamage(32)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.mccourse.strawberry.tooltip.1"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item FLOURITE_SWORD = registerItem("flourite_sword",
            new SwordItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 3, -2.4f))));

    public static final Item FLOURITE_PICKAXE = registerItem("flourite_pickaxe",
            new PickaxeItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 1, -2.8f))));

    public static final Item FLOURITE_SHOVEL = registerItem("flourite_shovel",
            new ShovelItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 1.5f, -3f))));

    public static final Item FLOURITE_AXE = registerItem("flourite_axe",
            new AxeItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 6, -3.2f))));

    public static final Item FLOURITE_HOE = registerItem("flourite_hoe",
            new HoeItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 0, -3f))));

    public static final Item FLOURITE_PAXEL = registerItem("flourite_paxel",
            new PaxelItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 4, -2.5f))));

    public static final Item FLOURITE_HAMMER = registerItem("flourite_hammer",
            new HammerItem(ModToolMaterials.FLOURITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLOURITE, 8, -3.5f))));


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
