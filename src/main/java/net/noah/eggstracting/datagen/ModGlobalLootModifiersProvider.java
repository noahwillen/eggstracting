package net.noah.eggstracting.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.noah.eggstracting.Eggstracting;
import net.noah.eggstracting.loot.AddEnchantedItemModifier;
import net.noah.eggstracting.init.Registration;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Eggstracting.MOD_ID);
    }

    @Override
    protected void start() {
        add("eggstracting_book_from_desert_temples", new AddEnchantedItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, Items.ENCHANTED_BOOK, Registration.EGGSTRACTING.get()));
    }
}
