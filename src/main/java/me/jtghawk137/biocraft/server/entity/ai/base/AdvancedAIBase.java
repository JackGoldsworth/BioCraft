package me.jtghawk137.biocraft.server.entity.ai.base;

import me.jtghawk137.biocraft.server.util.MathUtils;
import net.minecraft.entity.EntityCreature;

public abstract class AdvancedAIBase
{

    private EntityCreature entity;
    private boolean isFinished;
    private float importanceWeight;
    private AIType type;
    private byte mutex;

    public AdvancedAIBase(EntityCreature entity, byte mutex)
    {
        this.entity = entity;
        this.mutex = mutex;
    }

    public abstract boolean shouldExcecute();

    public abstract void excecute();

    public abstract boolean continueExcecute();

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
        /*
         * entity.getAIManager().sort;
         */
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
}
