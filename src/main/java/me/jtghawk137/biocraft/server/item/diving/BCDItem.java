package me.jtghawk137.biocraft.server.item.diving;

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

public class BCDItem extends ArmorItem
{
    public BCDItem(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String name)
    {
        super(materialIn, equipmentSlotIn, name);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected)
    {
        NBTTagCompound tag = getNBT(stack);
        if (!tag.hasKey("oxygen"))
            tag.setInteger("oxygen", 100);
        if (!(entityIn instanceof EntityPlayer))
            return;
        EntityPlayer player = (EntityPlayer) entityIn;
        if (player.isInWater() && player.inventory.armorInventory.contains(stack))
        {
            int oxygen = tag.getInteger("oxygen");
            if (entityIn.ticksExisted % 40 == 0 && oxygen > 0 && !player.isCreative())
            {
                oxygen--;
                tag.setInteger("oxygen", oxygen);
                System.out.println(oxygen);
            }
        }
    }

    private NBTTagCompound getNBT(ItemStack stack)
    {
        NBTTagCompound nbt;
        if (stack.hasTagCompound())
            nbt = stack.getTagCompound();
        else
            nbt = new NBTTagCompound();
        stack.setTagCompound(nbt);
        return nbt;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        int oxygen = getNBT(stack).getInteger("oxygen");
        tooltip.add("Oxygen Level: " + oxygen + "%");
    }

    public int getOxygen(ItemStack stack)
    {
        return getNBT(stack).getInteger("oxygen");
    }
}
