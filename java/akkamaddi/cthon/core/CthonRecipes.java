package akkamaddi.cthon.core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import alexndr.SimpleOres.plugins.fusion.FusionHelper;

public class CthonRecipes
{
    public static void doCthonRecipes()
    {
        // Ore Dictionary
        OreDictionary.registerOre("ingotCthon", new ItemStack(SimpleCthonCore.cthonIngot));
        // recipes: Crafting
        //Storage Block
        GameRegistry.addRecipe(new ItemStack(SimpleCthonCore.blockCthon, 1), new Object[] {"AAA", "AAA", "AAA", 'A', SimpleCthonCore.cthonIngot});
        //Item Recipe
        //Ingot Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(SimpleCthonCore.cthonIngot, 9), new Object[]
                                        {
                                            SimpleCthonCore.blockCthon
                                        });
        // Tools
        //Cthon Tool Recipes
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonPickaxe, true, new Object[]
                {
                    "XXX", " Y ", " Y ", 'X', "ingotCthon", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonAxe, true, new Object[]
                {
                    "XX ", "XY ", " Y ", 'X', "ingotCthon", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonShovel, true, new Object[]
                {
                    "X", "Y", "Y", 'X', "ingotCthon", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonSword, true, new Object[]
                {
                    "X", "X", "Y", 'X', "ingotCthon", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonHoe, true, new Object[]
                {
                    "XX ", " Y ", " Y ", 'X', "ingotCthon", 'Y', "stickWood"
                }));
        //Cthon Armor
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonHelm, true, new Object[]
                {
                    "XXX", "X X", 'X', "ingotCthon"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonChest, true, new Object[]
                {
                    "X X", "XXX", "XXX", 'X', "ingotCthon"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonLegs, true, new Object[]
                {
                    "XXX", "X X", "X X", 'X', "ingotCthon"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SimpleCthonCore.cthonBoots, true, new Object[]
                {
                    "X X", "X X", 'X', "ingotCthon"
                }));
        // recipes: Smelting
        GameRegistry.addSmelting(SimpleCthonCore.cthonElutriatedChunk.itemID, new ItemStack(SimpleCthonCore.cthonIngot), 2.0F);
        // Fusion Furnace
        FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonMephiticChunk), new ItemStack(Block.ice), new ItemStack(Item.goldNugget), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 1.0F);

        if (SimpleCthonCore.enableRecycling)
        {
            // Cthon
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonHelm, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonChest, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack, 2, 0), new ItemStack(Item.ingotGold, 2, 0), new ItemStack(SimpleCthonCore.cthonElutriatedChunk, 2, 0), 40.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonLegs, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack, 2, 0), new ItemStack(Item.ingotGold, 2, 0), new ItemStack(SimpleCthonCore.cthonElutriatedChunk, 2, 0), 40.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonBoots, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonSword, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonShovel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonPickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonAxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
            FusionHelper.fusionFurnaceRecipes.smelting().addSmelting(new ItemStack(SimpleCthonCore.cthonHoe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(Item.ingotGold), new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
        }
    }
}
