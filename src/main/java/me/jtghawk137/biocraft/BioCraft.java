package me.jtghawk137.biocraft;

import me.jtghawk137.biocraft.server.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BioCraft.MODID, name = BioCraft.NAME, version = BioCraft.VERSION)
public class BioCraft
{

    public static final String MODID = "biocraft";
    public static final String NAME = "BioCraft";
    public static final String VERSION = "0.0.1";

    @Mod.Instance(MODID)
    public static BioCraft instance;

    @SidedProxy(serverSide = "me.jtghawk137.biocraft.server.ServerProxy", clientSide = "me.jtghawk137.biocraft.client.ClientProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.onPreInit(event);
        System.out.println(NAME + " is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.onInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.onPostInit(event);
    }
}
