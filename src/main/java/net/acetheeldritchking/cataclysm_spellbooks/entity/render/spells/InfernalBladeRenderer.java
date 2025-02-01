package net.acetheeldritchking.cataclysm_spellbooks.entity.render.spells;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.hellish_blade.HellishBladeProjectile;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.infernal_blade.InfernalBladeModel;
import net.acetheeldritchking.cataclysm_spellbooks.entity.spells.infernal_blade.InfernalBladeProjectile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.util.Color;

import java.util.Collections;
import java.util.Random;

public class InfernalBladeRenderer extends GeoEntityRenderer<InfernalBladeProjectile> {
    public InfernalBladeRenderer(EntityRendererProvider.Context context) {
        super(context, new InfernalBladeModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(InfernalBladeProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "textures/entity/infernal_blade_small/infernal_blade_small.png");
    }

    @Override
    public boolean shouldRender(InfernalBladeProjectile livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return super.shouldRender(livingEntity, camera, camX, camY, camZ);
    }

    @Override
    public void render(InfernalBladeProjectile infernalBladeProjectile, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, infernalBladeProjectile.yRotO, infernalBladeProjectile.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, infernalBladeProjectile.xRotO, infernalBladeProjectile.getXRot())));
        float randomZ = new Random(31L * infernalBladeProjectile.getId()).nextInt(-8, 8);
        poseStack.mulPose(Axis.XP.rotationDegrees(randomZ));

        poseStack.popPose();

        super.render(infernalBladeProjectile, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void preRender(PoseStack poseStack, InfernalBladeProjectile animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();

        Vec3 motion = animatable.getDeltaMovement();

        float xRot = -((float) (Mth.atan2(motion.horizontalDistance(), motion.y) * (double) (180F / (float) Math.PI)) - 90.0F);
        float yRot = -((float) (Mth.atan2(motion.z, motion.x) * (double) (180F / (float) Math.PI)) + 90.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(xRot));

        poseStack.popPose();

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    // Help
    /*@Override
    public void render(InfernalBladeProjectile projectile, float yaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, projectile.yRotO, projectile.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, projectile.xRotO, projectile.getXRot())));

        //GeoModel model = this.modelProvider.getModel(modelProvider.getModelResource(animatable));
        //this.entityRenderDispatcher = poseStack.last().pose().copy();
        //setCurrentModelRenderCycle(EModelRenderCycle.INITIAL);
        //AnimationEvent<InfernalBladeProjectile> predicate = new AnimationEvent<>(projectile, 0, 0, partialTick, false, Collections.singletonList(new EntityModelData()));
        //modelProvider.setCustomAnimations(projectile, getInstanceId(projectile), predicate);
        RenderSystem.setShaderTexture(0, getTextureLocation(projectile));
        Color renderColor = getRenderColor(projectile, partialTick, packedLight);
        RenderType renderType = getRenderType(projectile, getTextureLocation(projectile), bufferSource, packedLight);
        if (!projectile.isInvisibleTo(Minecraft.getInstance().player))
        {
            render(projectile, yaw, partialTick, poseStack, bufferSource, packedLight);
        }

        poseStack.popPose();
    }*/

}
