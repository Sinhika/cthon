package mod.akkamaddi.cthon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.cthon.config.CthonConfig;
import mod.akkamaddi.cthon.generation.OreGeneration;
import mod.akkamaddi.cthon.loot.CthonInjectionLookup;
import mod.alexndr.simplecorelib.helpers.LootUtils;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cthon.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(Cthon.MODID + " Forge Event Subscriber");
    private static final CthonInjectionLookup lootLookupMap = new CthonInjectionLookup();
    
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (CthonConfig.addChestLoot)
        {
            LootUtils.LootLoadHandler(Cthon.MODID, event, lootLookupMap);
        } // end-if config allows
    } // end LootLoad()
    
    
    /**
     * Biome loading triggers ore generation.
     */
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent evt)
    {
        if (evt.getCategory() == Biome.Category.NETHER) 
        {
            OreGeneration.generateNetherOres(evt);
        }
    } // end onBiomeLoading()
    

} // end class
