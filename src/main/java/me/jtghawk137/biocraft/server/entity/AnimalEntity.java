package me.jtghawk137.biocraft.server.entity;

import io.netty.buffer.ByteBuf;
import me.jtghawk137.biocraft.server.animals.Animal;
import me.jtghawk137.biocraft.server.entity.ai.base.AdvancedAIManager;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class AnimalEntity extends EntityCreature implements IEntityAdditionalSpawnData
{

    private Animal animal;
    private AdvancedAIManager aiManager;

    public AnimalEntity(World worldIn)
    {
        super(worldIn);
        aiManager = new AdvancedAIManager(this);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        aiManager.update();
    }

    public AdvancedAIManager getAIManager()
    {
        return aiManager;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {

    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {

    }
}
