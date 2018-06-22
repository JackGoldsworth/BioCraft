package me.jtghawk137.biocraft.client.gui;

import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import me.jtghawk137.biocraft.server.container.AirCompressorContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class AirCompressorGui extends GuiContainer
{

    private final AirCompressorBlockEntity blockEntity;

    public AirCompressorGui(EntityPlayer player, AirCompressorBlockEntity blockEntity)
    {
        super(new AirCompressorContainer(player, blockEntity));
        this.blockEntity = blockEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        TextureManager manager = Minecraft.getMinecraft().renderEngine;
        this.zLevel = 0;
        ResourceLocation slotLocation = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");
        manager.bindTexture(slotLocation);
        for(Slot slot : this.inventorySlots.inventorySlots) {
            this.drawTexturedModalRect(this.guiLeft + slot.xPos - 1, this.guiTop + slot.yPos - 1, 7, 17, 18, 18);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
}
