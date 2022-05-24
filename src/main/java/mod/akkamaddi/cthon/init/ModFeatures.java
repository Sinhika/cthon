package mod.akkamaddi.cthon.init;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.config.CthonConfig;
import mod.alexndr.simplecorelib.api.helpers.OreGenUtils;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Cthon.MODID);
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_CTHON =
            CONFIGURED_FEATURES.register("ore_cthon", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.cthon_ore.get(), true),
                            CthonConfig.cthon_cfg));
    
    
    /** PlacedFeature registry */
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Cthon.MODID);

    public static RegistryObject<PlacedFeature> CTHON_VEIN = PLACED_FEATURES.register("cthon_vein", 
                    ()-> OreGenUtils.createPlacedOreFeature(ORE_CTHON.getHolder().get(), CthonConfig.cthon_cfg));

} // end class
