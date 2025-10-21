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
                        output.accept(ItemRegistries.TECHNOMANCY_UPGRADE_ORB.get());
                        // Curios
                        output.accept(ItemRegistries.LEVIATHANS_BLESSING.get());
                        // Spellbooks
                        output.accept(ItemRegistries.ABYSS_SPELL_BOOK.get());
                        output.accept(ItemRegistries.IGNIS_SPELL_BOOK.get());
                        output.accept(ItemRegistries.DESERT_SPELL_BOOK.get());
                        output.accept(ItemRegistries.CODEX_OF_MALICE.get());
                        // Staves
                        output.accept(ItemRegistries.BLOOM_STONE_STAFF.get());
                        output.accept(ItemRegistries.CORAL_STAFF.get());
                        output.accept(ItemRegistries.FAKE_WUDJETS_STAFF.get());
                        output.accept(ItemRegistries.VOID_STAFF.get());
                        output.accept(ItemRegistries.SPIRIT_SUNDERER_STAFF.get());
                        output.accept(ItemRegistries.SOUL_BRAZIER_STAFF.get());
                        // Weapons
                        output.accept(ItemRegistries.MONSTROUS_FLAMBERGE.get());
                        output.accept(ItemRegistries.HELLFIRE_FORGE.get());
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

                        output.accept(ItemRegistries.BLOOM_STONE_HAT.get());
                        output.accept(ItemRegistries.BLOOM_STONE_CHESTPLATE.get());
                        output.accept(ItemRegistries.BLOOM_STONE_SKIRT.get());
                        output.accept(ItemRegistries.BLOOM_STONE_GREAVES.get());

                        output.accept(ItemRegistries.PHARAOH_MAGE_HELMET.get());
                        output.accept(ItemRegistries.PHARAOH_MAGE_CHESTPLATE.get());
                        output.accept(ItemRegistries.PHARAOH_MAGE_LEGGINGS.get());
                        output.accept(ItemRegistries.PHARAOH_MAGE_BOOTS.get());

                        output.accept(ItemRegistries.MONSTROUS_WIZARD_HAT.get());

                        output.accept(ItemRegistries.ENGINEER_MAGE_HOOD.get());
                        output.accept(ItemRegistries.ENGINEER_MAGE_SUIT.get());
                        output.accept(ItemRegistries.ENGINEER_MAGE_LEGGINGS.get());
                        output.accept(ItemRegistries.ENGINEER_MAGE_BOOTS.get());

                        output.accept(ItemRegistries.EXCELSIUS_SPEED_HELMET.get());
                        output.accept(ItemRegistries.EXCELSIUS_SPEED_CHESTPLATE.get());
                        output.accept(ItemRegistries.EXCELSIUS_POWER_HELMET.get());
                        output.accept(ItemRegistries.EXCELSIUS_POWER_CHESTPLATE.get());
                        output.accept(ItemRegistries.EXCELSIUS_RESIST_HELMET.get());
                        output.accept(ItemRegistries.EXCELSIUS_RESIST_CHESTPLATE.get());
                        output.accept(ItemRegistries.EXCELSIUS_WARLOCK_LEGGINGS.get());
                        output.accept(ItemRegistries.EXCELSIUS_WARLOCK_BOOTS.get());
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
