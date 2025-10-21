package net.acetheeldritchking.cataclysm_spellbooks.registries;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class CSDamageTypes {
    public static ResourceKey<DamageType> register(String name)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, name).toString()));
    }

    // Magic
    public static final ResourceKey<DamageType> ABYSSAL_MAGIC = register("abyssal_magic");
    public static final ResourceKey<DamageType> TECHNOMANCY_MAGIC = register("technomancy_magic");

    // AoEs
    public static final ResourceKey<DamageType> BLAZING_AOE = register("blazing_aoe");
    public static final ResourceKey<DamageType> NO_MANS_ZONE = register("no_man_zone_aoe");
    public static final ResourceKey<DamageType> SCORCHED_EARTH = register("scorched_earth_aoe");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(ABYSSAL_MAGIC, new DamageType(ABYSSAL_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}
