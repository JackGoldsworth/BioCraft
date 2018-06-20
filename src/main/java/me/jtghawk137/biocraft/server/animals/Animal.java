package me.jtghawk137.biocraft.server.animals;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.util.Utils;
import net.ilexiconn.llibrary.client.model.tabula.TabulaModelHandler;
import net.ilexiconn.llibrary.client.model.tabula.container.TabulaModelContainer;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is supposed to be an info class for each Animal
 */
public class Animal
{

    private Class<? extends EntityAnimal> entityClass;
    private String name;
    private int age;
    private int maxAge;
    private boolean isMale;
    private boolean isAquatic;

    private TabulaModelContainer adultModel;
    private Map<String, Map<Boolean, ResourceLocation>> overlays = new HashMap<>();

    private Biome[] spawnBiomes;

    protected TabulaModelContainer parseModel()
    {
        String formattedName = Utils.formatString(this.getName());
        String modelPath = "/assets/biocraft/models/entity/" + formattedName + "/" + formattedName;
        try
        {
            return TabulaModelHandler.INSTANCE.loadTabulaModel(modelPath);
        } catch (Exception e)
        {
            BioCraft.logger.fatal("Couldn't load model " + modelPath, e);
        }

        return null;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setEntityClass(Class<? extends EntityAnimal> entityClass)
    {
        this.entityClass = entityClass;
    }

    public Class<? extends EntityAnimal> getEntityClass()
    {
        return entityClass;
    }

    public int getAge()
    {
        return age;
    }

    public void setMaxAge(int maxAge)
    {
        this.maxAge = maxAge;
    }

    public int getMaxAge()
    {
        return maxAge;
    }

    public void setMale(boolean male)
    {
        this.isMale = male;
    }

    public boolean isMale()
    {
        return isMale;
    }

    public void setAquatic(boolean isAquatic)
    {
        this.isAquatic = isAquatic;
    }

    public boolean isAquatic()
    {
        return isAquatic;
    }
}
