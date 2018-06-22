package me.jtghawk137.biocraft.server.container;

import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import me.jtghawk137.biocraft.server.container.slots.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class AirCompressorContainer extends Container
{

    public AirCompressorContainer(EntityPlayer player, AirCompressorBlockEntity blockEntity) {
        this.addSlotToContainer(new SlotItemHandler(blockEntity.getInventory(), 0, 51, 38));
        this.addSlotToContainer(new SlotOutput(blockEntity.getInventory(), 1, 109, 38));


        // Player's inventory
        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlotToContainer(new Slot(player.inventory, j1 + l * 9 + 9, 8 + j1 * 18, 84 + l * 18));
            }
        }
        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlotToContainer(new Slot(player.inventory, i1, 8 + i1 * 18, 142));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    //Shift Click
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        ItemStack transferred = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(slotIndex);

        int otherSlots = this.inventorySlots.size() - 36;

        if (slot != null && slot.getHasStack())
        {
            ItemStack current = slot.getStack();
            transferred = current.copy();

            if (slotIndex < otherSlots)
            {
                if (!this.mergeItemStack(current, otherSlots, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(current, 0, otherSlots, false))
            {
                return ItemStack.EMPTY;
            }

            if (current.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            } else
            {
                slot.onSlotChanged();
            }
        }

        return transferred;
    }
}
