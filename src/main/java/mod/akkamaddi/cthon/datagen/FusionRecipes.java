package mod.akkamaddi.cthon.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.config.CthonConfig;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class FusionRecipes extends AbstractFusionRecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private FusionRecipeSetBuilder fusionbuilder;

    public FusionRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        fusionbuilder = new FusionRecipeSetBuilder(Cthon.MODID);
    }

    
    @Override
    protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerCthonRecipes(consumer);
        registerCthonRecycling(consumer);
    }
    
    
    protected void registerCthonRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];
        
        primary_inputs.add(Ingredient.of(ModItems.cthon_mephitic_chunk.get()));
        primary_inputs.add(Ingredient.of(Items.BLUE_ICE, Items.ICE, Items.PACKED_ICE));
        catalysts[0] = null;
        catalysts[1] = null;
        catalysts[2] = Ingredient.of(Items.GOLD_NUGGET);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, null,
                null, ModItems.cthon_elutriated_chunk.get(), 0.25F, 600, null);
    }
    
    
    protected void registerCthonRecycling(Consumer<FinishedRecipe> consumer)
    {
        fusionbuilder.buildFusionRecyclingRecipes(consumer,
                Ingredient.of(ModItems.cthon_axe.get(), ModItems.cthon_boots.get(), ModItems.cthon_helmet.get(),
                        ModItems.cthon_hoe.get(), ModItems.cthon_pickaxe.get(), ModItems.cthon_shovel.get(),
                        ModItems.cthon_sword.get()),
                Ingredient.of(ModItems.cthon_chestplate.get(), ModItems.cthon_leggings.get()),
                Ingredient.of(Items.NETHERRACK), Ingredient.of(Items.GOLD_INGOT), 
                ModItems.cthon_elutriated_chunk.get(), 20.0F, 600, flag("recycling_enabled"), "recycle_cthon_items");
    }
    
    
    @Override
    public ICondition flag(String name)
    {
        return  impl_flag(Cthon.MODID, CthonConfig.INSTANCE, name);
    }

} // end class
