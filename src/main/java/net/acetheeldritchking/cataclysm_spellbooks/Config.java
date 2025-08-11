package net.acetheeldritchking.cataclysm_spellbooks;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs

public class Config
{
    // Builder for the config (make things get done)
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec BUILDING;

    public static ModConfigSpec.ConfigValue<Boolean> BOSSES_RESISTANCES;

    // Config goes in here
    static {
        {
            BUILDER.push("Cataclysm Spellbooks");
            BUILDER.comment("Makes Cataclysm bosses weak/resistant to certain schools");
            BOSSES_RESISTANCES = BUILDER.worldRestart().define("Add resistances to bosses", true);
            BUILDER.pop();
        }
        BUILDING = BUILDER.build();
    }
}
