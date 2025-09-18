package net.modcito.component.type;

import net.minecraft.component.type.FoodComponent;

public class ModcitoFoodComponents {
    public static final FoodComponent AREPA = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6F).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.6F).build();
}
