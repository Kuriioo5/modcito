package net.modcito.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.modcito.Modcito;

public final class ModcitoTags {
    public static final TagKey<Block> NEEDS_EMERALD_TOOL = createBlockTag("needs_emerald_tool");
    public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = createBlockTag("incorrect_for_emerald_tool");

    public static TagKey<Block> createBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Modcito.MOD_ID, name));
    }

    public static TagKey<Item> createItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Modcito.MOD_ID, name));
    }
}
