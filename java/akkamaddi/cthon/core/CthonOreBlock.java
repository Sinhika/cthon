package akkamaddi.cthon.core;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CthonOreBlock extends Block
{
    private String modName;
    /**
     * The main constructor for the blocks.
     *
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public CthonOreBlock(Material material, String mod)
    {
        super(material);
        this.modName = mod;
    }

    /**
     * Sets the texture for the block.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
    }

    public int idDropped(int i, Random random, int j)
    {
        return SimpleCthonCore.cthonMephiticChunk.itemID;
    }

    /**
     * If the block drops something that is not itself (which is the case for onyx), then a random amount of XP is dropped.
     * This random amount is within the range of 12 to 18.
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int var8 = 0;
            var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 12, 18);
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }

    /**
     * Sets whether or not Silk Touch has an effect on this block. Returns true so that Onyx Ore will drop itself rather than the gem item.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
