package me.jtghawk137.biocraft.server.item;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.client.render.RenderHandler;
import me.jtghawk137.biocraft.server.api.ContentRegistry;
import me.jtghawk137.biocraft.server.tab.TabHandler;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorItem extends ItemArmor implements ContentRegistry
{

    protected String name;
    protected String formattedName;

    public ArmorItem(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String name)
    {
        super(materialIn, 0, equipmentSlotIn);
        this.name = name;
        this.setCreativeTab(TabHandler.ITEMS);
        formattedName = Utils.formatString(name);
        this.setUnlocalizedName(formattedName);
        this.setRegistryName(BioCraft.MODID, formattedName);
    }

    @Override
    public String getName()
    {
        return name;
    }


    @Override
    public void registerModel()
    {
        RenderHandler.INSTANCE.registerItemRenderer(this, 0, formattedName);
    }
}
