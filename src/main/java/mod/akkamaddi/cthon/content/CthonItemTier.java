package mod.akkamaddi.cthon.content;

import mod.akkamaddi.cthon.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum CthonItemTier implements IItemTier
{
    CTHON(5, 4350, 22.0F, 7.0F, 2, ()->{ return Ingredient.of(ModItems.cthon_ingot.get()); });
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private CthonItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
            int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getUses()
    {
        return this.maxUses;
    }

    @Override
    public float getSpeed()
    {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return this.attackDamage;
    }

    @Override
    public int getLevel()
    {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairMaterial.get();
    }
} // end class
