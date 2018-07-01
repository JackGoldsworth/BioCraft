package me.jtghawk137.biocraft.client.event;

import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.block.entity.SecurityCameraBlockEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ClientEventHandler
{

    @SubscribeEvent
    public void onView(EntityViewRenderEvent.CameraSetup event)
    {
        if (event.getEntity() instanceof EntityPlayer)
        {
            if (!BlockHandler.getCameras().isEmpty())
            {
                EntityPlayer player = (EntityPlayer) event.getEntity();
                SecurityCameraBlockEntity camera = BlockHandler.getCameras().get(player.getUniqueID());
                double y = camera.getPos().getY();
                GL11.glTranslated(.05, y * player.getYOffset(), 2);
            }
        }

    }
}
