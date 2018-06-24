package me.jtghawk137.biocraft.server.tab;

import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabHandler
{

    public static final CreativeTabs ITEMS = new CreativeTabs("biocraft.items")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ItemHandler.COPPER_INGOT);
        }
    };

    public static final CreativeTabs BLOCKS = new CreativeTabs("biocraft.blocks")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemFromBlock(BlockHandler.COPPER_ORE));
        }
    };

    public static final CreativeTabs MACHINES = new CreativeTabs("biocraft.machines")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemFromBlock(BlockHandler.AIR_COMPRESSOR));
        }
    };
}