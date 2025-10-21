package net.acetheeldritchking.cataclysm_spellbooks;

import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.armor.*;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.items.CodexOfMaliceSpellBookRenderer;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.items.SpiritSundererStaffRenderer;
import net.acetheeldritchking.cataclysm_spellbooks.items.armor.CSArmorMaterialRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.loot.CSLootModifiers;
import net.acetheeldritchking.cataclysm_spellbooks.registries.*;
import net.acetheeldritchking.cataclysm_spellbooks.util.CSConfig;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(CataclysmSpellbooks.MOD_ID)
public class CataclysmSpellbooks
{
    public static final String MOD_ID = "cataclysm_spellbooks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CataclysmSpellbooks(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        // Creative Tab
        CSCreativeModeTabs.register(modEventBus);
        // Items
        ItemRegistries.register(modEventBus);
        // Attributes
        CSAttributeRegistry.register(modEventBus);
        // Schools
        CSSchoolRegistry.register(modEventBus);
        // Spells
        SpellRegistries.register(modEventBus);
        // Effects
        CSPotionEffectRegistry.register(modEventBus);
        // Sounds
        // Entities
        CSEntityRegistry.register(modEventBus);
        // Armor Materials
        CSArmorMaterialRegistry.register(modEventBus);
        // Loot Tables
        CSLootModifiers.register(modEventBus);

