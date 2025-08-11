package net.acetheeldritchking.cataclysm_spellbooks.util;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CSTags {
    /***
     * Items
     */
    // School focuses
    public static final TagKey<Item> ABYSSAL_FOCUS = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "abyssal_focus").toString()));

    // Armor Items For Idle
    public static final TagKey<Item> ARMORS_FOR_IDLE = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "armors_for_idle").toString()));

    // Armor Items For Flight
    public static final TagKey<Item> ARMORS_FOR_FLIGHT = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "armors_for_flight").toString()));
}
