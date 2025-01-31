package net.acetheeldritchking.cataclysm_spellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.IgnisWizardArmorItem;
import net.minecraft.resources.ResourceLocation;

public class IgnisWizardArmorModel extends GeoModel<IgnisWizardArmorItem> {
    @Override
    public ResourceLocation getModelResource(IgnisWizardArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/ignis_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IgnisWizardArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/models/armor/ignis_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IgnisWizardArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
