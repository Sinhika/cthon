package mod.akkamaddi.cthon.generation;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.config.CthonConfig;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for Cthon
 * @author Sinhika
 *
 */
public class OreGeneration
{
    public static ConfiguredFeature<?, ?> ORE_CTHON;
    
    /**
    * initialize nether Features.
    */
   public static void initNetherFeatures()
   {
       ORE_CTHON = OreGenUtils.buildNetherOreFeature(Feature.ORE,
               ModBlocks.cthon_ore.get().defaultBlockState(), CthonConfig.cthon_cfg);
       OreGenUtils.registerFeature(Cthon.MODID, "cthon_ore_vein", ORE_CTHON);
   }
   
   /** 
    * generate nether ores.
    */
   public static void generateNetherOres(BiomeLoadingEvent evt)
   {
       evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_CTHON);
   }
} // end class
