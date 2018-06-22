package me.jtghawk137.biocraft.client.gui;

import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import me.jtghawk137.biocraft.server.container.AirCompressorContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

    public static final int GUI_AIR_COMPRESSOR = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) //Return container
    {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == GUI_AIR_COMPRESSOR && tileEntity instanceof AirCompressorBlockEntity) {
            return new AirCompressorContainer(player, (AirCompressorBlockEntity)tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) //Return GUI
    {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == GUI_AIR_COMPRESSOR && tileEntity instanceof AirCompressorBlockEntity) {
            return new AirCompressorGui(player, (AirCompressorBlockEntity)tileEntity);
        }
        return null;
    }
}
