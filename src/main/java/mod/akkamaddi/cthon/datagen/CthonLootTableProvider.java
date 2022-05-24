package mod.akkamaddi.cthon.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.cthon.init.ModBlocks;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

public class CthonLootTableProvider extends BlockLootTableProvider
{

    public CthonLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
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
                LootItem.lootTableItem(itemIn)));
    }

} // end class
