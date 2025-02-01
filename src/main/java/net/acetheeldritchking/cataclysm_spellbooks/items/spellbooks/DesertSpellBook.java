package net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.UniqueSpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class DesertSpellBook extends UniqueSpellBook {
    public DesertSpellBook() {
        super(SpellDataRegistryHolder.of(
                new SpellDataRegistryHolder(SpellRegistries.MONOLITH_CRASH, 5),
                new SpellDataRegistryHolder(SpellRegistries.DESERT_WINDS, 3),
                new SpellDataRegistryHolder(SpellRegistries.SANDSTORM, 5)
        ), 7);
        withSpellbookAttributes(
                new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.20F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.10F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
    }
}
