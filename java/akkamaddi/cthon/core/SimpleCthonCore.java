package akkamaddi.cthon.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import akkamaddi.akkamaddiCore.api.CommonProxy;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.LootHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "simplecthon", name = "Simple Cthon", version = "1.7.10-1.3.0", 
	 dependencies = "required-after:simpleores ; required-after:required-after:fusionplugin ; required-after:akkamaddicore")

public class SimpleCthonCore {
	// The instance of your mod that Forge uses.
	@Instance("simplecthon")
	public static SimpleCthonCore instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "akkamaddi.cthon.core.ClientProxy", 
				serverSide = "akkamaddi.akkamaddiCore.CommonProxy")
	public static CommonProxy proxy;

	// set item ID, to-from config file

	// Cthon
	public static Item cthonIngot;
	public static Item cthonElutriatedChunk;
	public static Item cthonMephiticChunk;

	public static Item cthonSword;
	public static Item cthonShovel;
	public static Item cthonAxe;
	public static Item cthonPickaxe;
	public static Item cthonHoe;

	public static Item cthonHelm;
	public static Item cthonChest;
	public static Item cthonLegs;
	public static Item cthonBoots;

	// set block names
	public static Block blockCthon;
	public static Block oreCthon;

	// spawning
	public static int cthonSpawnRate;
	public static int cthonVeinSize;
	public static int cthonSpawnHeight;

	// booleans
	public static boolean enableRecycling;

	// tab
	public static SimpleTab tabAkkamaddiCthon = new SimpleTab(
			"tabAkkamaddiCthon");

	// set tool properties
	// EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage
	// to entity, enchantability)
	public static ToolMaterial toolCthon = EnumHelper.addToolMaterial(
			"CTHON", 5, 4350, 22.0F, 7, 2);

	/**
	 * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by
	 * pieces for their max damage), new int[] {helmet defense, chestplate
	 * defense, leggings defense, boots defense}, enchantability)
	 */
	public static ArmorMaterial armorCthon = EnumHelper.addArmorMaterial(
			"CTHON", 66, new int[] { 5, 9, 8, 5 }, 2);

	// Armor
	public static int rendererCthon;

	// Tab
	public void setTabIcons() {
		/**
		 * Creating the custom tabs using the API class "SimpleTab" and setting
		 * their icon.
		 */
		tabAkkamaddiCthon.setIcon(new ItemStack(SimpleCthonCore.oreCthon));
	}

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
		MinecraftForge.EVENT_BUS.register(new HandlerArmor());
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		// Adjustable Ore Spawn Rates
		cthonSpawnRate = config.get("05. Spawn Rate", "Cthon Spawn Rate", 4)
				.getInt();
		cthonVeinSize = config.get("05. Vein Size", "Cthon Vein Size", 4)
				.getInt();
		cthonSpawnHeight = config.get("05. Spawn Height", "Cthon Spawn Height",
				256).getInt();
		// Recycling
		enableRecycling = config.get(Configuration.CATEGORY_GENERAL,
				"Enable Cthon item recycling recipes: false or true?", false)
				.getBoolean(false);
		config.save();
		
		// define items
		// Cthon
		cthonIngot = new SimpleIngot().modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonIngot");
		cthonElutriatedChunk = new SimpleIngot()
				.modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonElutriatedChunk");
		cthonMephiticChunk = new SimpleIngot()
				.modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonMephiticChunk");
		cthonSword = new SimpleSword( toolCthon)
				.modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonSword");
		cthonShovel = new SimpleShovel(toolCthon)
				.modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonShovel");
		cthonAxe = new SimpleAxe(toolCthon).modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonAxe");
		cthonPickaxe = new SimplePickaxe(toolCthon)
				.modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonPickaxe");
		cthonHoe = new SimpleHoe( toolCthon).modId("simplecthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonHoe");
		cthonHelm = new SimpleArmor( armorCthon, rendererCthon, 0)
				.modId("simplecthon").setType("cthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonHelm");
		cthonChest = new SimpleArmor( armorCthon, rendererCthon, 1)
				.modId("simplecthon").setType("cthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonChest");
		cthonLegs = new SimpleArmor( armorCthon, rendererCthon, 2)
				.modId("simplecthon").setType("cthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonLegs");
		cthonBoots = new SimpleArmor( armorCthon, rendererCthon, 3)
				.modId("simplecthon").setType("cthon")
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setUnlocalizedName("cthonBoots");
		
		// define blocks
		blockCthon = new SimpleBlock( Material.iron)
				.modId("simplecthon").setHardness(16.0F).setResistance(42.0F)
				.setStepSound(Block.soundTypeMetal)
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setBlockName("blockCthon");
		oreCthon = new CthonOreBlock( Material.iron, "simplecthon")
				.setHardness(14.0F).setResistance(14.0F)
				.setStepSound(Block.soundTypeStone)
				.setCreativeTab(SimpleCthonCore.tabAkkamaddiCthon)
				.setBlockName("oreCthon");
		((SimpleBlock) oreCthon).setStackToDrop(new ItemStack(cthonMephiticChunk));
		
		// name stuff
		blockCthon.setHarvestLevel("pickaxe", 0);
		oreCthon.setHarvestLevel( "pickaxe", 4);
		toolCthon.customCraftingMaterial = SimpleCthonCore.cthonIngot;
		armorCthon.customCraftingMaterial = SimpleCthonCore.cthonIngot;

		// loot
		LootHelper.addLoot("pyramidDesertyChest", new ItemStack(cthonIngot), 1,
				1, 1);
		LootHelper.addLoot("pyramidDesertyChest", new ItemStack(cthonPickaxe),
				1, 1, 1);
		LootHelper.addLoot("pyramidJungleChest", new ItemStack(cthonIngot), 1,
				1, 1);
		LootHelper.addLoot("pyramidJungleChest", new ItemStack(cthonPickaxe),
				1, 1, 1);
		LootHelper.addLoot("dungeonChest", new ItemStack(cthonIngot), 1, 1, 1);
		LootHelper.addLoot("dungeonChest", new ItemStack(cthonShovel), 1, 1, 1);
		
		// run tab icon call
		setTabIcons();
		// recipes
		CthonRecipes.doCthonRecipes();
		
		GameRegistry.registerWorldGenerator(new SimpleCthonGenerator(), 1);
		MinecraftForge.EVENT_BUS.register(new HandlerJoinWorld());
	} // end preInit()

    /**
     * Do your mod setup. Build whatever data structures you care about. 
     */
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
