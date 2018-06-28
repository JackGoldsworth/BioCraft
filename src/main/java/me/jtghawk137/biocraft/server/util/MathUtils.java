package me.jtghawk137.biocraft.server.util;

public class MathUtils
{

    public static float sigmoid(float x)
    {
        return (float) (1 / (1 + Math.exp(-x)));
    }
}
