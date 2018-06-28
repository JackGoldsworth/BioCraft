package me.jtghawk137.biocraft.server.entity.ai.base;

public enum AIType
{
    MOVEMENT(1),
    METABOLISM(2),
    ATTACK(3);

    private int importance;

    AIType(int importance)
    {
        this.importance = importance;
    }

    public int getImportance()
    {
        return importance;
    }
}
