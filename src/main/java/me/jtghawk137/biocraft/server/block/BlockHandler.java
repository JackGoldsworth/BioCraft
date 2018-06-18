package me.jtghawk137.biocraft.server.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class BlockHandler
{

    public static final OreBlock COPPER_ORE = new OreBlock("Copper Ore");

    private static List<BaseBlock> blocks = new ArrayList<>();

    public static void preInit()
    {
        blocks.add(COPPER_ORE);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(blocks.toArray(new Block[blocks.size()]));
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(COPPER_ORE.createItemBlock());
    }

    public static List<BaseBlock> getBlocks()
    {
        return blocks;
    }
}