package mod.akkamaddi.cthon.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        CthonConfig.addChestLoot = ConfigHolder.SERVER.serverAddChestLoot.get();
        
        // recipe flags.
        CthonConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
    } // end bakeServer()

} // end class
