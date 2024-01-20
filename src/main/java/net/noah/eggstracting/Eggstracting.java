package net.noah.eggstracting;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.noah.eggstracting.init.Registration;

@Mod(Eggstracting.MOD_ID)
public class Eggstracting
{
    public static final String MOD_ID = "eggstracting";

    public static IEventBus MOD_EVENT_BUS;

    public Eggstracting()
    {
        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        MOD_EVENT_BUS.register(Registration.class);
        Registration.init();
    }
}
