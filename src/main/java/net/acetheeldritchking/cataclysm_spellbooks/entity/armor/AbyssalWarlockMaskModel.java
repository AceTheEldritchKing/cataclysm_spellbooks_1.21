package net.acetheeldritchking.cataclysm_spellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.AbyssalWarlockArmorItem;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.AbyssalWarlockMaskItem;
import net.minecraft.resources.ResourceLocation;

public class AbyssalWarlockMaskModel extends GeoModel<AbyssalWarlockMaskItem> {
    @Override
    public ResourceLocation getModelResource(AbyssalWarlockMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "geo/abyssal_warlock_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbyssalWarlockMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/models/armor/abyssal_warlock_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AbyssalWarlockMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
