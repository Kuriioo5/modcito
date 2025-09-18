package net.modcito.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.modcito.Modcito;

public class EmeraldFurnaceScreen extends Screen {

    private static final Identifier GUI_TEXTURE = Identifier.of(Modcito.MOD_ID, "textures/gui/emerald_furnace.png");
    private final int textureWidth = 176;
    private final int textureHeight = 256;

    public EmeraldFurnaceScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        int centerX = (this.width - textureWidth) / 2;
        int centerY = (this.height - textureHeight) / 2;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int centerX = (this.width - textureWidth) / 2;
        int centerY = (this.height - textureHeight) / 2;

        context.drawTexture(GUI_TEXTURE, centerX, centerY, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);

        super.render(context, mouseX, mouseY, delta);
    }
}
