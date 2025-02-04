package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import com.github.L_Ender.cataclysm.config.CMConfig;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.*;
import mod.azure.azurelib.core.object.PlayState;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.armor.IgnisWizardElytraArmorRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.function.Consumer;

public class IgnisWizardElytraArmorItem extends ImbuableCSArmorItem {
    public IgnisWizardElytraArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.IGNITIUM_WIZARD_ARMOR, slot, settings, schoolAttributesWithResistance(AttributeRegistry.FIRE_SPELL_POWER, AttributeRegistry.MANA_REGEN, 150, 0.15F, 0.05F, 0.05F));
    }

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    @Override
    @OnlyIn(Dist.CLIENT)
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private IgnisWizardElytraArmorRenderer renderer;

            @Override
            public HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                {
                    renderer = new IgnisWizardElytraArmorRenderer();
                }
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    // Ignis Wizard Armor should have durability compat with Cataclysm?
    @Override
    public void setDamage(ItemStack stack, int damage) {
        if (CMConfig.Armor_Infinity_Durability)
        {
            super.setDamage(stack, 0);
        }
        else
        {
            super.setDamage(stack, damage);
        }
    }

    // Using the same stuff as Cataclysm for tooltips
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        if (this.type == Type.HELMET) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.CHESTPLATE) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.LEGGINGS) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.BOOTS) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        return true;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return ElytraItem.isFlyEnabled(stack);
    }

    // Azurelib
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // Animated armor based on conditions
    // Thank you Noah for showing me how to do this all those months back <3
    @OnlyIn(Dist.CLIENT)
    private PlayState wings(AnimationState animationState)
    {
        Player player = Minecraft.getInstance().player;

        // Flight
        if (player != null && (player.getAbilities().flying || player.isFallFlying() && !player.onGround()))
        {
            //System.out.println("Flight");
            animationState.getController().setAnimation(RawAnimation.begin().then("flying", Animation.LoopType.LOOP));
        }
        // Idle
        else if (player != null && !(player.getAbilities().flying || player.isFallFlying() && player.onGround()))
        {
            //System.out.println("Idle");
            animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "ignis_armor_winged", 10, this::wings));
    }
}
