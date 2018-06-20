package me.jtghawk137.biocraft.server.entity;

import me.jtghawk137.biocraft.server.animals.Animal;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class AnimalEntity extends EntityCreature
{

    private Animal animal;

    public AnimalEntity(World worldIn)
    {
        super(worldIn);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }
}
