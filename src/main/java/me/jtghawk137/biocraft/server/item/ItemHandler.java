package me.jtghawk137.biocraft.server.item;

import me.jtghawk137.biocraft.server.api.IContentRegistry;
import me.jtghawk137.biocraft.server.item.diving.BCDItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ItemHandler
{

    public static final BaseItem COPPER_INGOT = new BaseItem("Copper Ingot");
    public static final BaseItem NICKEL_INGOT = new BaseItem("Nickel Ingot");
    public static final BaseItem LEAD_INGOT = new BaseItem("Lead Ingot");
    public static final BaseItem TIN_INGOT = new BaseItem("Tin Ingot");
    public static final BaseItem ALUMINIUM_INGOT = new BaseItem("Aluminium Ingot");
    public static final BaseItem SILVER_INGOT = new BaseItem("Silver Ingot");
    public static final BaseItem PLATINUM_INGOT = new BaseItem("Platinum Ingot");
    public static final ArmorItem BCD_ITEM = new BCDItem(ItemArmor.ArmorMaterial.LEATHER, EntityEquipmentSlot.CHEST, "bcd");

    private static List<IContentRegistry> items = new ArrayList<>();

    public static void init()
    {
        items.add(COPPER_INGOT);
        items.add(NICKEL_INGOT);
        items.add(LEAD_INGOT);
        items.add(TIN_INGOT);
        items.add(ALUMINIUM_INGOT);
        items.add(SILVER_INGOT);
        items.add(PLATINUM_INGOT);
        items.add(BCD_ITEM);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(items.toArray(new Item[items.size()]));
        event.getRegistry().register(BCD_ITEM);
    }

    public static List<IContentRegistry> getItems()
    {
        return items;
    }
}
