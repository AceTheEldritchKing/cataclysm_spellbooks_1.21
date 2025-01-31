package net.acetheeldritchking.cataclysm_spellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.CursiumMageArmorItem;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.IgnisWizardArmorItem;
import net.minecraft.resources.ResourceLocation;

public class CursiumMageArmorModel extends GeoModel<CursiumMageArmorItem> {
    @Override
    public ResourceLocation getModelResource(CursiumMageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/cursium_mage.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CursiumMageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/models/armor/cursium_mage_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CursiumMageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
