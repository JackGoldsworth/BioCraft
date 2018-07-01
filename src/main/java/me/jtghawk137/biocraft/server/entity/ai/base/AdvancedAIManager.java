package me.jtghawk137.biocraft.server.entity.ai.base;

import net.minecraft.entity.EntityCreature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvancedAIManager
{

    private EntityCreature entity;
    private List<AdvancedAIBase> currentAI;
    private List<AdvancedAIBase> aiList;

    public AdvancedAIManager(EntityCreature entity)
    {
        currentAI = new ArrayList<>();
        aiList = new ArrayList<>();
        this.entity = entity;
    }

    public void update()
    {
        //TODO: REDO
    }

    public boolean isConcurrent(AdvancedAIBase task1, AdvancedAIBase task2)
    {
        return task1.getMutex() == task2.getMutex();
    }

    public void addAI(AdvancedAIBase ai)
    {
        this.aiList.add(ai);
    }

    public void removeAI(AdvancedAIBase ai)
    {
        this.aiList.remove(ai);
    }

    public void sortAI()
    {
        aiList.sort(Comparator.comparing(AdvancedAIBase::getImportance).reversed());
    }

    public EntityCreature getEntity()
    {
        return entity;
    }

    public List<AdvancedAIBase> getCurrentAI()
    {
        return currentAI;
    }

    public void addCurrentAI(AdvancedAIBase newAI)
    {
        currentAI.add(newAI);
    }
}
