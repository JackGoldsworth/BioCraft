package me.jtghawk137.biocraft.client.render;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.api.IContentRegistry;
import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
@SideOnly(Side.CLIENT)
public enum RenderHandler
{
    INSTANCE;

    public void init()
    {

    }

    @SubscribeEvent
    public static void onModelEvent(ModelRegistryEvent event)
    {
        for (IContentRegistry item : ItemHandler.getItems())
        {
            item.registerModel();
        }
        for (IContentRegistry block : BlockHandler.getBlocks())
        {
            block.registerModel();
        }
    }

    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(BioCraft.MODID + ":" + id, "inventory"));
    }
}
