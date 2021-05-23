package mod.akkamaddi.cthon.datagen;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Cthon.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        registerStorageBlockTags();
    } // end registerTags()

    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/cthon"));
        this.tag(TagUtils.forgeBlockTag("storage_blocks/cthon"))
            .add(ModBlocks.cthon_block.get());
    }
    
} // end class
