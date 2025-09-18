package net.modcito;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class ModcitoKeybindings {
    public static KeyBinding OPEN_GUI;

    public static void register() {
        OPEN_GUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.modcito.opengui",
                GLFW.GLFW_KEY_K,
                "category.modcito.keys"
        ));
    }
}
