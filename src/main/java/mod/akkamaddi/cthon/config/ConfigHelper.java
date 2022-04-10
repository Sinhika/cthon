package mod.akkamaddi.cthon.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        CthonConfig.addChestLoot = ConfigHolder.SERVER.serverAddChestLoot.get();
        
        CthonConfig.cthon_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, ConfigHolder.SERVER.serverCthonOreVeinSize.get(),
                ConfigHolder.SERVER.serverCthonOreVeinCount.get(), true,
                VerticalAnchor.absolute(ConfigHolder.SERVER.serverCthonOreBottomHeight.get()), 
                VerticalAnchor.absolute(ConfigHolder.SERVER.serverCthonOreMaxHeight.get()));
        
        // recipe flags.
        CthonConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
    } // end bakeServer()

} // end class
