/**
 * 
 */
package akkamaddi.plugins.simplecthon;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import akkamaddi.api.core.ASettings;
import alexndr.api.core.LogHelper;

/**
 * @author cyhiggin
 *
 */
public class Settings extends ASettings
{
    /** 
     * umbrella config loading routine. must be instantiated by child classes.
     * @param event
     */
    public static void createOrLoadSettings(FMLPreInitializationEvent event) 
    {
        config = GetConfig(event, "akkamaddi", "simplecthon.cfg");

        try {
            LogHelper.verboseInfo(ModInfo.ID, "Loading Settings...");
            config.load();
            genericSettings(ModInfo.ID, ModInfo.NAME);

            // Adjustable Ore Spawn Rates
            adjustOreSpawnRates();

            // Armor Stat Modification
            armorStatDefaults();
            if (enableArmorStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Armor Stat Modification enabled!");
                customizeArmorStats();
            } // end-if enableArmorStatModification

            // Block Stat Modification
            blockStatDefaults();
            if (enableBlockStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Block Stat Modification enabled!");
                customizeBlockStats();
            }

            toolStatDefaults();
            if (enableToolStatModification) {
                LogHelper.verboseInfo(ModInfo.ID,
                        "Tool Stat Modification enabled!");
                customizeToolStats();
            }
        } // end-try
        catch (Exception e) {
            LogHelper
                    .severe(ModInfo.ID,
                            "Settings failed to load correctly. The plugin may not function correctly");
        }

        finally {
            config.save();
            LogHelper.verboseInfo(ModInfo.ID, "Settings loaded successfully");
        }
        
    } // end createOrLoadSettings()

    /** 
     * loads/sets the ore generation variables.
     */
    public static void adjustOreSpawnRates() 
    {
        cthonSpawnRate = config.getInt("Cthon Ore Worldgen",
                "Cthon Spawn Rate", 4, 0, 5000,
                "Controls the spawn rate of Cthon Ore.");
        cthonVeinSize = config.getInt("Cthon Ore Worldgen",
                "Cthon Vein Size", 4, 0, 5000,
                "Controls the max vein size of Cthon Ore.");
        cthonMaxSpawnHeight = config.getInt("Cthon Ore Worldgen",
                "Cthon Maximum Spawn Height", 255, 0, 255,
                "Controls the max spawn height of Cthon Ore.");
        cthonMinSpawnHeight = config.getInt("Cthon Ore Worldgen",
                "Cthon Minimum Spawn Height", 0, 0, 255,
                "Controls the min spawn height of Cthon Ore.");
       
    } // end adjustOreSpawnRates

    /**
     * Sets the default armor stats.
     */
    public static void armorStatDefaults() 
    {
        cthonArmorDurability = 66;
        cthonArmorDamageReduction = new int[] {  5, 9, 8, 5 };
        cthonArmorEnchantability = 2;
       
    } // end armorStatDefaults
    
    /**
     * sets customized armor stats.
     */
    public static void customizeArmorStats() 
    {
        cthonArmorDurability = config.getInt("Cthon Armor Durability",
                "Armor Stat Modification", cthonArmorDurability, 0, 255,
                "Controls the durability of Cthon Armor.");
        cthonArmorDamageReduction = config.get("Armor Stat Modification",
                "Cthon Armor Damage Reduction Array",
                cthonArmorDamageReduction).getIntList();
        cthonArmorEnchantability = config.getInt(
                "Cthon Armor Enchantability", "Armor Stat Modification", 
                cthonArmorEnchantability,
                0, 255, "Controls the enchantability of Cthon Armor.");
    } // end customizeArmorStats
    
    /**
     * Sets the default block stats.
     */
    public static void blockStatDefaults() 
    {
        cthonHardness = 16.0F;
        cthonResistance = 42.0F;
        cthonHarvestLevel = 0;
        cthonOreHardness = 14.0F;
        cthonOreResistance = 14.0F;
        cthonOreHarvestLevel = 4;
    } // end blockStatDefaults

    /**
     * sets customized block stats.
     */
    public static void customizeBlockStats() 
    {
        cthonHardness = config.getFloat("Cthon Hardness",
                "Block Stat Modification", cthonHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        cthonResistance = config.getFloat("Cthon Resistance",
                "Block Stat Modification", cthonResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        cthonHarvestLevel = config.getInt("Cthon Harvest Level",
                "Block Stat Modification", cthonHarvestLevel, 0, 255,
                "Tool level required to harvest this block");

        cthonOreHardness = config.getFloat("Cthon Ore Hardness",
                "Block Stat Modification", cthonOreHardness, 0.0F, 32000.0F,
                "How many hits to break a block");
        cthonOreResistance = config.getFloat("Cthon Ore Resistance",
                "Block Stat Modification", cthonOreResistance, 0.0F, 32000.0F,
                "Explosion Resistance");
        cthonOreHarvestLevel = config.getInt("Cthon Ore Harvest Level",
                "Block Stat Modification", cthonOreHarvestLevel, 0, 255,
                "Tool level required to harvest this block");
        
    } // end customizeBlockStats
    
    /**
     * Sets the default tool stats.
     */
    public static void toolStatDefaults() 
    {
        cthonMiningLevel = 5;
        cthonUsesNum = 4350;
        cthonMiningSpeed = 22.0F;
        cthonDamageVsEntity = 7.0F;
        cthonEnchantability = 2;
        
    } // end toolStatDefaults

    /**
     * set customized tool stats.
     */
    public static void customizeToolStats() 
    {
        cthonMiningLevel = config
                .getInt("Cthon Mining Level",
                        "Tool Stat Modification",
                        cthonMiningLevel,
                        0,
                        255,
                        "Controls the mining level of Cthon Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
        cthonUsesNum = config.getInt("Cthon Tools Durability",
                "Tool Stat Modification", cthonUsesNum, 0, 32000,
                "Controls the number of uses Cthon Tools have.");
        cthonMiningSpeed = config
                .getFloat("Cthon Mining Speed", "Tool Stat Modification",
                        cthonMiningSpeed, 0, 32000,
                        "Controls the speed at which Cthon Tools harvest their appropriate blocks.");
        cthonDamageVsEntity = config
                .getFloat("Cthon Damage Vs. Entities",
                        "Tool Stat Modification", cthonDamageVsEntity, 0, 32000,
                        "Controls the amount of damage that Cthon Tools will do to entities.");
        cthonEnchantability = config.getInt("Cthon Tools Enchantability",
                "Tool Stat Modification", cthonEnchantability, 0, 32000,
                "Controls the enchantability of Cthon Tools.");
    } // end customizeToolStats
    
    // spawning
    public static int cthonSpawnRate;
    public static int cthonVeinSize;
    public static int cthonMaxSpawnHeight, cthonMinSpawnHeight;

    // Tool Stats
    public static int cthonMiningLevel;
    public static int cthonUsesNum;
    public static float cthonMiningSpeed;
    public static float cthonDamageVsEntity;
    public static int cthonEnchantability;

    // Block stats
    public static float cthonHardness, cthonOreHardness;
    public static float cthonResistance, cthonOreResistance;
    public static int cthonHarvestLevel, cthonOreHarvestLevel;
    
    // Armor Stats
    public static int cthonArmorDurability;
    public static int[] cthonArmorDamageReduction;
    public static int cthonArmorEnchantability;

} // end class Settings
