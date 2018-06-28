package me.jtghawk137.biocraft.server.item;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.api.ContentRegistry;
import me.jtghawk137.biocraft.server.tab.TabHandler;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.item.Item;

public class BaseItem extends Item implements ContentRegistry
{

    protected String name;
    protected String formattedName;

    public BaseItem(String name)
    {
        this.name = name;
        this.setCreativeTab(TabHandler.ITEMS);
        formattedName = Utils.formatString(name);
        this.setUnlocalizedName(formattedName);
        this.setRegistryName(BioCraft.MODID, formattedName);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void registerModel()
    {
        RenderHandler.INSTANCE.registerItemRenderer(this, 0, formattedName);
    }
}
