package net.acetheeldritchking.cataclysm_spellbooks.registries;

import io.redspace.ironsspellbooks.effect.SummonTimer;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.effects.potion.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CSPotionEffectRegistry {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, CataclysmSpellbooks.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> SUMMON_VOID_RUNE =
            MOB_EFFECTS.register("summon_void_rune", VoidRunePotionEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> ABYSSAL_PREDATOR_EFFECT =
            MOB_EFFECTS.register("abyssal_predator_effect", AbyssalPredatorPotionEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> INCAPACITATED_EFFECT =
            MOB_EFFECTS.register("incapacitated_effect", IncapacitatedPotionEffect::new);

    public static final DeferredHolder<MobEffect, SummonTimer> ABYSSAL_GNAWER_TIMER =
            MOB_EFFECTS.register("abyssal_gnawer_timer", () -> new SummonTimer(MobEffectCategory.BENEFICIAL, 0xbea925));

    public static final DeferredHolder<MobEffect, SummonTimer> IGNITED_TIMER =
            MOB_EFFECTS.register("ignited_timer", () -> new SummonTimer(MobEffectCategory.BENEFICIAL, 16734003));

    public static final DeferredHolder<MobEffect, MobEffect> WRATHFUL =
            MOB_EFFECTS.register("wrathful_effect", WrathfulPotionEffect::new);

    public static final DeferredHolder<MobEffect, SummonTimer> KOBOLDIATOR_TIMER =
            MOB_EFFECTS.register("koboldiator_timer", () -> new SummonTimer(MobEffectCategory.BENEFICIAL, 16443474));

    public static final DeferredHolder<MobEffect, SummonTimer> KOBOLDETON_TIMER =
            MOB_EFFECTS.register("koboleton_timer", () -> new SummonTimer(MobEffectCategory.BENEFICIAL, 16443474));

    public static final DeferredHolder<MobEffect, MobEffect> CURSED_FRENZY =
            MOB_EFFECTS.register("cursed_frenzy", CursedFrenzyEffect::new);

    public static final DeferredHolder<MobEffect, SummonTimer> DRAUGUR_TIMER =
            MOB_EFFECTS.register("draugur_timer", () -> new SummonTimer(MobEffectCategory.BENEFICIAL, 4583645));

    public static final DeferredHolder<MobEffect, SummonTimer> CRAB_TIMER =
            MOB_EFFECTS.register("crab_timer", () -> new SummonTimer(MobEffectCategory.BENEFICIAL, 0xfa87fa));

    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
