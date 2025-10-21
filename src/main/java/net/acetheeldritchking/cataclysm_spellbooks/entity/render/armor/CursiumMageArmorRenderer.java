package net.acetheeldritchking.cataclysm_spellbooks.entity.render.armor;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class CursiumMageArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CataclysmSpellbooks.MOD_ID,
            "geo/cursium_mage.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CataclysmSpellbooks.MOD_ID,
            "textures/models/armor/cursium_mage_armor.png"
    );

    public CursiumMageArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}
