package net.acetheeldritchking.cataclysm_spellbooks.entity.armor;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.IgnisWizardArmorItem;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.IgnisWizardElytraArmorItem;
import net.minecraft.resources.ResourceLocation;

public class IgnisWizardElytraArmorModel extends GeoModel<IgnisWizardElytraArmorItem> {
    @Override
    public ResourceLocation getModelResource(IgnisWizardElytraArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/ignis_armor_winged.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IgnisWizardElytraArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/models/armor/ignis_armor_winged.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IgnisWizardElytraArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "animations/entity/ignis_armor_winged.animation.json");
    }
}
