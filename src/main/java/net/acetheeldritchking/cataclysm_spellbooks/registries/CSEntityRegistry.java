package net.acetheeldritchking.cataclysm_spellbooks.registries;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.*;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.blazing_aoe.BlazingAoE;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.hellish_blade.HellishBladeProjectile;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.infernal_blade.InfernalBladeProjectile;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CSEntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, CataclysmSpellbooks.MOD_ID);

    // Projectiles //
    // Infernal Blade Projectile
    public static final DeferredHolder<EntityType<?>, EntityType<InfernalBladeProjectile>> INFERNAL_BLADE_PROJECTILE =
            ENTITIES.register("infernal_blade", () -> EntityType.Builder.<InfernalBladeProjectile>of(InfernalBladeProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "infernal_blade").toString()
                    ));

    // Hellish Blade Projectile
    public static final DeferredHolder<EntityType<?>, EntityType<HellishBladeProjectile>> HELLISH_BLADE_PROJECTILE =
            ENTITIES.register("hellish_blade", () -> EntityType.Builder.<HellishBladeProjectile>of(HellishBladeProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "hellish_blade").toString()
                    ));

    // Blazing AoE Entity
    public static final DeferredHolder<EntityType<?>, EntityType<BlazingAoE>> BLAZING_AOE_ENTITY =
            ENTITIES.register("blazing_aoe", () -> EntityType.Builder.<BlazingAoE>of(BlazingAoE::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "blazing_aoe").toString()
                    ));


    // Entities //


    // Summons //

    // Summoned Ignited Revenant
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedIgnitedRevenant>> SUMMONED_IGNITED_REVENANT =
            ENTITIES.register("summoned_ignited_revenant", () -> EntityType.Builder.<SummonedIgnitedRevenant>of
                            (SummonedIgnitedRevenant::new, MobCategory.MONSTER).
                    sized(1f, 3f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_ignited_revenant").toString()
                    ));

    // Summoned Ignited Berserker
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedIgnitedBerserker>> SUMMONED_IGNITED_BERSERKER =
            ENTITIES.register("summoned_ignited_berserker", () -> EntityType.Builder.<SummonedIgnitedBerserker>of
                            (SummonedIgnitedBerserker::new, MobCategory.MONSTER).
                    sized(1f, 3f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_ignited_berserker").toString()
                    ));

    // Summoned Koboldiator
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedKoboldiator>> SUMMONED_KOBOLDIATOR =
            ENTITIES.register("summoned_koboldiator", () -> EntityType.Builder.<SummonedKoboldiator>of
                            (SummonedKoboldiator::new, MobCategory.MONSTER).
                    sized(2.5f, 4.5f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_koboldiator").toString()
                    ));

    // Summoned Koboleton
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedKoboleton>> SUMMONED_KOBOLETON =
            ENTITIES.register("summoned_koboleton", () -> EntityType.Builder.<SummonedKoboleton>of
                            (SummonedKoboleton::new, MobCategory.MONSTER).
                    sized(1f, 2f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_koboleton").toString()
                    ));

    // Summoned Draugur
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedDraugur>> SUMMONED_DRAUGUR =
            ENTITIES.register("summoned_draugur", () -> EntityType.Builder.<SummonedDraugur>of
                            (SummonedDraugur::new, MobCategory.MONSTER).
                    sized(1f, 2f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_draugur").toString()
                    ));

    // Summoned Royal Draugur
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedRoyalDraugur>> SUMMONED_ROYAL_DRAUGUR =
            ENTITIES.register("summoned_royal_draugur", () -> EntityType.Builder.<SummonedRoyalDraugur>of
                            (SummonedRoyalDraugur::new, MobCategory.MONSTER).
                    sized(1f, 2f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_royal_draugur").toString()
                    ));

    // Summoned Elite Draugur
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedEliteDraugur>> SUMMONED_ELITE_DRAUGUR =
            ENTITIES.register("summoned_elite_draugur", () -> EntityType.Builder.<SummonedEliteDraugur>of
                            (SummonedEliteDraugur::new, MobCategory.MONSTER).
                    sized(1f, 3f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_elite_draugur").toString()
                    ));

    // Summoned Aptrgangr
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedAptrgangr>> SUMMONED_APTRGANGR =
            ENTITIES.register("summoned_aptrgangr", () -> EntityType.Builder.<SummonedAptrgangr>of
                            (SummonedAptrgangr::new, MobCategory.MONSTER).
                    sized(1f, 3f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_aptrgangr").toString()
                    ));

    // Summoned Amethyst Crab
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedAmethystCrab>> SUMMONED_AMETHYST_CRAB =
            ENTITIES.register("summoned_amethyst_crab", () -> EntityType.Builder.<SummonedAmethystCrab>of
                            (SummonedAmethystCrab::new, MobCategory.MONSTER).
                    sized(3f, 2.5f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "summoned_amethyst_crab").toString()
                    ));

    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}
