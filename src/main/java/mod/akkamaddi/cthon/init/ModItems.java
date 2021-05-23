package mod.akkamaddi.cthon.init;

import mod.akkamaddi.cthon.Cthon;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, Cthon.MODID);
    
    // ingots and nuggets
    public static final RegistryObject<Item> cthon_ingot = ITEMS.register("cthon_ingot",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> cthon_nugget = ITEMS.register("cthon_nugget",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> cthon_elutriated_chunk = ITEMS.register("cthon_elutriated_chunk",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> cthon_mephitic_chunk = ITEMS.register("cthon_nugget",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // TOOLS & WEAPONS
    // ARMOR

} // end class
