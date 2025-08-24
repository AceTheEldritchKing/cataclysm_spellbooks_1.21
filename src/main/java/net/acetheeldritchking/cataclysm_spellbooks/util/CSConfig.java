package net.acetheeldritchking.cataclysm_spellbooks.util;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CSConfig
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
