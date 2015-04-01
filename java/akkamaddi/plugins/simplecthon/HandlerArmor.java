package akkamaddi.plugins.simplecthon;

import akkamaddi.api.core.SimpleArmorWithEffect;
import akkamaddi.api.core.SimpleArmorWithEffect.ARMOR_TYPE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerArmor
{
    //effects
	@SubscribeEvent
    public void onWitherDamage(LivingAttackEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.entity;
			ItemStack [] armorbits = new ItemStack[4];
			SimpleArmorWithEffect.getArmorPieces(player, armorbits);
			for (int i=0; i < 4; i++) {
				if (armorbits[i] == null) return;
			}

            if (armorbits[ARMOR_TYPE.HELM.ordinal()].getItem() == Content.cthonHelm
                    && armorbits[ARMOR_TYPE.CHEST.ordinal()].getItem() == Content.cthonChest
                    && armorbits[ARMOR_TYPE.LEGS.ordinal()].getItem() == Content.cthonLegs
                    && armorbits[ARMOR_TYPE.BOOTS.ordinal()].getItem() == Content.cthonBoots)
            {
                if (event.source.equals(DamageSource.wither))
                {
                    event.setCanceled(true);
                    // return;
                }
            }
            
        }
    } // end onFallDamage
} // end class HandlerArmor
