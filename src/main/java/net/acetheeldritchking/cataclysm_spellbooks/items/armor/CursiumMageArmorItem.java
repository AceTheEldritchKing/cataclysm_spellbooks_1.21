package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.armor.CursiumMageArmorRenderer;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.armor.IgnisWizardArmorRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.function.Consumer;

public class CursiumMageArmorItem extends ImbuableCSArmorItem {
    public CursiumMageArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.CURSIUM_WARLOCK_ARMOR, slot, settings, schoolAttributesWithResistance(AttributeRegistry.FIRE_SPELL_POWER, AttributeRegistry.MANA_REGEN, 150, 0.15F, 0.05F, 0.05F));
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private CursiumMageArmorRenderer renderer;

            @Override
            public HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                {
                    renderer = new CursiumMageArmorRenderer();
                }
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

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
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        if (this.type == Type.HELMET) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_helmet.desc2", ModKeybind.HELMET_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.CHESTPLATE) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_chestplate.desc2").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_chestplate.desc3").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm_spellbooks.cursium_chestplate.desc4").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.LEGGINGS) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_leggings.desc2").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.BOOTS) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_boots.desc2",ModKeybind.BOOTS_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
        }

    }

    /*@Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if (pEntity instanceof Player player)
        {
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemRegistries.CURSIUM_MAGE_HELMET.get())
            {
                PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), 5), new CustomPacketPayload[0]);
                this.onKeyPacket(player, pStack, 5);
            }
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemRegistries.CURSIUM_MAGE_BOOTS.get())
            {
                PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), 7), new CustomPacketPayload[0]);
                this.onKeyPacket(player, pStack, 7);
            }
        }
    }

    // Keybind stuff
    public void onKeyPacket(Player player, ItemStack itemStack, int i) {
        if (i == 5)
        {
            if (player != null && !player.getCooldowns().isOnCooldown(ItemRegistries.CURSIUM_MAGE_HELMET.get()))
            {
                boolean flag = false;
                List<Entity> list = player.level().getEntities(player, player.getBoundingBox().inflate(24));
                for (Entity entities : list)
                {
                    if (entities instanceof LivingEntity livingEntity)
                    {
                        flag = true;
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 160));
                    }
                }

                if (flag)
                {
                    player.getCooldowns().addCooldown(ItemRegistries.CURSIUM_MAGE_HELMET.get(), 200);
                }
            }
        }
        if (i == 7)
        {
            if (player != null && !player.getCooldowns().isOnCooldown(ItemRegistries.CURSIUM_MAGE_BOOTS.get()))
            {
                float speed = -1.8F;
                float yaw = (float) Math.toRadians(player.getYRot() + 90);
                Vec3 vec3 = player.getDeltaMovement().add(speed * Math.cos(yaw), 0, speed * Math.sin(yaw));

                player.setDeltaMovement(vec3.x, 0.4, vec3.z);
                player.getCooldowns().addCooldown(ItemRegistries.CURSIUM_MAGE_BOOTS.get(), 200);
            }
        }
    }*/
}
