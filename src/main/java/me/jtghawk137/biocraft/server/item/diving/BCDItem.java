package me.jtghawk137.biocraft.server.item.diving;

import me.jtghawk137.biocraft.server.api.ICompressibleItem;
import me.jtghawk137.biocraft.server.item.ArmorItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BCDItem extends ArmorItem implements ICompressibleItem
{
    public BCDItem(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String name)
    {
        super(materialIn, equipmentSlotIn, name);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if (entityIn instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityIn;
            if (player.isInWater() && player.inventory.armorInventory.contains(stack))
            {
                NBTTagCompound tag = getNBT(stack);
                int oxygen = tag.getInteger("air");
                if (entityIn.ticksExisted % 40 == 0 && oxygen > 0 && !player.isCreative())
                {
                    oxygen--;
                    tag.setInteger("air", oxygen);
                }
            }
        }
    }

    private NBTTagCompound getNBT(ItemStack stack)
    {
        return stack.getOrCreateSubCompound("biocraft");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Air Level: " + getAir(stack) + "%");
    }

    public int getAir(ItemStack stack)
    {
        return getNBT(stack).getInteger("air");
    }

    @Override
    public boolean isCompressible(ItemStack stack)
    {
        return getAir(stack) < 100;
    }

    @Override
    public ItemStack getCompressedOutput(ItemStack stack)
    {
        ItemStack output = stack.splitStack(1);
        output.getOrCreateSubCompound("biocraft").setInteger("air", 100);
        return output;
    }
}
