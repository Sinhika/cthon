package mod.akkamaddi.cthon.config;

import mod.akkamaddi.cthon.Cthon;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    // general
    final ForgeConfigSpec.BooleanValue serverAddChestLoot;
    final ForgeConfigSpec.BooleanValue serverEnableRecycling;
    
    // ore generation
    final ForgeConfigSpec.IntValue serverCthonOreVeinSize;
    final ForgeConfigSpec.IntValue serverCthonOreVeinCount;
    final ForgeConfigSpec.IntValue serverCthonOreBottomHeight;
    final ForgeConfigSpec.IntValue serverCthonOreMaxHeight;
    
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
        builder.push("Ore Generation");
        serverCthonOreVeinSize = builder.comment("Cthon ore vein size")
                .translation(Cthon.MODID + "config.CthonOreVeinSize")
                .defineInRange("CthonOreVeinSize",  4, 1, Integer.MAX_VALUE);
        serverCthonOreVeinCount = builder.comment("Cthon ore vein count per chunk")
                .translation(Cthon.MODID + "config.CthonOreVeinCount")
                .defineInRange("CthonOreVeinCount",  4, 1, Integer.MAX_VALUE);
        serverCthonOreBottomHeight = builder
                .comment("Cthon ore minimum height")
                .translation(Cthon.MODID + ".config.serverCthonOreBottomHeight")
                .defineInRange("CthonOreBottomHeight", 1, 1, 127);
        serverCthonOreMaxHeight = builder
                .comment("Cthon ore maximum height")
                .translation(Cthon.MODID + ".config.serverCthonOreMaxHeight")
                .defineInRange("CthonOreMaxHeight", 128, 1, 128);
        builder.pop();
        // TODO
    } // end ctor()
    
} // end class
