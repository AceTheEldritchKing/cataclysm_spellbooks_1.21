package net.acetheeldritchking.cataclysm_spellbooks.effects.potion;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class IncapacitatedPotionEffect extends MobEffect {
    public IncapacitatedPotionEffect() {
        super(MobEffectCategory.HARMFUL, 11319909);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, CataclysmSpellbooks.id("incapacitated_effect"), -0.15F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }

    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }

    @Override
    public MobEffect addAttributeModifier(Holder<Attribute> attribute, ResourceLocation id, double amount, AttributeModifier.Operation operation) {
        return super.addAttributeModifier(attribute, id, amount, operation);
    }
}
