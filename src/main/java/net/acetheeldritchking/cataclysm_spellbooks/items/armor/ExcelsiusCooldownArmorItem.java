package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;

public class ExcelsiusCooldownArmorItem extends MechanicalFlightArmorItem {
    public ExcelsiusCooldownArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.EXCELSIUS_WARLOCK_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        CSAttributeRegistry.TECHNOMANCY_MAGIC_POWER,
                        AttributeRegistry.COOLDOWN_REDUCTION,
                        150,
                        0.2F,
                        0.05F,
                        0.15F)
        );
    }
}
