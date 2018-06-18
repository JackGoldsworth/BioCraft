package me.jtghawk137.biocraft.server.item;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseItem extends Item
{

    protected String name;
    protected String formattedName;

    public BaseItem(String name, CreativeTabs tab)
    {
        this.name = name;
        this.setCreativeTab(tab);
        formattedName = Utils.formatString(name);
        this.setUnlocalizedName(formattedName);
        this.setRegistryName(BioCraft.MODID, formattedName);
    }

    public void registerItemModel()
    {
        RenderHandler.INSTANCE.registerItemRenderer(this, 0, formattedName);
    }
}
