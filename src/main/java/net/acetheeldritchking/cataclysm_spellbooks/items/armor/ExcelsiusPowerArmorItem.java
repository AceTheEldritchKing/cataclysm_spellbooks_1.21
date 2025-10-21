package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;

public class ExcelsiusPowerArmorItem extends MechanicalFlightArmorItem {
    public ExcelsiusPowerArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.EXCELSIUS_WARLOCK_ARMOR, slot, settings,
                schoolAttributes(
                        CSAttributeRegistry.TECHNOMANCY_MAGIC_POWER,
                        150,
                        0.2F,
                        0.10F)
        );
    }
}
