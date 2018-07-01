package me.jtghawk137.biocraft.server.block.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class SecurityCameraBlockEntity extends TileEntity
{

    private UUID uuid;

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        int metadata = getBlockMetadata();
        return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag)
    {
        this.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound getTileData()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        if (uuid != null)
        {
            compound.setUniqueId("uuid", uuid);
        }
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        if (uuid != null)
        {
            this.uuid = compound.getUniqueId("uuid");
        }
        super.readFromNBT(compound);
    }

    public void setPlacerUUID(UUID uuid)
    {
        this.uuid = uuid;
    }

    public UUID getPlacerUUID()
    {
        return uuid;
    }
}
