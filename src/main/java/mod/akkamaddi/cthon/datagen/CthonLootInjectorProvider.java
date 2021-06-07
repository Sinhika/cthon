package mod.akkamaddi.cthon.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class CthonLootInjectorProvider extends LootTableInjectorProvider
{

    public CthonLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        
        // ruined_portal
        LootPool.Builder foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.cthon_mephitic_chunk.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(Cthon.MODID, "ruined_portal", foo);
        
        // nether
        foo = createChestPool(1,1, 0.33F)
                .add(ItemLootEntry.lootTableItem(ModItems.cthon_mephitic_chunk.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(Cthon.MODID, "nether", foo);
                
        return tables;
    } // end getTables()

} // end class
