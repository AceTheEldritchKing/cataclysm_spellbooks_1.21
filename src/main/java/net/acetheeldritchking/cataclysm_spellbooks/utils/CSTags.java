package net.acetheeldritchking.cataclysm_spellbooks.utils;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CSTags {
    public static final TagKey<Item> ABYSSAL_FOCUS = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "abyssal_focus").toString()));
}
