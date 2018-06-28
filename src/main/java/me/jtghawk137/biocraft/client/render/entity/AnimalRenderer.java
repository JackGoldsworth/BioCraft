package me.jtghawk137.biocraft.client.render.entity;

import me.jtghawk137.biocraft.server.entity.AnimalEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class AnimalRenderer extends RenderLiving<AnimalEntity>
{

    public AnimalRenderer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn)
    {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(AnimalEntity entity)
    {
        return null;
    }
}
