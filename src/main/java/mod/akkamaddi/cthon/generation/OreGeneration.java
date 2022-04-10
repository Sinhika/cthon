package mod.akkamaddi.cthon.generation;

import java.util.List;

import mod.akkamaddi.cthon.config.CthonConfig;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation masterclass for Cthon
 * @author Sinhika
 *
 */
public class OreGeneration
{
    public static final List<OreConfiguration.TargetBlockState> ORE_CTHON_TARGET = 
            OreGenUtils.BuildNetherOreTargetList(ModBlocks.cthon_ore.get(), true);
    public static ConfiguredFeature<OreConfiguration, ?> ORE_CTHON;
    public static PlacedFeature CTHON_VEIN;
    
    /**
    * initialize nether Features.
    */
   public static void initNetherFeatures()
   {
       ORE_CTHON = FeatureUtils.register("ore_cthon",
               OreGenUtils.ConfigureOreFeature(ORE_CTHON_TARGET, CthonConfig.cthon_cfg.getVein_size(), 0.0F)); 
       CTHON_VEIN = PlacementUtils.register("cthon_vein", 
               OreGenUtils.ConfigurePlacedFeature( CthonConfig.cthon_cfg, ORE_CTHON));
   }
   
   /** 
    * generate nether ores.
    */
   public static void generateNetherOres(BiomeLoadingEvent evt)
   {
       evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.CTHON_VEIN);
   }
} // end class
