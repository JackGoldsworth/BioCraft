package me.jtghawk137.biocraft.server.entity.ai;

import me.jtghawk137.biocraft.server.entity.ai.base.AIType;
import me.jtghawk137.biocraft.server.entity.ai.base.AdvancedAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;

public class AttackingAI extends AdvancedAIBase
{

    private EntityCreature entity;
    private EntityLiving target;

    public AttackingAI(EntityCreature entity)
    {
        super(entity, AIType.ATTACK, 1);
        this.entity = entity;
    }

    @Override
    public boolean shouldExecute()
    {
        return false;
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean shouldContinue()
    {
        return false;
    }
}
