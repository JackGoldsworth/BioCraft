package me.jtghawk137.biocraft.server.event;

import me.jtghawk137.biocraft.server.item.ItemHandler;
import me.jtghawk137.biocraft.server.item.diving.BCDItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ServerEventHandler
{

    @SubscribeEvent
    public void onHurt(LivingAttackEvent event)
    {
        if (event.getSource().equals(DamageSource.DROWN))
        {
            if (event.getEntity() instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) event.getEntity();
                if (player.inventory.armorItemInSlot(2).getItem() == ItemHandler.BCD_ITEM)
                {
                    ItemStack stack = player.inventory.armorItemInSlot(2);
                    if (((BCDItem) stack.getItem()).getAir(stack) > 0)
                        event.setCanceled(true);
                }
            }
        }
    }
}
