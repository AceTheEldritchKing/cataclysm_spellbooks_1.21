package net.acetheeldritchking.cataclysm_spellbooks.registries;

import com.google.common.collect.ImmutableMultimap;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.CSUpgradeTypes;
import net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks.CodexOfMaliceSpellBook;
import net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks.DesertSpellBook;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Supplier;

public class ItemRegistries {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CataclysmSpellbooks.MOD_ID);

    /***
     * Spellbooks
     */
    // Abyss Spellbook
    public static final DeferredHolder<Item, Item> ABYSS_SPELL_BOOK = ITEMS.register
            ("abyss_spell_book", () ->
                    new SpellBook(12, ItemPropertiesHelper.equipment().fireResistant().stacksTo(1))
                            .withSpellbookAttributes(
                                    new AttributeContainer(CSAttributeRegistry.ABYSSAL_MAGIC_POWER, .30F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                    new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE)
                            ));

    // Desert Spellbook - Dropped by ancient remnant
    public static final DeferredHolder<Item, Item> DESERT_SPELL_BOOK = ITEMS.register
            ("desert_spell_book", DesertSpellBook::new);

    // Ignis Spellbook
    public static final DeferredHolder<Item, Item> IGNIS_SPELL_BOOK = ITEMS.register
            ("ignis_spell_book", () ->
                    new SpellBook(12, ItemPropertiesHelper.equipment().fireResistant().stacksTo(1))
                            .withSpellbookAttributes(
                                    new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, .30F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                    new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE)
                            ));

    // Codex of Malice
    public static final DeferredHolder<Item, Item> CODEX_OF_MALICE = ITEMS.register
            ("codex_of_malice_spell_book", CodexOfMaliceSpellBook::new);

    /***
     * Staffs and Gauntlets
     */

    /***
     * Weapons
     */

    /***
     * Generic Items
     */
    // Abyssal Rune
    public static final DeferredHolder<Item, Item> ABYSSAL_RUNE = ITEMS.register("abyssal_rune", () -> new Item(ItemPropertiesHelper.material()));

    /***
     * Upgrade Orbs
     */
    public static final DeferredHolder<Item, Item> ABYSSAL_UPGRADE_ORB = ITEMS.register("abyssal_upgrade_orb",
            () -> new UpgradeOrbItem(CSUpgradeTypes.ABYSSAL_SPELL_POWER, ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON)));

    /***
     * Curios
     */

    /***
     * Armor
     */
    // Ignis Wizard Armor

    // Abyssal Warlock Armor

    // Cursium Mage Set

    // Pharaoh Mage Set

    // Technomancer Mage set

    // Monstrous Wizard Hat

    // Boulder Blossom Mage Set

    // Excelsius Mage Set


    public static Collection<DeferredHolder<Item, ? extends Item>> getCSItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
