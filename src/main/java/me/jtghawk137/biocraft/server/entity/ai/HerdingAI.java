package me.jtghawk137.biocraft.server.entity.ai;

import me.jtghawk137.biocraft.server.entity.ai.base.AdvancedAIBase;
import net.minecraft.entity.EntityCreature;

public class HerdingAI extends AdvancedAIBase
{
    public HerdingAI(EntityCreature entity)
    {
        super(entity, (byte) 1);
    }

    @Override
    public boolean shouldExcecute()
    {
        return false;
    }

    @Override
    public void excecute()
    {

    }

    @Override
    public boolean continueExcecute()
    {
        return false;
    }
}
