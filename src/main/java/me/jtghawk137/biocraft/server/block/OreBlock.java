package me.jtghawk137.biocraft.server.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OreBlock extends BaseBlock
{

    public OreBlock(String name)
    {
        super(Material.ROCK, name);
        setHardness(3F);
        setResistance(5F);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
}
