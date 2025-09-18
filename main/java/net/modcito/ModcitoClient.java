package net.modcito;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;
import net.modcito.screen.EmeraldFurnaceScreenHandler;

public class ModcitoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModcitoKeybindings.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(ModcitoKeybindings.OPEN_GUI.wasPressed()) {
//                client.setScreen(new EmeraldFurnaceScreenHandler(Text.of("Emerald Furnace")));
            }
        });
    }
}
