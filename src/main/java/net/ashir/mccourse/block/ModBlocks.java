package net.ashir.mccourse.block;

import net.ashir.mccourse.MCCourseMod;
import net.ashir.mccourse.block.custom.MagicBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block FLOURITE_BLOCK = registerBlock("flourite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .strength(4f).requiresTool()));

    public static final Block FLOURITE_ORE = registerBlock("flourite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()));

    public static final Block FLOURITE_DEEPSLATE_ORE = registerBlock("flourite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE)
                            .strength(6f).requiresTool()));

    public static final Block FLOURITE_NETHER_ORE = registerBlock("flourite_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHER_GOLD_ORE)
                            .strength(2f).requiresTool()));

    public static final Block FLOURITE_END_ORE = registerBlock("flourite_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block FLOURITE_STAIRS = registerBlock("flourite_stairs",
            new StairsBlock(ModBlocks.FLOURITE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block FLOURITE_SLAB = registerBlock("flourite_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block FLOURITE_BUTTON = registerBlock("flourite_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLOURITE_PRESSURE_PLATE = registerBlock("flourite_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLOURITE_FENCE = registerBlock("flourite_fence",
            new FenceBlock(AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLOURITE_FENCE_GATE = registerBlock("flourite_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLOURITE_WALL = registerBlock("flourite_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLOURITE_DOOR = registerBlock("flourite_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque()));

    public static final Block FLOURITE_TRAPDOOR = registerBlock("flourite_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MCCourseMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MCCourseMod.LOGGER.info("Registering Mo Blocks for " + MCCourseMod.MOD_ID);
    }
}
