package net.acetheeldritchking.cataclysm_spellbooks.entity.render.armor;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.animators.CursiumMageElytraAnimator;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class CursiumMageElytraArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CataclysmSpellbooks.MOD_ID,
            "geo/cursium_mage_elytra.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CataclysmSpellbooks.MOD_ID,
            "textures/models/armor/cursium_mage_armor_elytra.png"
    );

    public CursiumMageElytraArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(CursiumMageElytraAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}
