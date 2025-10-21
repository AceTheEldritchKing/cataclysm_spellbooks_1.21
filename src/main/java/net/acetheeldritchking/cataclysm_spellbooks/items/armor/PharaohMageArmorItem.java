package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import com.github.L_Ender.cataclysm.config.CMConfig;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.item.ItemStack;

public class PharaohMageArmorItem extends ImbuableCSArmorItem {
    public PharaohMageArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.CURSIUM_WARLOCK_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        AttributeRegistry.NATURE_SPELL_POWER,
                        AttributeRegistry.HOLY_SPELL_POWER,
                        150,
                        0.2F,
                        0.05F,
                        0.2F)
        );
    }

    // Durability
    @Override
    public void setDamage(ItemStack stack, int damage) {
        if (CMConfig.Armor_Infinity_Durability)
        {
            super.setDamage(stack, 0);
        }
        else
        {
            super.setDamage(stack, damage);
        }
    }
}
