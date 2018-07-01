package me.jtghawk137.biocraft.server.entity;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.animals.Animal;
import me.jtghawk137.biocraft.server.animals.TestAnimal;
import me.jtghawk137.biocraft.server.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;
import java.util.List;

public class EntityHandler
{

    public static final Animal test = new TestAnimal();

    private static int entityId = 0;
    private static List<Animal> animals = new ArrayList<>();

    public static void init()
    {
        animals.add(test);

        for (Animal animal : animals)
        {
            registerAnimal(animal.getEntityClass(), animal.getName());
        }
    }

    private static void registerAnimal(Class<? extends Entity> entity, String name)
    {
        String formattedName = Utils.formatString(name);
        ResourceLocation registryName = new ResourceLocation("biocraft:entities." + formattedName);
        EntityRegistry.registerModEntity(registryName, entity, formattedName, entityId++, BioCraft.instance, 1024, 1, true);
    }

    public static List<Animal> getAnimals()
    {
        return animals;
    }
}
