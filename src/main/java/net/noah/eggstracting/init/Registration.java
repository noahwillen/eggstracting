package net.noah.eggstracting.init;

import com.mojang.serialization.Codec;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noah.eggstracting.Eggstracting;
import net.noah.eggstracting.enchant.EggstractingEnchantment;
import net.noah.eggstracting.loot.AddEnchantedItemModifier;


public class Registration {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Eggstracting.MOD_ID);

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Eggstracting.MOD_ID);

    public static final RegistryObject<Enchantment> EGGSTRACTING = ENCHANTMENTS.register("eggstracting", EggstractingEnchantment::new);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ENCHANTED_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_enchanted_item", AddEnchantedItemModifier.CODEC);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENCHANTMENTS.register(modEventBus);
        LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}

