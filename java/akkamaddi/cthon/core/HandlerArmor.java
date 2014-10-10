package akkamaddi.cthon.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import akkamaddi.akkamaddiCore.api.SimpleArmorWithEffect;
import akkamaddi.akkamaddiCore.api.SimpleArmorWithEffect.ARMOR_TYPE;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerArmor
{
    //effects
	@SubscribeEvent
    public void onFallDamage(LivingAttackEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.entity;
			ItemStack [] armorbits = new ItemStack[4];
			SimpleArmorWithEffect.getArmorPieces(player, armorbits);

			if (armorbits[ARMOR_TYPE.HELM.ordinal()].getItem() == SimpleCthonCore.cthonHelm
					&& armorbits[ARMOR_TYPE.CHEST.ordinal()].getItem() == SimpleCthonCore.cthonChest
					&& armorbits[ARMOR_TYPE.LEGS.ordinal()].getItem() == SimpleCthonCore.cthonLegs
					&& armorbits[ARMOR_TYPE.BOOTS.ordinal()].getItem() == SimpleCthonCore.cthonBoots) {
				if (event.source.equals(DamageSource.wither)) {
					event.setCanceled(true);
					// return;
				}
			}
            
        }
    }
} // end class HandlerArmor
