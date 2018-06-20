package me.jtghawk137.biocraft.server.item.diving;

import me.jtghawk137.biocraft.server.item.ArmorItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

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
        if (entityIn instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityIn;
            if (player.isInWater() && player.inventory.armorInventory.contains(stack))
            {
                NBTTagCompound tag = getNBT(stack);
                int oxygen = tag.getInteger("oxygen");
                if (entityIn.ticksExisted % 40 == 0 && oxygen > 0 && !player.isCreative())
                {
                    oxygen--;
                    tag.setInteger("oxygen", oxygen);
                }
            }
        }
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound tag)
    {
        if (stack.hasTagCompound())
            tag = stack.getTagCompound();
        else
            tag = new NBTTagCompound();
        stack.setTagCompound(tag);

        if (!tag.hasKey("oxygen"))
            tag.setInteger("oxygen", 100);
        return null;
    }

    private NBTTagCompound getNBT(ItemStack stack)
    {
        return stack.getTagCompound();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Oxygen Level: " + getOxygen(stack) + "%");
    }

    public int getOxygen(ItemStack stack)
    {
        return getNBT(stack).getInteger("oxygen");
    }
}
