package mod.akkamaddi.cthon.datagen;

import java.util.List;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Cthon.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
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

    @Override
    protected void registerMiningTags()
    {
        // all the registered blocks are mineable.
        List<Block> mineables = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();

        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
        // note: all the mineable blocks are iron-level.
        registerMineableTags(mineables, 
                List.of(), // 1 stone
                List.of(), // 2 - iron
                List.of(), // 3 - diamond
                mineables); // 4 - netherite
    }

    @Override
    protected void registerOreTags()
    {
        // register "forge:ores" tags
        this.tag(TagUtils.forgeBlockTag( "ores"))
            .addTag(TagUtils.forgeBlockTag( "ores/cthon"));
        this.tag(TagUtils.forgeBlockTag( "ores/cthon"))
            .add(ModBlocks.cthon_ore.get());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
                List.of(ModBlocks.cthon_ore.get()),
                List.of());
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(),   // stone ores
                List.of(),                          // deepslate ores
                List.of(ModBlocks.cthon_ore.get()));  // netherrack ore
    } // end registerOreTags()

    
} // end class
