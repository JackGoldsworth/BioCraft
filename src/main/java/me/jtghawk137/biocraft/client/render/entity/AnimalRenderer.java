package me.jtghawk137.biocraft.client.render.entity;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.entity.AnimalEntity;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class AnimalRenderer extends RenderLiving<AnimalEntity>
{

    private ResourceLocation mobTexture = new ResourceLocation(BioCraft.MODID, "textures/entity/test.png");

    public static final Factory FACTORY = new Factory();

    public AnimalRenderer(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AnimalEntity entity)
    {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<AnimalEntity>
    {

        @Override
        public Render<? super AnimalEntity> createRenderFor(RenderManager manager)
        {
            return new AnimalRenderer(manager);
        }

    }

}