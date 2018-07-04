package me.jtghawk137.biocraft.server.entity.ai.base;

public enum AIType
{
    MOVEMENT(1, 0),
    METABOLISM(2, 1),
    ATTACK(3, 3);

    private int importance;
    private int mutex;

    AIType(int importance, int mutex)
    {
        this.importance = importance;
        this.mutex = mutex;
    }

    public int getImportance()
    {
        return importance;
    }

    public int getMutex()
    {
        return mutex;
    }
}
