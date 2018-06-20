package me.jtghawk137.biocraft.server.event;

import me.jtghawk137.biocraft.server.item.ItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
                //TODO: Find better way to do this
                if (player.inventory.armorItemInSlot(2).getUnlocalizedName().equals(ItemHandler.BCD_ITEM.getUnlocalizedName()))
                    event.setCanceled(true);
            }
        }
    }
}
