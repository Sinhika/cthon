package mod.akkamaddi.cthon.content;

import java.util.function.Supplier;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import mod.akkamaddi.cthon.init.ModItems;

public enum CthonArmorMaterial implements ArmorMaterial 
{
    CTHON("cthon:cthon", 66, new int[] {5,9,8,5}, 2, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 1.0F,
            ()->{return Ingredient.of(ModItems.cthon_ingot.get());});
    
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    private CthonArmorMaterial(String nameIn, int maxDamageIn, int[] drAmtArray, int enchantabilityIn,
            SoundEvent soundIn, float toughnessIn, float knockbackIn, Supplier<Ingredient> repairMatIn)
    {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        knockbackResistance = knockbackIn;
        repairMaterial = new LazyLoadedValue<>(repairMatIn);
    } // end ctor()

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn)
    {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn)
    {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairMaterial.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName()
    {
        return this.name;
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return knockbackResistance;
    }

} // end class
