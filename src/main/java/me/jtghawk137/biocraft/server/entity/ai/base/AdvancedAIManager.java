package me.jtghawk137.biocraft.server.entity.ai.base;

import net.minecraft.entity.EntityCreature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvancedAIManager
{

    private EntityCreature entity;
    private AdvancedAIBase currentAI;
    private List<AdvancedAIBase> ai = new ArrayList<>();

    public AdvancedAIManager(EntityCreature entity)
    {
        this.entity = entity;
    }

    public void addAI(AdvancedAIBase ai)
    {
        this.ai.add(ai);
    }

    public void removeAI(AdvancedAIBase ai)
    {
        this.ai.remove(ai);
    }

    public void sortAI()
    {
        ai.sort(Comparator.comparing(AdvancedAIBase::getImportance).reversed());
    }

    public EntityCreature getEntity()
    {
        return entity;
    }

    public AdvancedAIBase getCurrentAI()
    {
        return currentAI;
    }

    public void setCurrentAI(AdvancedAIBase currentAI)
    {
        this.currentAI = currentAI;
    }
}
