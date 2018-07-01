package me.jtghawk137.biocraft.client.render;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.animals.Animal;
import me.jtghawk137.biocraft.server.api.ContentRegistry;
import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.entity.EntityHandler;
import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraft.block.Block;
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
        for (Item item : ItemHandler.getItems())
        {
            if (item instanceof ContentRegistry)
            {
                ContentRegistry contentItem = (ContentRegistry) item;
                contentItem.registerModel();
            }
        }
        for (Block block : BlockHandler.getBlocks())
        {
            if (block instanceof ContentRegistry)
            {
                ContentRegistry contentBlock = (ContentRegistry) block;
                contentBlock.registerModel();
            }
        }
        for (Animal animal : EntityHandler.getAnimals())
        {
            if (animal instanceof ContentRegistry)
            {
                animal.registerModel();
            }
        }
    }

    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(BioCraft.MODID + ":" + id, "inventory"));
    }
}
