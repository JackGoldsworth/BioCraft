package me.jtghawk137.biocraft.server.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ItemHandler
{

    public static final ItemBase COPPER_INGOT = new ItemBase("Copper Ingot", CreativeTabs.MATERIALS);

    private static List<ItemBase> items = new ArrayList<>();

    public static void init()
    {
        items.add(COPPER_INGOT);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for (Item item : items)
        {
            event.getRegistry().register(item);
        }
    }

    public static List<ItemBase> getItems()
    {
        return items;
    }
}
