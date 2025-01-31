package net.acetheeldritchking.cataclysm_spellbooks.entity.armor;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.CursiumMageElytraArmorItem;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.IgnisWizardElytraArmorItem;
import net.minecraft.resources.ResourceLocation;

public class CursiumMageElytraArmorModel extends GeoModel<CursiumMageElytraArmorItem> {
    @Override
    public ResourceLocation getModelResource(CursiumMageElytraArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/cursium_mage_elytra.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CursiumMageElytraArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/models/armor/cursium_mage_armor_elytra.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CursiumMageElytraArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "animations/entity/cursium_mage.animation.json");
    }
}
