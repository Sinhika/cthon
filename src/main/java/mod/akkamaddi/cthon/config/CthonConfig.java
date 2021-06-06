package mod.akkamaddi.cthon.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import mod.alexndr.simplecorelib.config.SimpleConfig;

/**
 * @author cyhiggin
 *
 */
public class CthonConfig extends SimpleConfig
{
    // other variables.
    public static CthonConfig INSTANCE = new CthonConfig();
    public static boolean addChestLoot;

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static ModOreConfig cthon_cfg;
    
} // end class
