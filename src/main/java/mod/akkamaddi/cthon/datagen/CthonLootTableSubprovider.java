package mod.akkamaddi.cthon.datagen;

import mod.akkamaddi.cthon.init.ModBlocks;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;

public class CthonLootTableSubprovider extends SimpleBlockLootSubProvider
{

    @Override
	protected void generate() 
    {
    	dropSelf(ModBlocks.cthon_block.get());
        dropOther(ModBlocks.cthon_ore.get(), ModItems.cthon_mephitic_chunk.get());
    }

} // end class
