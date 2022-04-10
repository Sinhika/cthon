package mod.akkamaddi.cthon.init;

import mod.akkamaddi.cthon.Cthon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cthon.MODID);
    
    // Ore block
    public static final RegistryObject<OreBlock> cthon_ore =  BLOCKS.register("cthon_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).strength(14.0F, 14.0F).requiresCorrectToolForDrops()));
                    // .harvestTool(ToolType.PICKAXE)..harvestLevel(4)));
    
    // storage block
    public static final RegistryObject<Block> cthon_block = BLOCKS.register("cthon_block",
            () -> new Block(Block.Properties.of(Material.METAL).strength(16.0F, 42.0F).requiresCorrectToolForDrops()));
                    // .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    
} // end class
