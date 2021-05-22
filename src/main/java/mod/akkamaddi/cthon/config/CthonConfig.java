package mod.akkamaddi.cthon.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simplecorelib.config.ISimpleConfig;
import mod.alexndr.simplecorelib.config.ModOreConfig;

/**
 * Post SimpleCoreLib 2.0.7.5, will need to remove deprecated items since they will
 * be default functions in ISimpleConfig.
 * @author cyhiggin
 *
 */
public class CthonConfig implements ISimpleConfig
{
    // recipe flags
    @Deprecated
    private static Map<String, Boolean> flags = new HashMap<>();
    
    // other variables.
    public static CthonConfig INSTANCE = new CthonConfig();
    public static boolean addChestLoot;

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static ModOreConfig cthon_cfg;
    
    @Override
    @Deprecated
    public void clear()
    {
        flags.clear();
    }

    @Override
    @Deprecated
    public boolean getFlag(String n)
    {
        Boolean obj = flags.get(n);
        return obj != null && obj;
    }

    @Override
    @Deprecated
    public void putFlag(String n, boolean val)
    {
        flags.put(n, val);
    }
} // end class
