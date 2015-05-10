/**
 * 
 */
package akkamaddi.plugins.simplecthon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import akkamaddi.api.core.LootHelper;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.LogHelper;

/**
 * @author cyhiggin
 *
 */
public class Content
{
    /**
     * Loads all the mod content, by calling the methods below.
     */
    public static void preInitialize()
    {
        try {
            doItems();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All items were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Items were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doBlocks();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All blocks were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Blocks were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doTools();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All tools were added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Tools were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        try {
            doArmor();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All armor was added successfully");
        } 
        catch (Exception e) {
            LogHelper.severe(ModInfo.ID,
                            "Armor was not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
        //      try{doAchievements(); LogHelper.verboseInfo(ModInfo.ID, "All achievements were added successfully");}
//          catch(Exception e){LogHelper.severe(ModInfo.ID, "Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
    } // end preInitialize()

    public static void doArmor()
    {
        cthonHelm = new SimpleArmor(SimpleCthon.armorCthon, 0)
                .modId("simplecthon").setType("cthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonHelm");
        cthonChest = new SimpleArmor(SimpleCthon.armorCthon, 1)
                .modId("simplecthon").setType("cthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonChest");
        cthonLegs = new SimpleArmor(SimpleCthon.armorCthon, 2)
                .modId("simplecthon").setType("cthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonLegs");
        cthonBoots = new SimpleArmor(SimpleCthon.armorCthon, 3)
                .modId("simplecthon").setType("cthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonBoots");
    } // end doArmor

    public static void doBlocks()
    {
        // define blocks
        blockCthon = new SimpleBlock( Material.iron).setBeaconBase(true)
                .modId("simplecthon")
                .setHardness(Settings.cthonHardness)
                .setResistance(Settings.cthonResistance)
                .setStepSound(Block.soundTypeMetal)
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setBlockName("blockCthon");
        oreCthon = new CthonOreBlock( Material.iron, "simplecthon")
                .setHardness(Settings.cthonOreHardness)
                .setResistance(Settings.cthonOreResistance)
                .setStepSound(Block.soundTypeStone)
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setBlockName("oreCthon");
        ((SimpleBlock) oreCthon).setStackToDrop(new ItemStack(cthonMephiticChunk));
        
        // name stuff
        blockCthon.setHarvestLevel("pickaxe", Settings.cthonHarvestLevel);
        oreCthon.setHarvestLevel( "pickaxe", Settings.cthonOreHarvestLevel);
      
    } // end doBlocks()

    public static void doItems()
    {
        // define items
        // Cthon
        cthonIngot = new SimpleItem().modId("simplecthon").isIngot()
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonIngot");
        cthonElutriatedChunk = new SimpleItem().isIngot()
                .modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonElutriatedChunk");
        cthonMephiticChunk = new SimpleItem().isIngot()
                .modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonMephiticChunk");
        
    } // end doItems

    public static void doTools()
    {
        cthonSword = new SimpleSword(SimpleCthon.toolCthon)
                .modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonSword");
        cthonShovel = new SimpleShovel(SimpleCthon.toolCthon)
                .modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonShovel");
        cthonAxe = new SimpleAxe(SimpleCthon.toolCthon).modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonAxe");
        cthonPickaxe = new SimplePickaxe(SimpleCthon.toolCthon)
                .modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonPickaxe");
        cthonHoe = new SimpleHoe(SimpleCthon.toolCthon).modId("simplecthon")
                .setCreativeTab(SimpleCthon.tabAkkamaddiCthon)
                .setUnlocalizedName("cthonHoe");
       
    } // end doTools()

    public static void setLoot()
    {
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
       
    } // setLoot()

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

   
    
} // end class Content
