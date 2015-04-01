package akkamaddi.plugins.simplecthon;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.api.core.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    public static void preInitialize()
    {
        try
        {
            addOreDictEntries();
            LogHelper.verboseInfo(ModInfo.ID,
                    "All OreDictionary entries were added successfully.");
        }
        catch (Exception e)
        {
            LogHelper
                    .severe(ModInfo.ID,
                            "OreDictionary entries were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end preInitialize()

    public static void initialize()
    {
        try
        {
            addRecipes();
            addFurnaceRecipes();
            addFusionFurnaceRecipes();
            if (Settings.enableRecycling)
            {
                addRecyclingRecipes();
            } // end if recycling
            LogHelper.verboseInfo(ModInfo.ID,
                    "All recipes were added successfully.");
        }
        catch (Exception e)
        {
            LogHelper
                    .severe(ModInfo.ID,
                            "Recipes were not added successfully. This is a serious problem!");
            e.printStackTrace();
        }
    } // end initialize()

    public static void addOreDictEntries()
    {
        // Ore Dictionary
        OreDictionary.registerOre("ingotCthon", new ItemStack(
                Content.cthonIngot));
    } // end addOreDictEntries()

    @SuppressWarnings("unchecked")
    private static void addRecipes()
    {
        // Storage Block
        GameRegistry
                .addRecipe(new ItemStack(Content.blockCthon, 1),
                        new Object[] { "AAA", "AAA", "AAA", 'A',
                                Content.cthonIngot });

        // Item Recipe
        // Ingot Recipe
        GameRegistry.addShapelessRecipe(
                new ItemStack(Content.cthonIngot, 9),
                new Object[] { Content.blockCthon });
        // Tools
        // Cthon Tool Recipes
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonPickaxe, true,
                        new Object[] { "XXX", " Y ", " Y ", 'X', "ingotCthon",
                                'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonAxe, true,
                        new Object[] { "XX ", "XY ", " Y ", 'X', "ingotCthon",
                                'Y', "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonShovel, true,
                        new Object[] { "X", "Y", "Y", 'X', "ingotCthon", 'Y',
                                "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonSword, true,
                        new Object[] { "X", "X", "Y", 'X', "ingotCthon", 'Y',
                                "stickWood" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonHoe, true,
                        new Object[] { "XX ", " Y ", " Y ", 'X', "ingotCthon",
                                'Y', "stickWood" }));
        // Cthon Armor
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonHelm, true,
                        new Object[] { "XXX", "X X", 'X', "ingotCthon" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonChest, true,
                        new Object[] { "X X", "XXX", "XXX", 'X', "ingotCthon" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonLegs, true,
                        new Object[] { "XXX", "X X", "X X", 'X', "ingotCthon" }));
        CraftingManager
                .getInstance()
                .getRecipeList()
                .add(new ShapedOreRecipe(Content.cthonBoots, true,
                        new Object[] { "X X", "X X", 'X', "ingotCthon" }));
    } // end addRecipes

    private static void addFurnaceRecipes()
    {
        // recipes: Smelting
        GameRegistry.addSmelting(Content.cthonElutriatedChunk,
                new ItemStack(Content.cthonIngot), 2.0F);
    } // end addFurnaceRecipes

    private static void addFusionFurnaceRecipes()
    {
        // Fusion Furnace
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonMephiticChunk), 
                new ItemStack(Blocks.ice), 
                new ItemStack(Items.gold_nugget),
                new ItemStack(Content.cthonElutriatedChunk), 1.0F);
    } // end addFusionFurnaceRecipes

    private static void addRecyclingRecipes()
    {
        // Cthon
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonHelm, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack(Items.gold_ingot), 
                new ItemStack( Content.cthonElutriatedChunk), 20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonChest, 1, OreDictionary.WILDCARD_VALUE), 
                new ItemStack(Blocks.netherrack, 2, 0), 
                new ItemStack(Items.gold_ingot, 2, 0), 
                new ItemStack(Content.cthonElutriatedChunk, 2, 0), 40.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonLegs, 1, OreDictionary.WILDCARD_VALUE), 
                new ItemStack(Blocks.netherrack, 2, 0), 
                new ItemStack(Items.gold_ingot, 2, 0), 
                new ItemStack( Content.cthonElutriatedChunk, 2, 0), 40.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonBoots, 1,OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack(Items.gold_ingot), 
                new ItemStack(Content.cthonElutriatedChunk), 20.0F);
        
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonSword, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack( Items.gold_ingot), 
                new ItemStack(Content.cthonElutriatedChunk), 20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonShovel, 1,OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack(Items.gold_ingot), 
                new ItemStack( Content.cthonElutriatedChunk), 20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonPickaxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack(Items.gold_ingot), 
                new ItemStack(Content.cthonElutriatedChunk), 20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonAxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack(Items.gold_ingot), 
                new ItemStack(Content.cthonElutriatedChunk), 20.0F);
        FusionFurnaceRecipes.addSmelting(
                new ItemStack(Content.cthonHoe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.netherrack), 
                new ItemStack(Items.gold_ingot), 
                new ItemStack(Content.cthonElutriatedChunk), 20.0F);
    } // end addRecyclingRecipes

} // end class Recipes
