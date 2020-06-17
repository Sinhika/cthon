package akkamaddi.plugins.simplecthon;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.ContentTypes;
import alexndr.api.core.LogHelper;
import alexndr.api.helpers.game.OreGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
dependencies = "required-after:simplecore; required-after:simpleores ; required-after:fusion ; required-after:akkamaddicore")
public class SimpleCthon 
{
	public static SimpleTab tabAkkamaddiCthon;
	public static ToolMaterial toolCthon;
	public static ArmorMaterial armorCthon;

     /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
	
        // Tab
        LogHelper.info("Loading SimpleCthon...");
        tabAkkamaddiCthon = 
                new SimpleTab("tabAkkamaddiCthon", ContentTypes.CreativeTab.GENERAL);
        
        //Configuration
        Settings.createOrLoadSettings(event);
        
        //Content
        setToolAndArmorStats();
        Content.preInitialize();
        Recipes.preInitialize();
        Content.setLoot();

        MinecraftForge.EVENT_BUS.register(new HandlerArmor());
	} // end preInit()

    /**
     * Do your mod setup. Build whatever data structures you care about. 
     */
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
        // run tab icon call
        setTabIcons();
        setRepairMaterials();
        Recipes.initialize();
        setOreGenSettings();
	}

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("SimpleCthon loaded");
	}
	
	   /**
     * Creating the custom tabs using the API class "SimpleTab" and setting
     * their icon.
     */
    public void setTabIcons() {
        tabAkkamaddiCthon.setIcon(new ItemStack(Content.oreCthon));
    }
    
    /**
     * Sets the tool and armor stats from the Settings file.
     */
    private static void setToolAndArmorStats() 
    {
        // set tool properties
        // EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage
        // to entity, enchantability)
        toolCthon = EnumHelper.addToolMaterial("CTHON", 
                Settings.cthonMiningLevel, Settings.cthonUsesNum,
                Settings.cthonMiningSpeed, Settings.cthonDamageVsEntity,
                Settings.cthonEnchantability);

        /**
         * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by
         * pieces for their max damage), new int[] {helmet defense, chestplate
         * defense, leggings defense, boots defense}, enchantability)
         */
        armorCthon = EnumHelper.addArmorMaterial("CTHON", 
                Settings.cthonArmorDurability, Settings.cthonArmorDamageReduction,
                Settings.cthonArmorEnchantability);
   } // end setToolAndArmorStats()
    
    /**
     * Sets repair materials for the tools/armor of that type. ie. Copper Ingot to repair copper tools and armor.
     */
    private static void setRepairMaterials()
    {
        toolCthon.setRepairItem(new ItemStack(Content.cthonIngot));
        armorCthon.customCraftingMaterial = Content.cthonIngot;
    } // end setRepairMaterials()

    /**
     * Registers each ore to be generated.
     */
    private static void setOreGenSettings()
    {
        OreGenerator.INSTANCE.registerOreForGeneration(-1, Content.oreCthon,
                Blocks.netherrack, Settings.cthonVeinSize,
                Settings.cthonSpawnRate, Settings.cthonMaxSpawnHeight,
                Settings.cthonMinSpawnHeight);
    } // end setOreGenSettings()


} // end class SimpleCthon
