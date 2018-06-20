package me.jtghawk137.biocraft.server.recipe;

import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingHandler
{

    public static void init()
    {
        GameRegistry.addSmelting(BlockHandler.COPPER_ORE, new ItemStack(ItemHandler.COPPER_INGOT), .07f);
    }
}
