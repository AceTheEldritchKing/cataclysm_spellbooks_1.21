package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import com.github.L_Ender.cataclysm.config.CMConfig;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.item.ItemStack;

public class AbyssalWarlockMaskItem extends ImbuableCSArmorItem {
    public AbyssalWarlockMaskItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.ABYSSAL_WARLOCK_ARMOR, slot, settings, schoolAttributesWithResistance(CSAttributeRegistry.ABYSSAL_MAGIC_POWER, CSAttributeRegistry.ABYSSAL_MAGIC_RESIST, 150, 0.2F, 0.05F, 0.1F));
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
