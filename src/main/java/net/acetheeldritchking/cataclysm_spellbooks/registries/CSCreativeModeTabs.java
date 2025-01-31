package net.acetheeldritchking.cataclysm_spellbooks.registries;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CSCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CataclysmSpellbooks.MOD_ID);

    public static final Supplier<CreativeModeTab> CS_ITEMS_TAB = CREATIVE_MODE_TAB.register("cs_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistries.ABYSSAL_RUNE.get()))
                    .title(Component.translatable("creative_tab.cataclysm_spellbooks.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Materials
                        output.accept(ItemRegistries.ABYSSAL_RUNE.get());
                        output.accept(ItemRegistries.ABYSSAL_UPGRADE_ORB.get());
                        // Curios
                        // Spellbooks
                        output.accept(ItemRegistries.ABYSS_SPELL_BOOK.get());
                        output.accept(ItemRegistries.IGNIS_SPELL_BOOK.get());
                        output.accept(ItemRegistries.DESERT_SPELL_BOOK.get());
                        output.accept(ItemRegistries.CODEX_OF_MALICE.get());
                        // Weapons
                        // Armor
                        output.accept(ItemRegistries.IGNITIUM_WIZARD_HELMET.get());
                        output.accept(ItemRegistries.IGNITIUM_WIZARD_CHESTPLATE.get());
                        output.accept(ItemRegistries.IGNITIUM_WIZARD_CHESTPLATE_ELYTRA.get());
                        output.accept(ItemRegistries.IGNITIUM_WIZARD_LEGGINGS.get());
                        output.accept(ItemRegistries.IGNITIUM_WIZARD_BOOTS.get());

                        output.accept(ItemRegistries.ABYSSAL_WARLOCK_HELMET.get());
                        output.accept(ItemRegistries.ABYSSAL_WARLOCK_MASK.get());
                        output.accept(ItemRegistries.ABYSSAL_WARLOCK_CHESTPLATE.get());
                        output.accept(ItemRegistries.ABYSSAL_WARLOCK_LEGGINGS.get());
                        output.accept(ItemRegistries.ABYSSAL_WARLOCK_BOOTS.get());

                        output.accept(ItemRegistries.CURSIUM_MAGE_HELMET.get());
                        output.accept(ItemRegistries.CURSIUM_MAGE_CHESTPLATE.get());
                        output.accept(ItemRegistries.CURSIUM_MAGE_CHESTPLATE_ELYTRA.get());
                        output.accept(ItemRegistries.CURSIUM_MAGE_LEGGINGS.get());
                        output.accept(ItemRegistries.CURSIUM_MAGE_BOOTS.get());
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