        // Initializes config
        modContainer.registerConfig(ModConfig.Type.SERVER, CSConfig.BUILDING, String.format("%s-server.toml", MOD_ID));

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        // Animation Registry
        AzIdentityRegistry.register(
                ItemRegistries.IGNITIUM_WIZARD_CHESTPLATE_ELYTRA.get(),
                ItemRegistries.CURSIUM_MAGE_CHESTPLATE_ELYTRA.get(),
                //ItemRegistries.DISC_DRIVER.get(),
                //ItemRegistries.GAUNTLET_OF_GATTLING.get(),
                //ItemRegistries.THE_NIGHTSTALKER.get(),
                //ItemRegistries.THE_BERSERKER.get(),
                //ItemRegistries.THE_COMBUSTER.get(),
                ItemRegistries.EXCELSIUS_SPEED_HELMET.get(),
                ItemRegistries.EXCELSIUS_RESIST_HELMET.get(),
                ItemRegistries.EXCELSIUS_POWER_HELMET.get(),
                ItemRegistries.EXCELSIUS_SPEED_CHESTPLATE.get(),
                ItemRegistries.EXCELSIUS_RESIST_CHESTPLATE.get(),
                ItemRegistries.EXCELSIUS_POWER_CHESTPLATE.get()
        );
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            ItemRegistries.getCSItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));

            // Armor Rendering Registry
            AzArmorRendererRegistry.register(AbyssalWarlockArmorRenderer::new,
                    ItemRegistries.ABYSSAL_WARLOCK_HELMET.get(),
                    ItemRegistries.ABYSSAL_WARLOCK_CHESTPLATE.get(),
                    ItemRegistries.ABYSSAL_WARLOCK_LEGGINGS.get(),
                    ItemRegistries.ABYSSAL_WARLOCK_BOOTS.get());
            AzArmorRendererRegistry.register(AbyssalWarlockMaskRenderer::new, ItemRegistries.ABYSSAL_WARLOCK_MASK.get());

            AzArmorRendererRegistry.register(IgnisWizardArmorRenderer::new,
                    ItemRegistries.IGNITIUM_WIZARD_HELMET.get(),
                    ItemRegistries.IGNITIUM_WIZARD_CHESTPLATE.get(),
                    ItemRegistries.IGNITIUM_WIZARD_LEGGINGS.get(),
                    ItemRegistries.IGNITIUM_WIZARD_BOOTS.get());
            AzArmorRendererRegistry.register(IgnisWizardElytraArmorRenderer::new, ItemRegistries.IGNITIUM_WIZARD_CHESTPLATE_ELYTRA.get());

            AzArmorRendererRegistry.register(CursiumMageArmorRenderer::new,
                    ItemRegistries.CURSIUM_MAGE_HELMET.get(),
                    ItemRegistries.CURSIUM_MAGE_CHESTPLATE.get(),
                    ItemRegistries.CURSIUM_MAGE_LEGGINGS.get(),
                    ItemRegistries.CURSIUM_MAGE_BOOTS.get());
            AzArmorRendererRegistry.register(CursiumMageElytraArmorRenderer::new, ItemRegistries.CURSIUM_MAGE_CHESTPLATE_ELYTRA.get());

            AzArmorRendererRegistry.register(PharaohMageArmorRenderer::new,
                    ItemRegistries.PHARAOH_MAGE_HELMET.get(),
                    ItemRegistries.PHARAOH_MAGE_CHESTPLATE.get(),
                    ItemRegistries.PHARAOH_MAGE_LEGGINGS.get(),
                    ItemRegistries.PHARAOH_MAGE_BOOTS.get());

            AzArmorRendererRegistry.register(BloomStoneMageArmorRenderer::new,
                    ItemRegistries.BLOOM_STONE_HAT.get(),
                    ItemRegistries.BLOOM_STONE_CHESTPLATE.get(),
                    ItemRegistries.BLOOM_STONE_SKIRT.get(),
                    ItemRegistries.BLOOM_STONE_GREAVES.get());

            AzArmorRendererRegistry.register(MonstrousWizardHatArmorRenderer::new, ItemRegistries.MONSTROUS_WIZARD_HAT.get());

            AzArmorRendererRegistry.register(EngineerMageArmorRenderer::new,
                    ItemRegistries.ENGINEER_MAGE_HOOD.get(),
                    ItemRegistries.ENGINEER_MAGE_SUIT.get(),
                    ItemRegistries.ENGINEER_MAGE_LEGGINGS.get(),
                    ItemRegistries.ENGINEER_MAGE_BOOTS.get());

            AzArmorRendererRegistry.register(ExcelsiusCooldownArmorRenderer::new,
                    ItemRegistries.EXCELSIUS_SPEED_HELMET.get(),
                    ItemRegistries.EXCELSIUS_SPEED_CHESTPLATE.get());

            AzArmorRendererRegistry.register(ExcelsiusPowerArmorRenderer::new,
                    ItemRegistries.EXCELSIUS_POWER_HELMET.get(),
                    ItemRegistries.EXCELSIUS_POWER_CHESTPLATE.get());

            AzArmorRendererRegistry.register(ExcelsiusResistArmorRenderer::new,
                    ItemRegistries.EXCELSIUS_RESIST_HELMET.get(),
                    ItemRegistries.EXCELSIUS_RESIST_CHESTPLATE.get());

            AzArmorRendererRegistry.register(ExcelsiusLegArmorRenderer::new,
                    ItemRegistries.EXCELSIUS_WARLOCK_LEGGINGS.get(),
                    ItemRegistries.EXCELSIUS_WARLOCK_BOOTS.get());

            // Item Rendering Registry
            AzItemRendererRegistry.register(CodexOfMaliceSpellBookRenderer::new, ItemRegistries.CODEX_OF_MALICE.get());
            //AzItemRendererRegistry.register(DiscDriverSpellbookRenderer::new, ItemRegistries.DISC_DRIVER.get());
            AzItemRendererRegistry.register(SpiritSundererStaffRenderer::new, ItemRegistries.SPIRIT_SUNDERER_STAFF.get());
            /*AzItemRendererRegistry.register(GauntletOfPowerRenderer::new, ItemRegistries.GAUNTLET_OF_POWER.get());
            AzItemRendererRegistry.register(GauntletOfGattlingRenderer::new, ItemRegistries.GAUNTLET_OF_GATTLING.get());
            AzItemRendererRegistry.register(TheNightStalkerRenderer::new, ItemRegistries.THE_NIGHTSTALKER.get());
            AzItemRendererRegistry.register(TheBerserkerRenderer::new, ItemRegistries.THE_BERSERKER.get());
            AzItemRendererRegistry.register(TheCombusterRenderer::new, ItemRegistries.THE_COMBUSTER.get());
            AzItemRendererRegistry.register(MurasamaBladeRenderer::new, ItemRegistries.MURASAMA.get());
            AzItemRendererRegistry.register(BurstSheathRenderer::new, ItemRegistries.BURST_SHEATH.get());*/
        }
    }

    public static ResourceLocation id(@NotNull String path)
    {
        return ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, path);
    }
}
