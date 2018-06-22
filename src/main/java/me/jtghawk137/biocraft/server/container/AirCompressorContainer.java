package me.jtghawk137.biocraft.server.container;

import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.SlotItemHandler;

public class AirCompressorContainer extends Container
{

    public AirCompressorContainer(EntityPlayer player, AirCompressorBlockEntity blockEntity) {
        this.addSlotToContainer(new SlotItemHandler(blockEntity.getInventory(), 0,50, 50));
        this.addSlotToContainer(new SlotItemHandler(blockEntity.getInventory(), 1,60, 60));


        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlotToContainer(new Slot(player.inventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18));
            }
        }
        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlotToContainer(new Slot(player.inventory, i1, 8 + i1 * 18, 161));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
