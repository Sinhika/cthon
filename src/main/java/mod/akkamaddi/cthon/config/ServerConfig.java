package mod.akkamaddi.cthon.config;

import mod.akkamaddi.cthon.Cthon;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    // general
    final ForgeConfigSpec.BooleanValue serverAddChestLoot;
    final ForgeConfigSpec.BooleanValue serverEnableRecycling;
    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverAddChestLoot = builder.comment("Allow Cthon loot to be added to chests?")
                .translation(Cthon.MODID + ".config.addChestLoot")
                .define("AddChestLoot", true);
        serverEnableRecycling = 
                builder.comment("Enable fusion furnace recycling of mod items")
                .translation(Cthon.MODID + "config.EnableRecycling")
                .define("EnableRecycling", true);
        builder.pop();
    } // end ctor()
    
} // end class
