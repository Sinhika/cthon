package akkamaddi.cthon.core;


public class ClientProxy extends akkamaddi.akkamaddiCore.api.ClientProxy
{
    @Override
    public void registerRenderers()
    {
		// Armor Renderers
		SimpleCthonCore.rendererCthon = addArmor("cthon");

    }
   
}