package mod.akkamaddi.cthon.datagen;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), Cthon.MODID, 
                existingFileHelper);
    }

    @Override
    protected void addTags()
    {
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
} // end class
