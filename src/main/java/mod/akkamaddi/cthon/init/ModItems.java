package mod.akkamaddi.cthon.init;

import mod.akkamaddi.cthon.Cthon;
import mod.akkamaddi.cthon.content.CthonArmorMaterial;
import mod.akkamaddi.cthon.content.CthonItemTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
    public static final RegistryObject<Item> cthon_mephitic_chunk = ITEMS.register("cthon_mephitic_chunk",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // TOOLS & WEAPONS
    public static final RegistryObject<SwordItem> cthon_sword = ITEMS.register("cthon_sword",
            () -> new SwordItem(CthonItemTier.CTHON, 3, -2.4F,
                                new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> cthon_pickaxe = ITEMS.register("cthon_pickaxe",
            () -> new PickaxeItem(CthonItemTier.CTHON, 1, -2.8F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> cthon_axe = ITEMS.register("cthon_axe",
            () -> new AxeItem(CthonItemTier.CTHON, 7.0F, -3.1F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> cthon_shovel = ITEMS.register("cthon_shovel",
            () -> new ShovelItem(CthonItemTier.CTHON, 1.5F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> cthon_hoe = ITEMS.register("cthon_hoe",
            () -> new HoeItem(CthonItemTier.CTHON,-1, -2.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)){});
    
    // ARMOR
    public static final RegistryObject<ArmorItem> cthon_helmet = ITEMS.register("cthon_helmet",
            () -> new ArmorItem(CthonArmorMaterial.CTHON, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> cthon_leggings = ITEMS.register("cthon_leggings",
            () -> new ArmorItem(CthonArmorMaterial.CTHON, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> cthon_chestplate = ITEMS.register("cthon_chestplate",
            () -> new ArmorItem(CthonArmorMaterial.CTHON, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> cthon_boots = ITEMS.register("cthon_boots",
            () -> new ArmorItem(CthonArmorMaterial.CTHON, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
} // end class
