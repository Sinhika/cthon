/**
 * 
 */
package mod.akkamaddi.cthon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.cthon.config.ConfigHolder;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.akkamaddi.cthon.init.ModCreativeTabs;
import mod.akkamaddi.cthon.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Main class for mod.
 * @author Sinhika
 *  
 */
@Mod(Cthon.MODID)
public class Cthon
{
    public static final String MODID = "cthon";
    
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    public Cthon()
    {
        LOGGER.debug("Hello from akkamaddi's Simple Cthon!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        
        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
        
    } // end ctor
} // end class
