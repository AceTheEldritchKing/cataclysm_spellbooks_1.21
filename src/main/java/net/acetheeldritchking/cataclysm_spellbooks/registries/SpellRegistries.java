package net.acetheeldritchking.cataclysm_spellbooks.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.spells.abyssal.*;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.GravitationPullSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.GravityStormSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.VoidRuneBulwarkSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.VoidRuneSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.evocation.PilferSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.fire.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, CataclysmSpellbooks.MOD_ID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    //        //
    // Spells //
    //        //

    // ABYSSAL //
    // Void Beam
    public static final Supplier<AbstractSpell> VOID_BEAM = registerSpell(new VoidBeamSpell());

    // Abyssal Blast (Summon Leviathan death beam)
    public static final Supplier<AbstractSpell> ABYSSAL_BLAST = registerSpell(new AbyssalBlastSpell());

    // Dimensional Rift (Summon a rift)
    public static final Supplier<AbstractSpell> DIMENSIONAL_RIFT = registerSpell(new DimensionalRiftSpell());

    // Depth Charge (Summon mines)
    public static final Supplier<AbstractSpell> DEPTH_CHARGE = registerSpell(new DepthChargeSpell());

    // Abyssal Predator (Buffs while underwater)
    public static final Supplier<AbstractSpell> ABYSSAL_PREDATOR = registerSpell(new AbyssalPredatorSpell());

    // Tidal Tear (Melee attack which ends in a shockwave)
    public static final Supplier<AbstractSpell> ABYSSAL_SLASH = registerSpell(new AbyssalSlashSpell());

    // Tidal Claw (Summons Tidal Claw that grabs target) - Requires Tidal Claw
    public static final Supplier<AbstractSpell> TIDAL_GRAB = registerSpell(new TidalGrabSpell());


    // ENDER //
    // Void Rune (Ender)
    public static final Supplier<AbstractSpell> VOID_RUNE = registerSpell(new VoidRuneSpell());

    // Void Bulwark (Summon void rune shield around the caster)
    public static final Supplier<AbstractSpell> VOID_BULWARK = registerSpell(new VoidRuneBulwarkSpell());

    // Gravity Storm (Ender)
    public static final Supplier<AbstractSpell> GRAVITY_STORM = registerSpell(new GravityStormSpell());

    // Gravitational Pull (Pulls entities in like Gauntlet of Guard)
    // Removing this in 1.21.1, I want to rework it
    //public static final Supplier<AbstractSpell> GRAVITATION_PULL = registerSpell(new GravitationPullSpell());


    // EVOCATION //
    // Steal (Steals target's mainhand item)
    public static final Supplier<AbstractSpell> PILFER = registerSpell(new PilferSpell());


    // HOLY //
    // Summon Koboldiator
    //public static final Supplier<AbstractSpell> CONJURE_KOBOLDIATOR = registerSpell(new ConjureKoboldiatorSpell());

    // Summon Koboleton (Summon Koboletons)
    //public static final Supplier<AbstractSpell> CONJURE_KOBOLETON = registerSpell(new ConjureKoboletonSpell());


    // FIRE //
    // Incineration (Fire) (Summon Fire runes in row) - Requires Burning Ashes
    public static final Supplier<AbstractSpell> INCINERATION = registerSpell(new IncinerationSpell());

    // Infernal Strike (Summon mini Incinerator, inflicts blazing brand) - Requires Burning Ashes
    public static final Supplier<AbstractSpell> INFERNAL_STRIKE = registerSpell(new InfernalStrikeSpell());

    // Summon Ignited Revenant (Just as the name says) - Requires Burning Ashes (I AM NOT READY AT ALL TO DO THIS SPELL)
    public static final Supplier<AbstractSpell> CONJURE_IGNITED_REINFORCEMENT = registerSpell(new ConjureIgnitedReinforcement());

    // Hellish Blade (Summon a large Incinerator from the ground to strike and lock in a target for a short amount of time, preventing movement) - Requires Burning Ashes
    public static final Supplier<AbstractSpell> HELLISH_BLADE = registerSpell(new HellishBladeSpell());

    // Bone Storm (Sprays out blazing bones in all directions like the Revernant)
    public static final Supplier<AbstractSpell> BONE_STORM = registerSpell(new BoneStormSpell());

    // Blazing Bone Spit (Shoots out a single blazing bone)
    public static final Supplier<AbstractSpell> BONE_PIERCE = registerSpell(new BonePierceSpell());

    // Ashen Breath (Spews out ash breath in front of the caster)
    public static final Supplier<AbstractSpell> ASHEN_BREATH = registerSpell(new AshenBreathSpell());

    // Abyss Fireball (Gurl even I don't know wtf it does)
    public static final Supplier<AbstractSpell> ABYSS_FIREBALL = registerSpell(new AbyssFireballSpell());

    // Summon Ignis (April Fools spell)

    // Tectonic Tremble
    public static final Supplier<AbstractSpell> TECTONIC_TREMBLE = registerSpell(new TectonicTrembleSpell());


    // LIGHTNING //


    // ICE //
    // Malevolent Battlefield (Summon Maledictus' halberd field)
    //public static final Supplier<AbstractSpell> MALEVOLENT_BATTLEFIELD = registerSpell(new MalevolentBattlefieldSpell());

    // Forgone Rage (Apply Wrath effect to the user. As the user attacks, it fills a rage meter. Each level is an additional 10% extra damage)
    // TEMPORARILY NOT AVAILABLE IN 1.21.1
    //public static final Supplier<AbstractSpell> FORGONE_RAGE = registerSpell(new ForgoneRageSpell());

    // Conjure Thrall (Summons the ice undead warriors)
    //public static final Supplier<AbstractSpell> CONJURE_THRALL = registerSpell(new ConjureThrallsSpell());

    // Arrow Spray (Release a barrage of icy arrows. Damage increases if the user is holding a bow/crossbow)

    // Cursed Rush (Mini boss rush attack + Soul Render charge)
    //public static final Supplier<AbstractSpell> CURSED_RUSH = registerSpell(new CursedRushSpell());

    // Phantom Blade (Mini boss blade attack)

    // Malicious Curse (Summons halberds that fall ontop of the target)

    // Phantasmal Slam (Summons either a custom winged entity or Maledictus to grab and slam the target)

    // Echoed Whirlwind/Snow Squall (Summons Wrath of The Desert sandstorms)

    // Summon Maledictus (April Fools spell)


    // NATURE //
    // Sandstorm (Summon desert tornadoes around the user)
    //public static final Supplier<AbstractSpell> SANDSTORM = registerSpell(new SandstormSpell());

    // Desert Winds (Throw a desert tornado in a path in front of the user. This damages blocks)
    //public static final Supplier<AbstractSpell> DESERT_WINDS = registerSpell(new DesertWindsSpell());

    // Monolith Crash (Crashes down sandstone monoliths around the caster)
    //public static final Supplier<AbstractSpell> MONOLITH_CRASH = registerSpell(new MonolithCrashSpell());

    // Amethyst Puncture (Shoots out an amethyst spike)
    //public static final Supplier<AbstractSpell> AMETHYST_PUNCTURE = registerSpell(new AmethystPunctureSpell());

    // Summon Ancient Remnant (April Fools spell)


    // TECHNOMANCY //
    // EMP (Cast an emp blast?)

    // Lock-on (Summon a target particle above the entity's head, stuns and incapacitates them for a few seconds

    // Summon Harbinger (April Fools spell)

    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}
