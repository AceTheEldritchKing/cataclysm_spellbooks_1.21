package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;

public class ExcelsiusLegArmorItem extends MechanicalFlightArmorItem {
    public ExcelsiusLegArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.EXCELSIUS_WARLOCK_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        CSAttributeRegistry.TECHNOMANCY_MAGIC_POWER,
                        CSAttributeRegistry.TECHNOMANCY_MAGIC_RESIST,
                        150,
                        0.2F,
                        0.05F,
                        0.05F)
        );
    }
}
