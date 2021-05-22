package mod.akkamaddi.cthon.init;

import mod.akkamaddi.cthon.Cthon;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, Cthon.MODID);
    
} // end class
