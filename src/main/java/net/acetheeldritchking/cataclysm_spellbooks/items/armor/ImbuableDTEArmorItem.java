package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ImbuableDTEArmorItem extends CSArmorItem implements IPresetSpellContainer {
    public ImbuableDTEArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, AttributeContainer... attributeContainers) {
        super(material, type, properties, attributeContainers);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null)
        {
            return;
        }

        if (itemStack.getItem() instanceof ArmorItem armorItem)
        {
            if (armorItem.getType() == Type.CHESTPLATE || armorItem.getType() == Type.HELMET)
            {
                if (!ISpellContainer.isSpellContainer(itemStack))
                {
                    var spellContainer = ISpellContainer.create(1, true, true);
                    itemStack.set(ComponentRegistry.SPELL_CONTAINER, spellContainer);
                }
            }
        }
    }
}
