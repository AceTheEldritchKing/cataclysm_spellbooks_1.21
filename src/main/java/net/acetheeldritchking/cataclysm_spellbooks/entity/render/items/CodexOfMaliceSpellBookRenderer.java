package net.acetheeldritchking.cataclysm_spellbooks.entity.render.items;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;
import net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks.CodexOfMaliceSpellBook;
import net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks.CodexOfMaliceSpellBookModel;

public class CodexOfMaliceSpellBookRenderer extends GeoItemRenderer<CodexOfMaliceSpellBook> {
    public CodexOfMaliceSpellBookRenderer() {
        super(new CodexOfMaliceSpellBookModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
