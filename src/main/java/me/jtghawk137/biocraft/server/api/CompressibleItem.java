package me.jtghawk137.biocraft.server.api;

import net.minecraft.item.ItemStack;

public interface CompressibleItem
{
    default boolean isCompressible(ItemStack stack)
    {
        return true;
    }

    ItemStack getCompressedOutput(ItemStack stack);
}