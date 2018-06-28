package me.jtghawk137.biocraft.server.entity;

import me.jtghawk137.biocraft.server.animals.Animal;
import me.jtghawk137.biocraft.server.entity.ai.base.AdvancedAIManager;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class AnimalEntity extends EntityCreature
{

    private Animal animal;
    private AdvancedAIManager aiManager;

    public AnimalEntity(World worldIn)
    {
        super(worldIn);
        aiManager = new AdvancedAIManager(this);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        aiManager.update();
    }

    public AdvancedAIManager getAIManager()
    {
        return aiManager;
    }
}
