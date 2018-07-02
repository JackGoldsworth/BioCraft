package me.jtghawk137.biocraft.client.event;

import me.jtghawk137.biocraft.client.gui.SecurityCameraGui;
import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.block.entity.SecurityCameraBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientEventHandler
{

    @SubscribeEvent
    public void onView(EntityViewRenderEvent.CameraSetup event)
    {
        if (event.getEntity() instanceof EntityPlayer && Minecraft.getMinecraft().currentScreen != null)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            if ((Minecraft.getMinecraft().currentScreen instanceof SecurityCameraGui) && !BlockHandler.getCamerasForUUID(player.getUniqueID()).isEmpty())
            {
                SecurityCameraGui cameraGui = (SecurityCameraGui) Minecraft.getMinecraft().currentScreen;
                if (player.ticksExisted % 40 == 0)
                    cameraGui.switchCurrentCamera(1);
                SecurityCameraBlockEntity camera = cameraGui.getCurrentCameraEntity();
                double x = camera.getPos().getX();
                double y = camera.getPos().getY();
                double z = camera.getPos().getZ();
                GlStateManager.translate(x - player.posX, y - player.posY, (z - player.posZ) + 3);
            }
        }
    }
}
