package net.acetheeldritchking.cataclysm_spellbooks.registries;

import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
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
}
