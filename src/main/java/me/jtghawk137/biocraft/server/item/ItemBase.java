package me.jtghawk137.biocraft.server.item;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Locale;

public class ItemBase extends Item
{

    protected String name;

    public ItemBase(String name, CreativeTabs tab)
    {
        this.name = name;
        this.setCreativeTab(tab);
        String formattedName = name.toLowerCase(Locale.ENGLISH).replaceAll(" ", "_").replaceAll("'", "");
        this.setUnlocalizedName(formattedName);
        this.setRegistryName(BioCraft.MODID, formattedName);
    }

    public void registerItemModel()
    {
        RenderHandler.INSTANCE.registerItemRenderer(this, 0, name);
    }
}
