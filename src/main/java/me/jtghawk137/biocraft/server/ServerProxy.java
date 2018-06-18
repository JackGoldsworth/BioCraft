package me.jtghawk137.biocraft.server;

import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy
{

    public void onPreInit(FMLPreInitializationEvent event)
    {
        ItemHandler.init();
    }

    public void onPostInit(FMLPostInitializationEvent event)
    {

    }

    public void onInit(FMLInitializationEvent event)
    {

    }

}
