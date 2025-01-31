package net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.resources.ResourceLocation;

public class CodexOfMaliceSpellBookModel extends GeoModel<CodexOfMaliceSpellBook> {
    @Override
    public ResourceLocation getModelResource(CodexOfMaliceSpellBook codexOfMaliceSpellBook) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/codex_of_malice.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CodexOfMaliceSpellBook codexOfMaliceSpellBook) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/item/spell_books/codex_of_malice_spell_book_model.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CodexOfMaliceSpellBook codexOfMaliceSpellBook) {
        // yes, I'm returning this file because idk what else to return for anims
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
