package me.jtghawk137.biocraft.server;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.gui.GuiHandler;
import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.entity.EntityHandler;
import me.jtghawk137.biocraft.server.event.ServerEventHandler;
import me.jtghawk137.biocraft.server.item.ItemHandler;
import me.jtghawk137.biocraft.server.recipe.SmeltingHandler;
import me.jtghawk137.biocraft.server.world.WorldGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy
{

    public void onPreInit(FMLPreInitializationEvent event)
    {
        ItemHandler.init();
        BlockHandler.init();
        EntityHandler.init();
        MinecraftForge.EVENT_BUS.register(new ServerEventHandler());
        GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(BioCraft.instance, new GuiHandler());
    }

    public void onInit(FMLInitializationEvent event)
    {
        SmeltingHandler.init();
    }

    public void onPostInit(FMLPostInitializationEvent event)
    {

    }

    public void openCamera(EntityPlayer player)
    {

    }
}
