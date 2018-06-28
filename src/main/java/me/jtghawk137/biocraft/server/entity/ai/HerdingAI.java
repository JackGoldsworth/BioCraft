package me.jtghawk137.biocraft.server.entity.ai;

import me.jtghawk137.biocraft.server.entity.ai.base.AIType;
import me.jtghawk137.biocraft.server.entity.ai.base.AdvancedAIBase;
import net.minecraft.entity.EntityCreature;

public class HerdingAI extends AdvancedAIBase
{
    public HerdingAI(EntityCreature entity)
    {
        super(entity, AIType.MOVEMENT, 2);
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
