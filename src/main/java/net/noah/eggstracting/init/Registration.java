package net.noah.eggstracting.init;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noah.eggstracting.Eggstracting;
import net.noah.eggstracting.enchant.EggstractingEnchantment;


public class Registration {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Eggstracting.MOD_ID);

    public static final RegistryObject<Enchantment> EGGSTRACTING = ENCHANTMENTS.register("eggstracting", EggstractingEnchantment::new);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENCHANTMENTS.register(modEventBus);
    }
}

