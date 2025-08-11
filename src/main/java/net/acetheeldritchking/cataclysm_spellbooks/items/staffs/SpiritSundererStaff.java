package net.acetheeldritchking.cataclysm_spellbooks.items.staffs;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;

public class SpiritSundererStaff extends StaffItem {
    public SpiritSundererStaff() {
        super(ItemPropertiesHelper.equipment(1).attributes(ExtendedSwordItem.createAttributes(CSStaffTiers.SPIRIT_SUNDERER_STAFF)));
    }
}
