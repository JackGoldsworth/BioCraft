package me.jtghawk137.biocraft.server.entity;

import me.jtghawk137.biocraft.server.entity.ai.AttackingAI;
import net.minecraft.world.World;

public class TestEntity extends AnimalEntity
{
    public TestEntity(World worldIn)
    {
        super(worldIn);
        this.getAIManager().addAI(new AttackingAI(this));
    }
}
