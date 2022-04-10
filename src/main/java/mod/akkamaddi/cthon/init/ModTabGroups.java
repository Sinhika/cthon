package mod.akkamaddi.cthon.init;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import mod.akkamaddi.cthon.Cthon;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModTabGroups
{
    public static final CreativeModeTab MOD_ITEM_GROUP = 
            new ModTabGroup(Cthon.MODID, () -> new ItemStack(ModBlocks.cthon_ore.get().asItem()));

    public static final class ModTabGroup extends CreativeModeTab
    {

        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        /**
         * @param name  String: mod id
         * @param iconSupplier
         */
        public ModTabGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier)
        {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return iconSupplier.get();
        }

    } // end ModTabGroup()

} // end class
