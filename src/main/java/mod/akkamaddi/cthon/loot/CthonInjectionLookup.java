package mod.akkamaddi.cthon.loot;

import mod.alexndr.simplecorelib.api.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class CthonInjectionLookup extends InjectionTableLookup
{

    public CthonInjectionLookup()
    {
        super();
        this.AddNetherAliases();
        this.put("ruined_portal", "ruined_portal");
    }

} // end class
