package me.jtghawk137.biocraft.client.gui;

import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.block.entity.SecurityCameraBlockEntity;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class SecurityCameraGui extends GuiScreen
{

    private EntityPlayer player;
    private int cameraCount;
    private SecurityCameraBlockEntity currentCamera;
    private List<SecurityCameraBlockEntity> cameras;

    public SecurityCameraGui(EntityPlayer player)
    {
        this.player = player;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        cameras = BlockHandler.getCamerasForUUID(player.getUniqueID());
        cameraCount = cameras.size();
        currentCamera = cameras.get(0);
    }

    public void switchCurrentCamera(int camera)
    {
        if (cameras.get(camera) != null)
        {
            currentCamera = cameras.get(camera);
        }
    }

    public SecurityCameraBlockEntity getCurrentCameraEntity()
    {
        return currentCamera;
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
