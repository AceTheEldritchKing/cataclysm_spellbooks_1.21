package net.acetheeldritchking.cataclysm_spellbooks.entity.render.items;

import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.resources.ResourceLocation;

public class SpiritSundererStaffRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CataclysmSpellbooks.MOD_ID,
            "geo/spirit_sunderer.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CataclysmSpellbooks.MOD_ID,
            "textures/item/spirit_sunderer.png"
    );

    public SpiritSundererStaffRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}
