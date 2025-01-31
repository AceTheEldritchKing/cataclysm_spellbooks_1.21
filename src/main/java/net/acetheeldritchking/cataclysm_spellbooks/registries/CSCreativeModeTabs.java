package net.acetheeldritchking.cataclysm_spellbooks.registries;

import com.github.L_Ender.cataclysm.init.ModItems;
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

    public static final Supplier<CreativeModeTab> DTE_ITEMS_TAB = CREATIVE_MODE_TAB.register("cs_items_tab",
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
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
