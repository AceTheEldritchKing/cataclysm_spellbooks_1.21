package net.acetheeldritchking.cataclysm_spellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.AbyssalWarlockArmorItem;
import net.minecraft.resources.ResourceLocation;

public class AbyssalWarlockArmorModel extends GeoModel<AbyssalWarlockArmorItem> {
    @Override
    public ResourceLocation getModelResource(AbyssalWarlockArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/abyssal_warlock_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbyssalWarlockArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/models/armor/abyssal_warlock_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AbyssalWarlockArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
