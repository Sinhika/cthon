package akkamaddi.cthon.core;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;

//import alexndr.SimpleOres.core.handlers.GenNetherrack;
import alexndr.SimpleOres.api.helpers.WorldGenHelper;

public class SimpleCthonGenerator implements IWorldGenerator
{
    /**
    * Generates the ores in the world. Depending on which 'world' the player is in (ie. Nether or Surface), different methods are called.
    * These two methods are generateSurface and generateNether, which are below.
    */

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    /**
     * Sets the details for how the blocks should spawn on the surface world.
     *
     * Configurable options are spawn rate, spawn height, vein size, and the block which spawns.
     * Lowest and highest spawn heights can be set.
     *
     *
     * WorldGenMinable determines which block the ores generate in.
     *
     * WorldGenMinable will generate in stone, ie. for surface ores.
     */
    private void generateNether(World world, Random rand, int baseX, int baseZ)
    {
        for (int i = 0; i < SimpleCthonCore.cthonSpawnRate; i++)
        {
            int randPosX = baseX + rand.nextInt(16);
            int randPosY = rand.nextInt(SimpleCthonCore.cthonSpawnHeight);
            int randPosZ = baseZ + rand.nextInt(16);
            new WorldGenHelper(SimpleCthonCore.oreCthon.blockID, SimpleCthonCore.cthonVeinSize, Block.netherrack).generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }
}
