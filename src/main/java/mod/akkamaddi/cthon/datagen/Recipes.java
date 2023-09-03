package mod.akkamaddi.cthon.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.config.CthonConfig;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public Recipes(PackOutput pOutput)
    {
        super(pOutput);
        setbuilder = new RecipeSetBuilder(Cthon.MODID);
    }
    
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()

    protected void registerToolRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.cthon_ingot.get()), "cthon",
                has(ModItems.cthon_ingot.get()), null, false);
    } // end registerToolRecipes()

    protected void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.cthon_ingot.get()), "cthon",
                has(ModItems.cthon_ingot.get()), null);
    } // end registerArmorRecipes()

    protected void registerStorageRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.cthon_ingot.get(), ModBlocks.cthon_block.get(),
                ModItems.cthon_nugget.get(), has(ModItems.cthon_ingot.get()));
    } // end registerStorageRecipes()

    protected void registerMiscRecipes(Consumer<FinishedRecipe> consumer)
    {} // end registerMiscRecipes()

    protected void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.cthon_elutriated_chunk.get()), 
                ModItems.cthon_ingot.get(), has(ModItems.cthon_elutriated_chunk.get()), 2.0F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.cthon_axe.get(), 
                ModItems.cthon_boots.get(), ModItems.cthon_helmet.get(),
                ModItems.cthon_hoe.get(), ModItems.cthon_pickaxe.get(), ModItems.cthon_shovel.get(),
                ModItems.cthon_sword.get()), ModItems.cthon_nugget.get(), has(ModItems.cthon_axe.get()), 
                10.0F, 200);
    } // end registerFurnaceRecipes()


    @Override
    public ICondition flag(String name)
    {
        return impl_flag(Cthon.MODID, CthonConfig.INSTANCE, name);
    }

} // end class
