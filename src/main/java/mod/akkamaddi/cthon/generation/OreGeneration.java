package mod.akkamaddi.cthon.generation;

import mod.akkamaddi.cthon.init.ModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for Cthon
 * @author Sinhika
 *
 */
public class OreGeneration
{
   /** 
    * generate nether ores.
    */
   public static void generateNetherOres(BiomeLoadingEvent evt)
   {
       evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.CTHON_VEIN.getHolder().get());
   }
} // end class
