package akkamaddi.plugins.simplecthon;

import alexndr.api.content.blocks.SimpleBlock;
import net.minecraft.block.material.Material;

public class CthonOreBlock extends SimpleBlock
{
    /**
     * The main constructor for the blocks.
     *
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public CthonOreBlock(Material material, String mod)
    {
        super(material);
        modId(mod);
    }

    /**
     * Sets whether or not Silk Touch has an effect on this block. Returns true so that Onyx Ore will drop itself rather than the gem item.
     */
    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
