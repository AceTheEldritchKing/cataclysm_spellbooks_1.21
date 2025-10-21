package net.acetheeldritchking.cataclysm_spellbooks.registries;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.util.CSTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class CSSchoolRegistry {
    private static final DeferredRegister<SchoolType> CATACLYSM_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, CataclysmSpellbooks.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        CATACLYSM_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return CATACLYSM_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    // Abyssal
    public static final ResourceLocation ABYSSAL_RESOURCE = CataclysmSpellbooks.id("abyssal");

    public static final Supplier<SchoolType> ABYSSAL = registerSchool(new SchoolType
            (
                    ABYSSAL_RESOURCE,
                    CSTags.ABYSSAL_FOCUS,
                    Component.translatable("school.cataclysm_spellbooks.abyssal").withStyle(Style.EMPTY.withColor(0x36156c)),
                    CSAttributeRegistry.ABYSSAL_MAGIC_POWER,
                    CSAttributeRegistry.ABYSSAL_MAGIC_RESIST,
                    SoundRegistry.EVOCATION_CAST,
                    CSDamageTypes.ABYSSAL_MAGIC
            ));

    // Technomancy
    public static final ResourceLocation TECHNOMANCY_RESOURCE = CataclysmSpellbooks.id("technomancy");

    public static final Supplier<SchoolType> TECHNOMANCY = registerSchool(new SchoolType
            (
                    TECHNOMANCY_RESOURCE,
                    CSTags.TECHNOMANCY_FOCUS,
                    Component.translatable("school.cataclysm_spellbooks.technomancy").withStyle(Style.EMPTY.withColor(0xb3bec5)),
                    CSAttributeRegistry.TECHNOMANCY_MAGIC_POWER,
                    CSAttributeRegistry.TECHNOMANCY_MAGIC_RESIST,
                    SoundRegistry.EVOCATION_CAST,
                    CSDamageTypes.TECHNOMANCY_MAGIC
            ));

    // Sand Sub-school
    public static final ResourceLocation SAND_RESOURCE = CataclysmSpellbooks.id("sand");

    public static final Supplier<SchoolType> SAND = registerSchool(new SchoolType
            (
                    SAND_RESOURCE,
                    ModTags.NATURE_FOCUS,
                    Component.translatable("school.cataclysm_spellbooks.sand").withStyle(Style.EMPTY.withColor(0xfacb5c)),
                    AttributeRegistry.NATURE_SPELL_POWER,
                    AttributeRegistry.NATURE_MAGIC_RESIST,
                    SoundRegistry.NATURE_CAST,
                    ISSDamageTypes.NATURE_MAGIC
            ));
}
