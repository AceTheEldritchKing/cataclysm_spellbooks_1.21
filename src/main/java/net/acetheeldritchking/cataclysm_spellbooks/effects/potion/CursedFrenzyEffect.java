package net.acetheeldritchking.cataclysm_spellbooks.effects.potion;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import io.redspace.ironsspellbooks.damage.DamageSources;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class CursedFrenzyEffect extends MobEffect {
    public CursedFrenzyEffect() {
        super(MobEffectCategory.BENEFICIAL, 4583645);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int amplifier) {
        List<Entity> entitiesNearby = pLivingEntity.level().getEntities(pLivingEntity, pLivingEntity.getBoundingBox().inflate(0.25, 0.5, 0.25));

        if (!entitiesNearby.isEmpty())
        {
            for (Entity targets : entitiesNearby)
            {
                if (targets instanceof LivingEntity)
                {
                    DamageSources.applyDamage(targets, amplifier, SpellRegistries.CURSED_RUSH.get().getDamageSource(pLivingEntity));
                    targets.invulnerableTime = 20;
                }
            }
        }
        else if (pLivingEntity.horizontalCollision || pLivingEntity.minorHorizontalCollision)
        {
            return false;
        }
        pLivingEntity.fallDistance = 0;

        if (pLivingEntity.level().isClientSide)
        {
            // Should be every 2 seconds
            if (pLivingEntity.tickCount % 3 == 0)
            {
                double x = pLivingEntity.getX();
                double y = pLivingEntity.getY() + pLivingEntity.getBbHeight() / 2;
                double z = pLivingEntity.getZ();

                float yaw = (float) Math.toRadians(-pLivingEntity.getYRot());
                float yaw2 = (float) Math.toRadians(-pLivingEntity.getYRot() + 180);
                float pitch = (float) Math.toRadians(-pLivingEntity.getXRot());
                pLivingEntity.level().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                pLivingEntity.level().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
