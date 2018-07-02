package me.jtghawk137.biocraft.server.block;

import me.jtghawk137.biocraft.BioCraft;
import me.jtghawk137.biocraft.server.block.entity.AirCompressorBlockEntity;
import me.jtghawk137.biocraft.server.block.entity.SecurityCameraBlockEntity;
import me.jtghawk137.biocraft.server.block.machine.AirCompressorBlock;
import me.jtghawk137.biocraft.server.block.machine.SecurityCameraBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.*;

@Mod.EventBusSubscriber
public class BlockHandler
{

    public static final OreBlock COPPER_ORE = new OreBlock("Copper Ore");
    public static final OreBlock NICKEL_ORE = new OreBlock("Nickel Ore");
    public static final OreBlock LEAD_ORE = new OreBlock("Lead Ore");
    public static final OreBlock TIN_ORE = new OreBlock("Tin Ore");
    public static final OreBlock ALUMINIUM_ORE = new OreBlock("Aluminium Ore");
    public static final OreBlock SILVER_ORE = new OreBlock("Silver Ore");
    public static final OreBlock PLATINUM_ORE = new OreBlock("Platinum Ore");
    public static final AirCompressorBlock AIR_COMPRESSOR = new AirCompressorBlock("Air Compressor");
    public static final SecurityCameraBlock SECURITY_CAMERA = new SecurityCameraBlock("Security Camera");


    private static List<Block> blocks = new ArrayList<>();
    private static Map<UUID, List<SecurityCameraBlockEntity>> cameras = new HashMap<>();

    public static void init()
    {
        blocks.add(COPPER_ORE);
        blocks.add(NICKEL_ORE);
        blocks.add(LEAD_ORE);
        blocks.add(TIN_ORE);
        blocks.add(ALUMINIUM_ORE);
        blocks.add(SILVER_ORE);
        blocks.add(PLATINUM_ORE);
        blocks.add(AIR_COMPRESSOR);
        blocks.add(SECURITY_CAMERA);
    }

    private static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(AirCompressorBlockEntity.class, BioCraft.MODID + ":aircompressor");
        GameRegistry.registerTileEntity(SecurityCameraBlockEntity.class, BioCraft.MODID + ":securitycamera");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(blocks.toArray(new Block[blocks.size()]));
        registerTileEntities();
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        for (Block block : blocks)
        {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
    }

    public static List<Block> getBlocks()
    {
        return blocks;
    }

    public static Map<UUID, List<SecurityCameraBlockEntity>> getCameras()
    {
        return cameras;
    }

    public static List<SecurityCameraBlockEntity> getCamerasForUUID(UUID uuid)
    {
        return cameras.get(uuid) != null ? cameras.get(uuid) : cameras.put(uuid, new ArrayList<>());
    }

    public static void addCamera(UUID uuid, SecurityCameraBlockEntity camera)
    {
        if (cameras.get(uuid) != null)
        {
            cameras.get(uuid).add(camera);
        } else
        {
            cameras.put(uuid, new ArrayList<>());
            cameras.get(uuid).add(camera);
        }
    }

    public static void removeCamera(UUID uuid, SecurityCameraBlockEntity camera)
    {
        cameras.get(uuid).remove(camera);
    }
}