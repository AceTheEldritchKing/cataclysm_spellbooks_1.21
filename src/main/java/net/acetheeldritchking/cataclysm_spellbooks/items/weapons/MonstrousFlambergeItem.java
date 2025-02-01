package net.acetheeldritchking.cataclysm_spellbooks.items.weapons;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.world.item.Rarity;

public class MonstrousFlambergeItem extends MagicSwordItem {
    public MonstrousFlambergeItem() {
        super(
                CSWeaponTiers.MONSTROUS_FLAMBERGE,
                ItemPropertiesHelper.equipment().fireResistant().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(CSWeaponTiers.MONSTROUS_FLAMBERGE)),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistries.TECTONIC_TREMBLE, 1)
                )
        );
    }
}
