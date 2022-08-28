package mod.akkamaddi.cthon.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.akkamaddi.cthon.Cthon;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = Cthon.MODID, bus = MOD)
public class CthonDataGenerator
{
    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
            gen.addProvider(new FusionRecipes(gen));
            gen.addProvider(new ModBlockTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new ModItemTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new CthonLootTableProvider(gen));
            gen.addProvider(new CthonLootInjectorProvider(gen));
        }
     } // end gatherData()

} // end class
