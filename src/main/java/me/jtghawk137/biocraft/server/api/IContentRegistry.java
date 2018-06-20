package me.jtghawk137.biocraft.server.api;

public interface IContentRegistry
{
    String getName();

    Class getContentClass();

    void registerModel();
}
