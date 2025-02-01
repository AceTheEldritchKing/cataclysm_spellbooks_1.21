package net.acetheeldritchking.cataclysm_spellbooks.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.spells.abyssal.*;
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

    // Void Bulwark (Summon void rune shield around the caster)

    // Gravity Storm (Ender)

    // Gravitational Pull (Pulls entities in like Gauntlet of Guard)

    // Summon End Guardian (April Fools spell)


    // EVOCATION //
    // Steal (Steals target's mainhand item)


    // HOLY //
    // Summon Koboldiator

    // Summon Koboleton (Summon Koboletons)


    // FIRE //
    // Incineration (Fire) (Summon Fire runes in row) - Requires Burning Ashes

    // Infernal Strike (Summon mini Incinerator, inflicts blazing brand) - Requires Burning Ashes

    // Summon Ignited Revenant (Just as the name says) - Requires Burning Ashes (I AM NOT READY AT ALL TO DO THIS SPELL)

    // Hellish Blade (Summon a large Incinerator from the ground to strike and lock in a target for a short amount of time, preventing movement) - Requires Burning Ashes

    // Bone Storm (Sprays out blazing bones in all directions like the Revernant)

    // Blazing Bone Spit (Shoots out a single blazing bone)

    // Ashen Breath (Spews out ash breath in front of the caster)

    // Abyss Fireball (Gurl even I don't know wtf it does)

    // Summon Ignis (April Fools spell)

    // Tectonic Tremble


    // LIGHTNING //
    // EMP (Cast an emp blast?)

    // Lock-on (Summon a target particle above the entity's head, stuns and incapacitates them for a few seconds

    // Summon Harbinger (April Fools spell)


    // ICE //
    // Malevolent Battlefield (Summon Maledictus' halberd field)

    // Forgone Rage (Apply Wrath effect to the user. As the user attacks, it fills a rage meter. Each level is an additional 10% extra damage)

    // Conjure Thrall (Summons the ice undead warriors)

    // Arrow Spray (Release a barrage of icy arrows. Damage increases if the user is holding a bow/crossbow)

    // Cursed Rush (Mini boss rush attack + Soul Render charge)

    // Phantom Blade (Mini boss blade attack)

    // Malicious Curse (Summons halberds that fall ontop of the target)

    // Phantasmal Slam (Summons either a custom winged entity or Maledictus to grab and slam the target)

    // Echoed Whirlwind (Summons Wrath of The Desert sandstorms)

    // Summon Maledictus (April Fools spell)


    // NATURE //
    // Sandstorm (Summon desert tornadoes around the user)

    // Desert Winds (Throw a desert tornado in a path in front of the user. This damages blocks)

    // Monolith Crash (Crashes down sandstone monoliths around the caster)

    // Amethyst Puncture (Shoots out an amethyst spike)

    // Summon Ancient Remnant (April Fools spell)


    // TECHNOMANCY //

    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}
