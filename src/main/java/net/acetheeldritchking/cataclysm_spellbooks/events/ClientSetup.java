package net.acetheeldritchking.cataclysm_spellbooks.events;

import com.github.L_Ender.cataclysm.client.render.entity.*;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.spells.HellishBladeRenderer;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.spells.InfernalBladeRenderer;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSEntityRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = CataclysmSpellbooks.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientSetup {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_IGNITED_REVENANT.get(), Ignited_Revenant_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_IGNITED_BERSERKER.get(), Ignited_Berserker_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_KOBOLDIATOR.get(), Kobolediator_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_KOBOLETON.get(), Koboleton_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_DRAUGUR.get(), Draugr_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_ROYAL_DRAUGUR.get(), Royal_Draugr_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_ELITE_DRAUGUR.get(), Elite_Draugr_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.SUMMONED_APTRGANGR.get(), Aptrgangr_Renderer::new);
        event.registerEntityRenderer(CSEntityRegistry.INFERNAL_BLADE_PROJECTILE.get(), InfernalBladeRenderer::new);
        event.registerEntityRenderer(CSEntityRegistry.HELLISH_BLADE_PROJECTILE.get(), HellishBladeRenderer::new);
    }
}
