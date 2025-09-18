package net.modcito.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.modcito.block.EmeraldFurnaceBlock;
import net.modcito.screen.EmeraldFurnaceScreenHandler;

public class EmeraldFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    public EmeraldFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(EmeraldFurnaceBlock.EMERALD_FURNACE_ENTITY, pos, state, RecipeType.SMELTING);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new EmeraldFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}