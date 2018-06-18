package me.jtghawk137.biocraft.server;

import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy
{

    public void onPreInit(FMLPreInitializationEvent event)
    {
        ItemHandler.preInit();
        BlockHandler.preInit();
        MinecraftForge.EVENT_BUS.register(new ItemHandler());
        MinecraftForge.EVENT_BUS.register(new BlockHandler());
    }

    public void onInit(FMLInitializationEvent event)
    {
    }

    public void onPostInit(FMLPostInitializationEvent event)
    {

    }
}
