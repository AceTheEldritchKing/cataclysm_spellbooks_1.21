package net.acetheeldritchking.cataclysm_spellbooks.items.spellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import net.acetheeldritchking.cataclysm_spellbooks.entity.render.items.CodexOfMaliceSpellBookRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.function.Consumer;

public class CodexOfMaliceSpellBook extends SpellBook implements mod.azure.azurelib.common.api.common.animatable.GeoItem {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public CodexOfMaliceSpellBook() {
        super(12, ItemPropertiesHelper.equipment().fireResistant().stacksTo(1));
        withSpellbookAttributes(
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.30F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        // Guh
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // Creates the renderer
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer)
    {
        consumer.accept(new RenderProvider()
        {
            private CodexOfMaliceSpellBookRenderer renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                if (renderer == null) {
                    renderer = new CodexOfMaliceSpellBookRenderer();
                }

                return this.renderer;
            }
        });
    }
}
