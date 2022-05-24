package mod.akkamaddi.cthon.datagen;

import java.util.List;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), Cthon.MODID, 
                existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
        registerNuggetTags();
        registerIngotTags();
    }

    private void registerNuggetTags()
    {
        this.tag(TagUtils.forgeTag("nuggets"))
            .addTag(TagUtils.forgeTag("nuggets/cthon"));
        
        this.tag(TagUtils.forgeTag("nuggets/cthon")).add(ModItems.cthon_nugget.get());
    }
    
    private void registerIngotTags()
    {
        this.tag(TagUtils.forgeTag("ingots"))
            .addTag(TagUtils.forgeTag("ingots/cthon"));
        this.tag(TagUtils.forgeTag("ingots/cthon"))
            .add(ModItems.cthon_ingot.get());
    }

    @Override
    protected void registerOreTags()
    {
        // register "forge:ores" tags
        this.tag(TagUtils.forgeTag( "ores"))
            .addTag(TagUtils.forgeTag( "ores/cthon"));
        this.tag(TagUtils.forgeTag( "ores/cthon"))
            .add(ModBlocks.cthon_ore.get().asItem());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
                List.of(ModBlocks.cthon_ore.get()),
                List.of());
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(),   // stone ores
                List.of(),                          // deepslate ores
                List.of(ModBlocks.cthon_ore.get()));  // netherrack ore
    }
    
    
} // end class
