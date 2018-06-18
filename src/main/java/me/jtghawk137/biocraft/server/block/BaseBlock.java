package me.jtghawk137.biocraft.server.block;

import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BaseBlock extends Block
{

    protected String name;
    protected String formattedName;

    public BaseBlock(Material material, String name)
    {
        super(material);
        this.name = name;
        this.setCreativeTab(CreativeTabs.MATERIALS);
        formattedName = Utils.formatString(name);
        setUnlocalizedName(formattedName);
        setRegistryName(formattedName);
    }

    public void registerItemModel(Item itemBlock)
    {
        RenderHandler.INSTANCE.registerItemRenderer(itemBlock, 0, formattedName);
    }

    public Item createItemBlock()
    {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}