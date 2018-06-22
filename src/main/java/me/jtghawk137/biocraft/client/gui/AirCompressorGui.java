package me.jtghawk137.biocraft.client.gui;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import me.jtghawk137.biocraft.server.container.AirCompressorContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class AirCompressorGui extends GuiContainer
{

    private final AirCompressorBlockEntity blockEntity;
    private ResourceLocation texture = new ResourceLocation(BioCraft.MODID, "textures/gui/aircompressor.png");

    public AirCompressorGui(EntityPlayer player, AirCompressorBlockEntity blockEntity)
    {
        super(new AirCompressorContainer(player, blockEntity));
        this.blockEntity = blockEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(x + 77, y + 37, 176, 0, blockEntity.getCurrentTime() * 21 / 100, 16);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
}
