package me.jtghawk137.biocraft.server.block.machine;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.gui.GuiHandler;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.api.IContentRegistry;
import me.jtghawk137.biocraft.server.block.OrientedBlock;
import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

public class AirCompressorBlock extends OrientedBlock implements IContentRegistry
{

    public AirCompressorBlock(String name)
    {
        super(name, Material.ANVIL);
        this.setCreativeTab(CreativeTabs.MATERIALS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote) {
            playerIn.openGui(BioCraft.instance, GuiHandler.GUI_AIR_COMPRESSOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if(tileEntity instanceof AirCompressorBlockEntity) {
            IItemHandler item = ((AirCompressorBlockEntity)tileEntity).getInventory();
            for (int i = 0; i < item.getSlots(); i++) {
                ItemStack stack = item.getStackInSlot(i);
                InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
            }
        }
        super.breakBlock(worldIn, pos, state);
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
        RenderHandler.INSTANCE.registerItemRenderer(Item.getItemFromBlock(this), 0, formattedName);
    }
}
