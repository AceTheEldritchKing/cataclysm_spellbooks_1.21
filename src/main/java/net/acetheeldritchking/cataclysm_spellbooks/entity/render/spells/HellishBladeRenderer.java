package net.acetheeldritchking.cataclysm_spellbooks.entity.render.spells;

import com.mojang.blaze3d.vertex.PoseStack;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.hellish_blade.HellishBladeModel;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.hellish_blade.HellishBladeProjectile;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HellishBladeRenderer extends GeoEntityRenderer<HellishBladeProjectile> {
    public HellishBladeRenderer(EntityRendererProvider.Context context) {
        super(context, new HellishBladeModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(HellishBladeProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/entity/hellish_blade/hellish_blade.png");
    }

    @Override
    public boolean shouldRender(HellishBladeProjectile livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return super.shouldRender(livingEntity, camera, camX, camY, camZ);
    }
}
