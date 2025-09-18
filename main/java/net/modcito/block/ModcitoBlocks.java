package net.modcito.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.modcito.Modcito;

public class ModcitoBlocks {

    public static final Block EMERALD_FURNACE = register("emerald_furnace", new EmeraldFurnaceBlock(AbstractBlock.Settings.create().strength(5.0F)));

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Modcito.MOD_ID, name), block);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(EMERALD_FURNACE);
        });
    }
}
