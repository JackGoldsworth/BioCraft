package me.jtghawk137.biocraft.server.block;

import me.jtghawk137.biocraft.server.api.IContentRegistry;
import me.jtghawk137.biocraft.server.tab.TabHandler;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class OrientedBlock extends BlockContainer implements IContentRegistry
{

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected String name;
    protected String formattedName;

    public OrientedBlock(String name, Material material)
    {
        super(material);
        formattedName = Utils.formatString(name);
        this.name = name;
        this.setCreativeTab(TabHandler.BLOCKS);
        this.setRegistryName(formattedName);
        this.setUnlocalizedName(formattedName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState east = worldIn.getBlockState(pos.east());
            IBlockState west = worldIn.getBlockState(pos.west());
            EnumFacing facing = state.getValue(FACING);

            if (facing == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock())
                facing = EnumFacing.SOUTH;
            else if (facing == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock())
                facing = EnumFacing.NORTH;
            else if (facing == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock())
                facing = EnumFacing.EAST;
            else if (facing == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock())
                facing = EnumFacing.WEST;

            worldIn.setBlockState(pos, state.withProperty(FACING, facing), 2);
        }
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()));
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    public BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return true;
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState();
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
}
