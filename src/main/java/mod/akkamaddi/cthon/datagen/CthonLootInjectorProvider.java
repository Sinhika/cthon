package mod.akkamaddi.cthon.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class CthonLootInjectorProvider extends LootTableInjectorProvider
{

    public CthonLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        
        // ruined_portal
        LootPool.Builder foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.cthon_mephitic_chunk.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(Cthon.MODID, "ruined_portal", foo);
        
        // nether
        foo = createChestPool(1,1, 0.33F)
                .add(LootItem.lootTableItem(ModItems.cthon_mephitic_chunk.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(Cthon.MODID, "bastion", foo);
                
        return tables;
    } // end getTables()

} // end class
