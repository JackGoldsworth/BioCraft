package me.jtghawk137.biocraft.server.block.machine;

import me.jtghawk137.biocraft.server.api.IContentRegistry;
import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AirCompressorBlock extends BlockContainer implements IContentRegistry
{

    private String name;

    protected AirCompressorBlock(Material materialIn)
    {
        super(materialIn);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new AirCompressorBlockEntity();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Class getContentClass()
    {
        return this.getClass();
    }

    @Override
    public void registerModel()
    {

    }
}
