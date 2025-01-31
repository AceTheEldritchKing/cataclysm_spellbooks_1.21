package net.acetheeldritchking.cataclysm_spellbooks.events;

import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.*;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSEntityRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CataclysmSpellbooks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModSetup {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event)
    {
        event.put(CSEntityRegistry.SUMMONED_IGNITED_REVENANT.get(), SummonedIgnitedRevenant.ignited_revenant().build());
        event.put(CSEntityRegistry.SUMMONED_IGNITED_BERSERKER.get(), SummonedIgnitedBerserker.ignited_berserker().build());
        event.put(CSEntityRegistry.SUMMONED_KOBOLDIATOR.get(), SummonedKoboldiator.kobolediator().build());
        event.put(CSEntityRegistry.SUMMONED_KOBOLETON.get(), SummonedKoboleton.koboleton().build());
        event.put(CSEntityRegistry.SUMMONED_DRAUGUR.get(), SummonedDraugur.draugr().build());
        event.put(CSEntityRegistry.SUMMONED_ROYAL_DRAUGUR.get(), SummonedRoyalDraugur.royal_draugr().build());
        event.put(CSEntityRegistry.SUMMONED_ELITE_DRAUGUR.get(), SummonedEliteDraugur.elite_draugr().build());
        event.put(CSEntityRegistry.SUMMONED_APTRGANGR.get(), SummonedAptrgangr.aptrgangr().build());
    }
}
