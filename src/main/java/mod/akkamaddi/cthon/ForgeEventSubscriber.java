package mod.akkamaddi.cthon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.cthon.config.CthonConfig;
import mod.akkamaddi.cthon.content.CthonArmorMaterial;
import mod.akkamaddi.cthon.generation.OreGeneration;
import mod.akkamaddi.cthon.loot.CthonInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cthon.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
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
        if (evt.getCategory() == Biome.BiomeCategory.NETHER) 
        {
            OreGeneration.generateNetherOres(evt);
        }
    } // end onBiomeLoading()
    
    /**
     * Intercept wither damage if player is wearing a full set of cthon armor.
     * @param event
     */
    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingAttackEvent(LivingAttackEvent event)
    {
        // first, is it a player?
        if (event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();
            LOGGER.debug("caught LivingAttackEvent");

            // wither damage and are they wearing full cthon armor?
            if ((event.getSource() == DamageSource.WITHER) &&
                    ArmorUtils.isPlayerWearingFullSet(player, CthonArmorMaterial.CTHON))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.debug("Canceled wither damage because of cthon armor");
            } // end-if full set of X and Y damage
        } // end-if player
    } // end onLivingHurtEvent

} // end class
