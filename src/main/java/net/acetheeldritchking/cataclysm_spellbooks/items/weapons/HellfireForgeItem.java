package net.acetheeldritchking.cataclysm_spellbooks.items.weapons;

import com.github.L_Ender.cataclysm.init.ModSounds;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.UniqueItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class HellfireForgeItem extends MagicSwordItem implements UniqueItem {
    public HellfireForgeItem() {
        super(
                CSWeaponTiers.HELLFIRE_FORGE,
                ItemPropertiesHelper.equipment().fireResistant().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(CSWeaponTiers.HELLFIRE_FORGE)).component(ComponentRegistry.CASTING_IMPLEMENT, Unit.INSTANCE),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.RAISE_HELL_SPELL, 4)
                )
        );
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide)
        {
            target.playSound(ModSounds.HAMMERTIME.get(), 0.5F, 0.5F);
            target.knockback(1.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        }

        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.cataclysm_spellbooks.hellfire_forge.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltipComponents.add(Component.translatable("item.cataclysm_spellbooks.hellfire_forge.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}
