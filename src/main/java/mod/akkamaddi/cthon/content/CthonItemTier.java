package mod.akkamaddi.cthon.content;

import java.util.List;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class CthonItemTier
{
    public static final Tag.Named<Block> CTHON_TAG = 
            BlockTags.createOptional(new ResourceLocation(Cthon.MODID, "needs_cthon_tool"));
    
    public static final Tier CTHON = TierSortingRegistry.registerTier(
            new ForgeTier(5, 4350, 22.0F, 7.0F, 2, CTHON_TAG, ()->Ingredient.of(ModItems.cthon_ingot.get())),
            new ResourceLocation(Cthon.MODID, "cthon"), List.of(Tiers.NETHERITE), List.of());
    
    
 } // end class
