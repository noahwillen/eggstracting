package net.noah.eggstracting.enchant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.noah.eggstracting.init.Registration;

import java.util.Objects;
import java.util.Random;

public class EggstractingEnchantment extends Enchantment {
    public EggstractingEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    public int getMaxLevel() {
        return 3;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    public boolean isTradeable() {
        return false;
    }

    public boolean isDiscoverable() {
        return false;
    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EggKillHandler {
        @SubscribeEvent
        public static void eggKill(LivingDeathEvent event) {
            if (!(event.getSource().getEntity() instanceof Player)) return;

            LivingEntity usr = (LivingEntity) event.getSource().getEntity();
            Entity target = event.getEntity();

            if (EnchantmentHelper.getEnchantmentLevel(Registration.EGGSTRACTING.get(), usr) > 0) {
                Random r  = new Random();
                float n = r.nextFloat()*100;

                if (n <= (float) EnchantmentHelper.getEnchantmentLevel(Registration.EGGSTRACTING.get(), usr) *0.5) {
                    ItemStack egg = new ItemStack(Objects.requireNonNull(ForgeSpawnEggItem.fromEntityType(target.getType())), 1);
                    target.spawnAtLocation(egg);
                }
            }
        }
    }
}
