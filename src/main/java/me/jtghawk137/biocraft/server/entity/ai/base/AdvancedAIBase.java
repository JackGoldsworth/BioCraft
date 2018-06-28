package me.jtghawk137.biocraft.server.entity.ai.base;

import me.jtghawk137.biocraft.server.entity.AnimalEntity;
import me.jtghawk137.biocraft.server.util.MathUtils;
import net.minecraft.entity.EntityCreature;

public abstract class AdvancedAIBase
{

    private EntityCreature entity;
    private boolean isFinished;
    private float importanceWeight;
    private AIType type;
    private int mutex;

    public AdvancedAIBase(EntityCreature entity)
    {
        this(entity, AIType.MOVEMENT, 1);
    }

    public AdvancedAIBase(EntityCreature entity, AIType type, int mutex)
    {
        this.entity = entity;
        this.mutex = mutex;
        this.type = type;
    }

    public abstract boolean shouldExecute();

    public abstract void execute();

    public abstract boolean shouldContinue();

    public float getImportance()
    {
        return MathUtils.sigmoid(importanceWeight * type.getImportance());
    }

    public float getImportanceWeight()
    {
        return importanceWeight;
    }

    public void setImportanceWeight(float importanceWeight)
    {
        this.importanceWeight = importanceWeight;
    }

    public boolean isFinished()
    {
        return isFinished;
    }

    public void setFinished(boolean finished)
    {
        isFinished = finished;
        if (entity instanceof AnimalEntity)
        {
            ((AnimalEntity) entity).getAIManager().sortAI();
        }
    }

    public EntityCreature getEntity()
    {
        return entity;
    }

    public void setType(AIType type)
    {
        this.type = type;
    }

    public AIType getType()
    {
        return type;
    }

    public int getMutex()
    {
        return mutex;
    }

    public void setMutex(int mutex)
    {
        this.mutex = mutex;
    }
}
