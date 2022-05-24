package mod.akkamaddi.cthon.config;

import mod.alexndr.simplecorelib.api.config.ModOreConfig;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.common.util.Lazy;

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
    public static Lazy<ModOreConfig> cthon_cfg = Lazy.of( 
            ()->new ModOreConfig(ModOreConfig.FULL_RANGE, ConfigHolder.SERVER.serverCthonOreVeinSize.get(),
            ConfigHolder.SERVER.serverCthonOreVeinCount.get(), true,
            VerticalAnchor.absolute(ConfigHolder.SERVER.serverCthonOreBottomHeight.get()), 
            VerticalAnchor.absolute(ConfigHolder.SERVER.serverCthonOreMaxHeight.get())));
} // end class
