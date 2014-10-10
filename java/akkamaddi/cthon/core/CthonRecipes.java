package akkamaddi.cthon.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class CthonRecipes
{
    @SuppressWarnings("unchecked")
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
		GameRegistry.addSmelting(SimpleCthonCore.cthonElutriatedChunk,
				new ItemStack(SimpleCthonCore.cthonIngot), 2.0F);
		// Fusion Furnace
		FusionRecipes.addSmelting(new ItemStack(
				SimpleCthonCore.cthonMephiticChunk), new ItemStack(Blocks.ice),
				new ItemStack(Items.gold_nugget), new ItemStack(
						SimpleCthonCore.cthonElutriatedChunk), 1.0F);

        if (SimpleCthonCore.enableRecycling)
        {
            // Cthon
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonHelm,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonChest,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack, 2, 0),
					new ItemStack(Items.gold_ingot, 2, 0), new ItemStack(
							SimpleCthonCore.cthonElutriatedChunk, 2, 0), 40.0F);
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonLegs,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack, 2, 0),
					new ItemStack(Items.gold_ingot, 2, 0), new ItemStack(
							SimpleCthonCore.cthonElutriatedChunk, 2, 0), 40.0F);
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonBoots,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonSword,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SimpleCthonCore.cthonShovel, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(
					SimpleCthonCore.cthonPickaxe, 1,
					OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonAxe,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
			FusionRecipes.addSmelting(new ItemStack(SimpleCthonCore.cthonHoe,
					1, OreDictionary.WILDCARD_VALUE), new ItemStack(
					Blocks.netherrack), new ItemStack(Items.gold_ingot),
					new ItemStack(SimpleCthonCore.cthonElutriatedChunk), 20.0F);
        }
    }
}
