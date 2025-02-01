package net.acetheeldritchking.cataclysm_spellbooks.items.staffs;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class CSStaffTiers implements IronsWeaponTier {
    // Bloomstone Staff
    public static CSStaffTiers BLOOM_STONE_STAFF = new CSStaffTiers(3, -3,
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Coral Staff
    public static CSStaffTiers CORAL_STAFF = new CSStaffTiers(3, -3,
            new AttributeContainer(CSAttributeRegistry.ABYSSAL_MAGIC_POWER, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Fake Wadjet's Staff
    public static CSStaffTiers FAKE_WUDJETS_STAFF = new CSStaffTiers(3, -3,
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.10f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.20f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Void Staff
    public static CSStaffTiers VOID_STAFF = new CSStaffTiers(3, -3,
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Spirit Sunderer Staff
    public static CSStaffTiers SPIRIT_SUNDERER_STAFF = new CSStaffTiers(3, -3,
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN, 0.30f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    float damage;
    float speed;
    AttributeContainer[] attributeContainers;

    public CSStaffTiers(float damage, float speed, AttributeContainer... attributeContainers)
    {
        this.damage = damage;
        this.speed = speed;
        this.attributeContainers = attributeContainers;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributeContainers;
    }
}
