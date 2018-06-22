package me.jtghawk137.biocraft.client;

import me.jtghawk137.biocraft.client.event.ClientEventHandler;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{

    @Override
    public void onPreInit(FMLPreInitializationEvent event)
    {
        super.onPreInit(event);
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        MinecraftForge.EVENT_BUS.register(RenderHandler.INSTANCE);
    }

    @Override
    public void onInit(FMLInitializationEvent event)
    {
        RenderHandler.INSTANCE.init();
        super.onInit(event);
    }

    @Override
    public void onPostInit(FMLPostInitializationEvent event)
    {
        super.onPostInit(event);
    }
}
