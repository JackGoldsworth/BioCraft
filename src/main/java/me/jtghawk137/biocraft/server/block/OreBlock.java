package me.jtghawk137.biocraft.server.block;

import net.minecraft.block.material.Material;

public class OreBlock extends BaseBlock
{

    public OreBlock(String name)
    {
        super(Material.ROCK, name);
        setHardness(3F);
        setResistance(5F);
    }
}
