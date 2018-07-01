package me.jtghawk137.biocraft.server.block.machine;

import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.block.OrientedBlock;
import me.jtghawk137.biocraft.server.block.entity.SecurityCameraBlockEntity;
import me.jtghawk137.biocraft.server.tab.TabHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SecurityCameraBlock extends OrientedBlock
{

    public SecurityCameraBlock(String name)
    {
        super(name, Material.ANVIL);
        this.setCreativeTab(TabHandler.MACHINES);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (hasTileEntity && worldIn.getTileEntity(pos) instanceof SecurityCameraBlockEntity)
        {
            SecurityCameraBlockEntity camera = (SecurityCameraBlockEntity) worldIn.getTileEntity(pos);
            camera.setPlacerUUID(placer.getUniqueID());
            BlockHandler.addCamera(placer.getUniqueID(), camera);
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        if (hasTileEntity && worldIn.getTileEntity(pos) instanceof SecurityCameraBlockEntity)
        {
            BlockHandler.removeCamera(((SecurityCameraBlockEntity) worldIn.getTileEntity(pos)).getPlacerUUID());
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
        if (hasTileEntity && worldIn.getTileEntity(pos) instanceof SecurityCameraBlockEntity)
        {
            BlockHandler.removeCamera(((SecurityCameraBlockEntity) worldIn.getTileEntity(pos)).getPlacerUUID());
        }
    }

    @Override
    public void registerModel()
    {

    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new SecurityCameraBlockEntity();
    }
}
