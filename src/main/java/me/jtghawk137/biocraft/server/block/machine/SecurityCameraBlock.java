package me.jtghawk137.biocraft.server.block.machine;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.block.BlockHandler;
import me.jtghawk137.biocraft.server.block.OrientedBlock;
import me.jtghawk137.biocraft.server.block.entity.SecurityCameraBlockEntity;
import me.jtghawk137.biocraft.server.tab.TabHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            BioCraft.proxy.openCamera(playerIn);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (!worldIn.isRemote && hasTileEntity && worldIn.getTileEntity(pos) instanceof SecurityCameraBlockEntity)
        {
            SecurityCameraBlockEntity camera = (SecurityCameraBlockEntity) worldIn.getTileEntity(pos);
            camera.setPlacerUUID(placer.getUniqueID());
            BlockHandler.addCamera(placer.getUniqueID(), camera);
            System.out.println(BlockHandler.getCamerasForUUID(placer.getUniqueID()).size());
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        if (hasTileEntity && worldIn.getTileEntity(pos) instanceof SecurityCameraBlockEntity)
        {
            BlockHandler.removeCamera(((SecurityCameraBlockEntity) worldIn.getTileEntity(pos)).getPlacerUUID(), (SecurityCameraBlockEntity) worldIn.getTileEntity(pos));
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
        if (hasTileEntity && worldIn.getTileEntity(pos) instanceof SecurityCameraBlockEntity)
        {
            BlockHandler.removeCamera(((SecurityCameraBlockEntity) worldIn.getTileEntity(pos)).getPlacerUUID(), (SecurityCameraBlockEntity) worldIn.getTileEntity(pos));
        }
    }

    @Override
    public void registerModel()
    {
        RenderHandler.INSTANCE.registerItemRenderer(Item.getItemFromBlock(this), 0, formattedName);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new SecurityCameraBlockEntity();
    }
}
