package mod.akkamaddi.cthon.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.cthon.init.ModBlocks;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.datagen.BlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.ResourceLocation;

public class CthonLootTableProvider extends BlockLootTableProvider
{

    public CthonLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.cthon_block.get());
        specialDropTableNoFortune(ModBlocks.cthon_ore.get(), ModItems.cthon_mephitic_chunk.get());
        return tables;
    }

    /**
     * Create a block loot table that drops an item instead of the block itself. Used 
     * for example, for gems that drop from gem ore blocks. Is NOT affected by FORTUNE 
     * tools
     * 
     * @param b block being harvested
     * @param ii item dropped by block.
     */
    protected void specialDropTableNoFortune(Block b, Item ii)
    {
        blockTable(b, LootTable.lootTable().withPool(createItemWithoutFortuneDrops(b, ii)));
    }
   
    LootPool.Builder createItemWithoutFortuneDrops(Block blockIn, Item itemIn)
    {
        return droppingWithSilkTouch(blockIn, withExplosionDecay(blockIn,
                ItemLootEntry.lootTableItem(itemIn)));
    }

} // end class
