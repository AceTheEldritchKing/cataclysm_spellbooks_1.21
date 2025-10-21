package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import com.github.L_Ender.cataclysm.init.ModItems;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class CSArmorMaterialRegistry {
    private static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, CataclysmSpellbooks.MOD_ID);

    // Ignis Wizard Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> IGNITIUM_WIZARD_ARMOR = register("ignis_armor",
            warlockArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.IGNITIUM_INGOT.get()),
            3,
            0.1F);

    // Abyssal Warlock Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ABYSSAL_WARLOCK_ARMOR = register("abyssal_warlock_armor",
            warlockArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            3,
            0.1F);

    // Cursium Warlock Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> CURSIUM_WARLOCK_ARMOR = register("cursium_mage_armor",
            warlockArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            3,
            0.1F);

    // Pharaoh Mage Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> PHARAOH_MAGE_ARMOR = register("pharaoh_mage_armor",
            warlockArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(ModItems.ANCIENT_METAL_INGOT.get()),
            3,
            0.1F);

    // Boulder Blossom Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> BOULDER_BLOSSOM_ARMOR = register("boulder_blossom_armor",
            warlockArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            () -> Ingredient.of(ModItems.AMETHYST_CRAB_SHELL.get()),
            3,
            0.1F);

    // Monstrous Wizard Hat
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> MONSTROUS_WIZARD_ARMOR = register("monstrous_wizard",
            baseArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.MONSTROUS_HORN.get()),
            3,
            0.2F);

    // Technomancer Mage Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ENGINEER_ARMOR = register("engineer_armor",
            baseArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ModItems.MONSTROUS_HORN.get()),
            3,
            0.2F);

    // Excelsius Warlock Armor
    public static DeferredHolder<ArmorMaterial, ArmorMaterial> EXCELSIUS_WARLOCK_ARMOR = register("excelsius_warlock_armor",
            baseArmorMap(),
            25,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ModItems.WITHERITE_INGOT.get()),
            3,
            0.2F);


    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            float toughness,
            float knockbackResistance
    )
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(CataclysmSpellbooks.id(name)));
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, list, toughness, knockbackResistance));
    }

    public static EnumMap<ArmorItem.Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots)
    {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
            typeIntegerEnumMap.put(ArmorItem.Type.HELMET, helmet);
            typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, chestplate);
            typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, leggings);
            typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, boots);
        });
    }

    public static EnumMap<ArmorItem.Type, Integer> warlockArmorMap()
    {
        return makeArmorMap(4, 9, 7, 4);
    }

    public static EnumMap<ArmorItem.Type, Integer> baseArmorMap()
    {
        return makeArmorMap(3, 6, 8, 3);
    }

    public static void register(IEventBus eventBus)
    {
        ARMOR_MATERIALS.register(eventBus);
    }
}
