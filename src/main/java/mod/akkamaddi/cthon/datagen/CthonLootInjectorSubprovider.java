package mod.akkamaddi.cthon.datagen;

import java.util.function.BiConsumer;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class CthonLootInjectorSubprovider extends LootTableInjectorProvider
{

    @Override
    public void generate(BiConsumer<ResourceLocation, Builder> bar) 
    {
        // ruined_portal
        LootPool.Builder foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.cthon_mephitic_chunk.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(bar, getInjectionTableId(Cthon.MODID, "ruined_portal"), foo);
        
        // nether
        foo = createChestPool(1,1, 0.33F)
                .add(LootItem.lootTableItem(ModItems.cthon_mephitic_chunk.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(Cthon.MODID, "bastion"), foo);
                
    } // end getTables()

} // end class
