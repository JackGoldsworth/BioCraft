package me.jtghawk137.biocraft.server.animals;

import me.jtghawk137.biocraft.client.render.entity.AnimalRenderer;
import me.jtghawk137.biocraft.server.entity.TestEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class TestAnimal extends Animal
{

    public TestAnimal()
    {
        this.setAquatic(false);
        this.setEntityClass(TestEntity.class);
        this.setMale(true);
        this.setName("Test");
    }

    @Override
    public void registerModel()
    {
        RenderingRegistry.registerEntityRenderingHandler(this.getEntityClass(), AnimalRenderer.FACTORY);
    }
}
