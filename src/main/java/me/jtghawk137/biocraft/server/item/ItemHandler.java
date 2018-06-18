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

    public static final BaseItem COPPER_INGOT = new BaseItem("Copper Ingot", CreativeTabs.MATERIALS);

    private static List<BaseItem> items = new ArrayList<>();

    public static void preInit()
    {
        items.add(COPPER_INGOT);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(items.toArray(new Item[items.size()]));
    }

    public static List<BaseItem> getItems()
    {
        return items;
    }
}
