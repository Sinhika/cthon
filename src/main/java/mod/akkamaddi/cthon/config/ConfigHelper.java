package mod.akkamaddi.cthon.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        CthonConfig.addChestLoot = ConfigHolder.SERVER.serverAddChestLoot.get();
        
        CthonConfig.cthon_cfg = new ModOreConfig(
                new RangeDecoratorConfiguration(ConfigHolder.SERVER.serverCthonOreBottomHeight.get(), 0, 
                                        ConfigHolder.SERVER.serverCthonOreMaxHeight.get()),
                ConfigHolder.SERVER.serverCthonOreVeinSize.get(),
                ConfigHolder.SERVER.serverCthonOreVeinCount.get());
        
        // recipe flags.
        CthonConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
    } // end bakeServer()

} // end class
