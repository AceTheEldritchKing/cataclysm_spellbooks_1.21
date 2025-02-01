package net.acetheeldritchking.cataclysm_spellbooks.events;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.registries.ItemRegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.FogType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderBlockScreenEffectEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = CataclysmSpellbooks.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onFogDensity(ViewportEvent.RenderFog event)
    {
        // Lava vision for Ignis helmet
        FogType fogType = event.getCamera().getFluidInCamera();
        ItemStack itemStack = Minecraft.getInstance().player.getInventory().getArmor(3);
        if (itemStack.is(ItemRegistries.IGNITIUM_WIZARD_HELMET.get()) && fogType == FogType.LAVA)
        {
            event.setNearPlaneDistance(0);
            event.setFarPlaneDistance(event.getRenderer().getRenderDistance() * 0.5f);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void renderBlockScreenEvent(RenderBlockScreenEffectEvent event)
    {
        // Removes fire on screen when in lava
        ItemStack itemStack = Minecraft.getInstance().player.getInventory().getArmor(3);
        if (itemStack.is(ItemRegistries.IGNITIUM_WIZARD_HELMET.get()) && Minecraft.getInstance().player.isInLava())
        {
            if (event.getOverlayType() == RenderBlockScreenEffectEvent.OverlayType.FIRE)
            {
                event.setCanceled(true);
            }
        }
    }
}
