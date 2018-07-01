package me.jtghawk137.biocraft.server.entity.ai;

import me.jtghawk137.biocraft.server.entity.ai.base.AIType;
import me.jtghawk137.biocraft.server.entity.ai.base.AdvancedAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.AxisAlignedBB;

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
        return true;
    }

    @Override
    public void execute()
    {
        if (!entity.world.getEntitiesWithinAABBExcludingEntity(entity, new AxisAlignedBB(entity.getPosition())).isEmpty())
        {
            target = (EntityLiving) entity.world.getEntitiesWithinAABBExcludingEntity(entity, new AxisAlignedBB(entity.getPosition())).get(0);
            setImportanceWeight(.3f);
            entity.attackEntityAsMob(target);
        }
        setFinished(true);
    }

    @Override
    public boolean shouldContinue()
    {
        return false;
    }
}
