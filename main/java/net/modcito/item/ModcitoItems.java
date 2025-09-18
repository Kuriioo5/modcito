package net.modcito.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.modcito.Modcito;
import net.modcito.block.ModcitoBlocks;
import net.modcito.component.type.ModcitoFoodComponents;

import java.util.function.UnaryOperator;

public class ModcitoItems {
    public static final Item AREPA = register("arepa", new Item(new Item.Settings().food(ModcitoFoodComponents.AREPA)));
    public static final Item CHEESE = register("cheese", new Item(new Item.Settings().food(ModcitoFoodComponents.CHEESE)));
    public static final Item FLOUR = register("flour", new Item(new Item.Settings()));
    public static final Item EMERALD_FURNACE = register(ModcitoBlocks.EMERALD_FURNACE, settings -> settings.component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item EMERALD_STICK = register("emerald_stick", new Item(new Item.Settings()));
    public static final Item EMERALD_SWORD = register(
            "emerald_sword",
            new SwordItem(ModcitoToolMaterials.EMERALD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModcitoToolMaterials.EMERALD, 4, -2.4F)))
    );
    public static final Item EMERALD_SHOVEL = register(
            "emerald_shovel",
            new ShovelItem(ModcitoToolMaterials.EMERALD, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModcitoToolMaterials.EMERALD, 1.5F, -3.0F)))
    );
    public static final Item EMERALD_PICKAXE = register(
            "emerald_pickaxe",
            new PickaxeItem(ModcitoToolMaterials.EMERALD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModcitoToolMaterials.EMERALD, 1.0F, -2.8F)))
    );
    public static final Item EMERALD_AXE = register(
            "emerald_axe",
            new AxeItem(ModcitoToolMaterials.EMERALD, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModcitoToolMaterials.EMERALD, 6.0F, -3.0F)))
    );
    public static final Item EMERALD_HOE = register(
            "emerald_hoe",
            new HoeItem(ModcitoToolMaterials.EMERALD, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModcitoToolMaterials.EMERALD, -3.0F, 0.0F)))
    );


    public static Item register(Block block, UnaryOperator<Item.Settings> settingsOperator) {
        return register(new BlockItem(block, (Item.Settings)settingsOperator.apply(new Item.Settings())));
    }

    public static Item register(BlockItem item) {
        return register(item.getBlock(), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(Block block, Item item) {
        Identifier vanillaId = Registries.BLOCK.getId(block);
        Identifier myId = Identifier.of(Modcito.MOD_ID, vanillaId.getPath());
        return register(myId, item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Modcito.MOD_ID, name), item);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(EMERALD_STICK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(EMERALD_SHOVEL);
            entries.add(EMERALD_PICKAXE);
            entries.add(EMERALD_AXE);
            entries.add(EMERALD_HOE);
            entries.add(EMERALD_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(EMERALD_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(AREPA);
            entries.add(CHEESE);
            entries.add(FLOUR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(EMERALD_FURNACE);
        });
    }
}
