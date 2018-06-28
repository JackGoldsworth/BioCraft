package me.jtghawk137.biocraft.server.block;

import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.api.ContentRegistry;
import me.jtghawk137.biocraft.server.tab.TabHandler;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BaseBlock extends Block implements ContentRegistry
{

    protected String name;
    protected String formattedName;

    public BaseBlock(Material material, String name)
    {
        super(material);
        this.name = name;
        this.setCreativeTab(TabHandler.BLOCKS);
        formattedName = Utils.formatString(name);
        setUnlocalizedName(formattedName);
        setRegistryName(formattedName);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void registerModel()
    {
        RenderHandler.INSTANCE.registerItemRenderer(Item.getItemFromBlock(this), 0, formattedName);
    }
}