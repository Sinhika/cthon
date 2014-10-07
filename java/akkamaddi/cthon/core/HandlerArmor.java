package akkamaddi.cthon.core;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class HandlerArmor
{
    //effects
    @ForgeSubscribe
    public void onFallDamage(LivingAttackEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.entity;
            ItemStack helmet = player.getCurrentItemOrArmor(4);
            ItemStack chest = player.getCurrentItemOrArmor(3);
            ItemStack legs = player.getCurrentItemOrArmor(2);
            ItemStack boots = player.getCurrentItemOrArmor(1);

            if (event.entity instanceof EntityPlayer)
            {
                EntityPlayer eventPlayer = (EntityPlayer)event.entity;

                if (helmet != null && chest != null && legs != null && boots != null)
                {
                    if (helmet.getItem() == SimpleCthonCore.cthonHelm & chest.getItem() == SimpleCthonCore.cthonChest & legs.getItem() == SimpleCthonCore.cthonLegs & boots.getItem() == SimpleCthonCore.cthonBoots)
                    {
                        if (event.source.equals(DamageSource.wither))
                        {
                            event.setCanceled(true);
                            //return;
                        }
                    }
                }
            }
        }
    }
}
