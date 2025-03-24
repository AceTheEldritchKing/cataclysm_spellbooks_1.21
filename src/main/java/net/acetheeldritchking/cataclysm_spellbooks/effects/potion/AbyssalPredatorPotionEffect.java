package net.acetheeldritchking.cataclysm_spellbooks.effects.potion;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
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
import net.neoforged.neoforge.common.NeoForgeMod;

public class AbyssalPredatorPotionEffect extends MagicMobEffect {
    public AbyssalPredatorPotionEffect() {
        super(MobEffectCategory.BENEFICIAL, 5984177);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, CataclysmSpellbooks.id("abyssal_predator_effect"), AbyssalPredatorPotionEffect.ATTACK_SPEED_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, CataclysmSpellbooks.id("abyssal_predator_effect"), AbyssalPredatorPotionEffect.ATTACK_DAMAGE_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, CataclysmSpellbooks.id("abyssal_predator_effect"), AbyssalPredatorPotionEffect.SWIM_SPEED_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        /*
        this.addAttributeModifier(Attributes.ATTACK_SPEED, "f5f22724-fb4a-49f9-b303-cdf84357c50b", AbyssalPredatorPotionEffect.ATTACK_SPEED_PER_LEVEL, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "3e8ee83b-e6f3-4c70-a39c-de09c8e66858", AbyssalPredatorPotionEffect.ATTACK_DAMAGE_PER_LEVEL, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, "e31ad3ab-4985-4a00-9656-bc42bd52e494", AbyssalPredatorPotionEffect.SWIM_SPEED_PER_LEVEL, AttributeModifier.Operation.MULTIPLY_TOTAL);
         */
    }

    public static final float SWIM_SPEED_PER_LEVEL = 0.25f;
    // Base buffs, deal more damage when in water
    public static final float ATTACK_SPEED_PER_LEVEL = 0.05f;
    public static final float ATTACK_DAMAGE_PER_LEVEL = 0.05f;
    // Bonus Effects while in water
    public static final float MOVEMENT_SPEED_BONUS_PER_LEVEL = 0.10f;
    public static final float ATTACK_DAMAGE_BONUS_PER_LEVEL = 0.10f;

    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }

    @Override
    public MobEffect addAttributeModifier(Holder<Attribute> attribute, ResourceLocation id, double amount, AttributeModifier.Operation operation) {
        return super.addAttributeModifier(attribute, id, amount, operation);
    }

    /*@Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
    }

    @Override
    public void addAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.addAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
    }*/
}
