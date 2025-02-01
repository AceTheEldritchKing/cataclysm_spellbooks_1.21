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
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.*;
import net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks.CodexOfMaliceSpellBook;
import net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks.DesertSpellBook;
import net.acetheeldritchking.cataclysm_spellbooks.items.staffs.CSStaffTiers;
import net.acetheeldritchking.cataclysm_spellbooks.items.staffs.SpiritSundererStaff;
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
    // Bloom Stone Staff
    public static final DeferredHolder<Item, Item> BLOOM_STONE_STAFF = ITEMS.register("bloom_stone_staff", () ->
        new StaffItem(ItemPropertiesHelper.equipment(1).attributes(ExtendedSwordItem.createAttributes(CSStaffTiers.BLOOM_STONE_STAFF))));

    // Coral Staff
    public static final DeferredHolder<Item, Item> CORAL_STAFF = ITEMS.register("coral_staff", () ->
            new StaffItem(ItemPropertiesHelper.equipment(1).attributes(ExtendedSwordItem.createAttributes(CSStaffTiers.CORAL_STAFF))));

    // Fake Wadjets Staff
    public static final DeferredHolder<Item, Item> FAKE_WUDJETS_STAFF = ITEMS.register("fake_wudjets_staff", () ->
            new StaffItem(ItemPropertiesHelper.equipment(1).attributes(ExtendedSwordItem.createAttributes(CSStaffTiers.FAKE_WUDJETS_STAFF))));

    // Void Staff
    public static final DeferredHolder<Item, Item> VOID_STAFF = ITEMS.register("void_staff", () ->
            new StaffItem(ItemPropertiesHelper.equipment(1).attributes(ExtendedSwordItem.createAttributes(CSStaffTiers.VOID_STAFF))));

    // Spirit Sunderer Staff
    public static final DeferredHolder<Item, Item> SPIRIT_SUNDERER_STAFF = ITEMS.register("spirit_sunderer", SpiritSundererStaff::new);

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
    public static final DeferredHolder<Item, Item> IGNITIUM_WIZARD_HELMET = ITEMS.register("ignis_helmet", () -> new IgnisWizardArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40))));
    public static final DeferredHolder<Item, Item> IGNITIUM_WIZARD_CHESTPLATE = ITEMS.register("ignis_chestplate", () -> new IgnisWizardArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredHolder<Item, Item> IGNITIUM_WIZARD_CHESTPLATE_ELYTRA = ITEMS.register("ignis_chestplate_elytra", () -> new IgnisWizardElytraArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredHolder<Item, Item> IGNITIUM_WIZARD_LEGGINGS = ITEMS.register("ignis_leggings", () -> new IgnisWizardArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredHolder<Item, Item> IGNITIUM_WIZARD_BOOTS = ITEMS.register("ignis_boots", () -> new IgnisWizardArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40))));

    // Abyssal Warlock Armor
    public static final DeferredHolder<Item, Item> ABYSSAL_WARLOCK_HELMET = ITEMS.register("abyssal_warlock_helmet", () -> new AbyssalWarlockArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40))));
    public static final DeferredHolder<Item, Item> ABYSSAL_WARLOCK_MASK = ITEMS.register("abyssal_warlock_mask", () -> new AbyssalWarlockMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredHolder<Item, Item> ABYSSAL_WARLOCK_CHESTPLATE = ITEMS.register("abyssal_warlock_chestplate", () -> new AbyssalWarlockArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredHolder<Item, Item> ABYSSAL_WARLOCK_LEGGINGS = ITEMS.register("abyssal_warlock_leggings", () -> new AbyssalWarlockArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredHolder<Item, Item> ABYSSAL_WARLOCK_BOOTS = ITEMS.register("abyssal_warlock_boots", () -> new AbyssalWarlockArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40))));

    // Cursium Mage Set
    public static final DeferredHolder<Item, Item> CURSIUM_MAGE_HELMET = ITEMS.register("cursium_mage_circlet", () -> new CursiumMageArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40))));
    public static final DeferredHolder<Item, Item> CURSIUM_MAGE_CHESTPLATE = ITEMS.register("cursium_mage_chestplate", () -> new CursiumMageArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredHolder<Item, Item> CURSIUM_MAGE_CHESTPLATE_ELYTRA = ITEMS.register("cursium_mage_elytra", () -> new CursiumMageElytraArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredHolder<Item, Item> CURSIUM_MAGE_LEGGINGS = ITEMS.register("cursium_mage_skirt", () -> new CursiumMageArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredHolder<Item, Item> CURSIUM_MAGE_BOOTS = ITEMS.register("cursium_mage_boots", () -> new CursiumMageArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40))));

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
