package net.acetheeldritchking.cataclysm_spellbooks.spells.fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.SummonedIgnitedBerserker;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.SummonedIgnitedRevenant;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSPotionEffectRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;

@AutoSpellConfig
public class ConjureIgnitedReinforcement extends AbstractIgnisSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "conjure_ignited_reinforcement");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.cataclysm_spellbooks.ignited_count", spellLevel));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(3)
            .setCooldownSeconds(100)
            .build();

    public ConjureIgnitedReinforcement()
    {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 5;
        this.castTime = 80;
        this.baseManaCost = 50;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int summonTimer = 20 * 60 * 10;

        for (int i = 0; i < spellLevel; i++)
        {
            Vec3 vec = entity.getEyePosition();

            double randomNearbyX = vec.x + entity.getRandom().nextGaussian() * 3;
            double randomNearbyZ = vec.z + entity.getRandom().nextGaussian() * 3;

            spawnIgnitedNearby(randomNearbyX, vec.y, randomNearbyZ, entity, level, summonTimer, spellLevel);
        }

        MobEffectInstance effect = new MobEffectInstance(CSPotionEffectRegistry.IGNITED_TIMER, summonTimer, 0, false, true, true);
        entity.addEffect(effect);

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private void spawnIgnitedNearby(double x, double y, double z, LivingEntity caster, Level level, int summonTimer, int spellLevel)
    {
        MobEffectInstance effect = new MobEffectInstance(CSPotionEffectRegistry.IGNITED_TIMER,
                summonTimer, 0, false, false, false);
        boolean isBerserker = Utils.random.nextDouble() < 0.7f;

        SummonedIgnitedRevenant revenantEntity = new SummonedIgnitedRevenant(level, caster);
        SummonedIgnitedBerserker berserkerEntity = new SummonedIgnitedBerserker(level, caster);

        Monster ignited = isBerserker ? berserkerEntity : revenantEntity;

        var event = NeoForge.EVENT_BUS.post(new SpellSummonEvent<>(caster, ignited, this.spellId, spellLevel));

        ignited.moveTo(x, y, z);

        ignited.addEffect(effect);

        level.addFreshEntity(event.getCreature());
    }

}
