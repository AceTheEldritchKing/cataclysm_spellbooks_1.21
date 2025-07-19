package net.acetheeldritchking.cataclysm_spellbooks.events;

import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.lionfishapi.server.event.StandOnFluidEvent;
import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
//import net.acetheeldritchking.cataclysm_spellbooks.capabilities.wrath.PlayerWrath;
//import net.acetheeldritchking.cataclysm_spellbooks.capabilities.wrath.PlayerWrathProvider;
import net.acetheeldritchking.cataclysm_spellbooks.Config;
import net.acetheeldritchking.cataclysm_spellbooks.effects.potion.AbyssalPredatorPotionEffect;
import net.acetheeldritchking.cataclysm_spellbooks.effects.potion.CursedFrenzyEffect;
import net.acetheeldritchking.cataclysm_spellbooks.effects.potion.WrathfulPotionEffect;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSPotionEffectRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.ItemRegistries;
import net.acetheeldritchking.cataclysm_spellbooks.registries.SpellRegistries;
import net.acetheeldritchking.cataclysm_spellbooks.util.CSUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.io.StringReader;

@SuppressWarnings("unused")
@EventBusSubscriber
public class ServerEvents {

    @SubscribeEvent
    public static void onLivingPreDamageEvent(LivingDamageEvent.Pre event)
    {
        Entity entity = event.getSource().getEntity();

        //System.out.println("Event?");

        if (entity instanceof LivingEntity attacker)
        {
            // ABYSSAL PREDATOR
            if (attacker.hasEffect(CSPotionEffectRegistry.ABYSSAL_PREDATOR_EFFECT))
            {

                //System.out.println("Has effect?");
                int effectLevel = attacker.getEffect(CSPotionEffectRegistry.ABYSSAL_PREDATOR_EFFECT).getAmplifier() + 1;
                float baseAmount = event.getOriginalDamage();
                float damageBonusPerLevel = AbyssalPredatorPotionEffect.ATTACK_DAMAGE_BONUS_PER_LEVEL * effectLevel;
                float bonusDamage = baseAmount * damageBonusPerLevel;
                float totalDamage = baseAmount + bonusDamage;

                // Now do the bonus when underwater
                if (attacker.isInWaterOrRain())
                {
                    //System.out.println("In water?");

                    //System.out.println("Base: " + baseAmount);
                    //System.out.println("bonus per level: " + damageBonusPerLevel);
                    //System.out.println("bonus damage: " + bonusDamage);
                    //System.out.println("Total: " + totalDamage);
                    event.setNewDamage(totalDamage);
                }
            }
        }

        // Ignis Wizard armor
        LivingEntity livingEntity = event.getEntity();
        ItemStack legEquipment = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
        if (!legEquipment.isEmpty() && event.getEntity() != null &&
                event.getSource().getEntity() != null &&
                legEquipment.getItem() == ItemRegistries.IGNITIUM_WIZARD_LEGGINGS.get())
        {
            Entity attacker = event.getSource().getEntity();
            if (attacker instanceof LivingEntity livingAttacker && attacker != event.getEntity() && event.getEntity().getRandom().nextFloat() < 0.5F)
            {
                MobEffectInstance mobEffectInstance = livingAttacker.getEffect(ModEffect.EFFECTBLAZING_BRAND);

                int i = 1;
                if (mobEffectInstance != null)
                {
                    i = i + mobEffectInstance.getAmplifier();
                    livingAttacker.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                }
                else
                {
                    i = i + 1;
                }

                i = Mth.clamp(i, 0, 2);
                MobEffectInstance effectInstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, i, false, false, true);
                (livingAttacker).addEffect(effectInstance);
                if (!attacker.isOnFire())
                {
                    attacker.setRemainingFireTicks(5);
                }
            }
        }

        // Forgone Rage
        /*
        if (entity instanceof LivingEntity attacker)
        {
            if (attacker.hasEffect(CSPotionEffectRegistry.WRATHFUL))
            {
                if (attacker instanceof Player player)
                {
                    player.getCapability(PlayerWrathProvider.PLAYER_WRATH).ifPresent(wrath -> {
                        wrath.addWrath(1);

                        float baseAmount = event.getAmount();
                        float damageBonusPerLevel = WrathfulPotionEffect.ATTACK_DAMAGE_PER_WRATH * wrath.getWrath();
                        float bonusDamage = baseAmount * damageBonusPerLevel;
                        float totalDamage = baseAmount + bonusDamage;

                        event.setAmount(totalDamage);
                        //System.out.println("Damage: " + totalDamage);
                    });

                    player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.MALEDICTUS_SHORT_ROAR.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
        */
    }

    @SubscribeEvent
    public static void onLivingTickEvent(EntityTickEvent.Pre event)
    {
        Entity entity = event.getEntity();
        Level level = entity.level();
        if (!level.isClientSide)
        {
            if (entity instanceof LivingEntity livingEntity)
            {
                // ABYSSAL PREDATOR
                if (livingEntity.hasEffect(CSPotionEffectRegistry.ABYSSAL_PREDATOR_EFFECT))
                {
                    int effectLevel = livingEntity.getEffect(CSPotionEffectRegistry.ABYSSAL_PREDATOR_EFFECT).getAmplifier() + 1;
                    float baseMovementSpeed = livingEntity.getSpeed();
                    float speedBonusPerLevel = AbyssalPredatorPotionEffect.MOVEMENT_SPEED_BONUS_PER_LEVEL * effectLevel;
                    float bonusSpeed = baseMovementSpeed * speedBonusPerLevel;
                    float totalSpeed = baseMovementSpeed + bonusSpeed;

                    if (livingEntity.isInWaterOrRain())
                    {
                        livingEntity.setSpeed(totalSpeed);
                    }
                    else
                    {
                        livingEntity.setSpeed(baseMovementSpeed);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    // Changed from spawn to join level so that mobs from special spawns can be counted
    // Keep in mind that all cataclysm mobs use special spawn for respawning
    public static void handleResistanceAttributeSpawn(EntityJoinLevelEvent event) {
        // Makes so this only works if bosses config is set to true (true by default)
        boolean resistancesConfig = Config.BOSSES_RESISTANCES.get();
        if (resistancesConfig) {

            // Making sure mob is a living entity so neoforge doesn't have a stroke
            var entity = event.getEntity();
            if (!(entity instanceof LivingEntity mob)) return;

            if (mob.getType() == ModEntities.IGNIS.get()) {
                // Ignis takes extra abyssal damage, and less fire damage
                addIfNonNull(mob, CSAttributeRegistry.ABYSSAL_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.FIRE_MAGIC_RESIST, 0.5, "cats_add");
            }
            if (mob.getType() == ModEntities.THE_LEVIATHAN.get()) {
                // Leviathan takes extra lightning damage, and less abyssal damage
                addIfNonNull(mob, AttributeRegistry.LIGHTNING_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, CSAttributeRegistry.ABYSSAL_MAGIC_RESIST, 0.5, "cats_add");
            }
            if (mob.getType() == ModEntities.ENDER_GUARDIAN.get()) {
                // Ender Guardian takes extra ice damage, and less ender damage
                addIfNonNull(mob, AttributeRegistry.ICE_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.ENDER_MAGIC_RESIST, 0.5, "cats_add");
            }
            if (mob.getType() == ModEntities.THE_HARBINGER.get()) {
                // Harbinger takes extra lightning damage, and less blood damage
                addIfNonNull(mob, AttributeRegistry.LIGHTNING_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.BLOOD_MAGIC_RESIST, 0.5, "cats_add");
            }
            if (mob.getType() == ModEntities.ANCIENT_REMNANT.get()) {
                // Ancient Remnant takes extra holy damage, and less fire damage(?)
                addIfNonNull(mob, AttributeRegistry.HOLY_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.FIRE_MAGIC_RESIST, 0.5, "cats_add");
            }
            if (mob.getType() == ModEntities.NETHERITE_MONSTROSITY.get()) {
                // Netherite Monstrosity takes extra ice damage, and less fire damage
                addIfNonNull(mob, AttributeRegistry.ICE_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.FIRE_MAGIC_RESIST, 0.5, "cats_add");
            }
            if (mob.getType() == ModEntities.MALEDICTUS.get()) {
                // Maledictus takes extra eldritch damage, and less ice damage
                addIfNonNull(mob, AttributeRegistry.ELDRITCH_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.ICE_MAGIC_RESIST, 0.5, "cats_add");
            }
            /* Added Scylla tag for future use
            if (mob.getType() == ModEntities.SCYLLA.get())
            {
                // Scylla takes extra nature damage, and less ice damage
                addIfNonNull(mob, AttributeRegistry.NATURE_MAGIC_RESIST, -0.5, "cats_subtract");
                addIfNonNull(mob, AttributeRegistry.LIGHTNING_MAGIC_RESIST, 0.5, "cats_add");
            }
            */
        }
    }

    @SubscribeEvent
    public static void standOnFluidEvent(StandOnFluidEvent event)
    {
        LivingEntity entity = event.getEntity();
        ItemStack bootEquipment = entity.getItemBySlot(EquipmentSlot.FEET);

        if (!bootEquipment.isEmpty() && bootEquipment.getItem() == ItemRegistries.IGNITIUM_WIZARD_BOOTS.get() &&
                !entity.isShiftKeyDown() &&
                (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA)))
        {
            event.setCanceled(true);
        }
    }

    // New event system for entities
    // It adds attributes on event trigger, instead of setting them
    private static void addIfNonNull(LivingEntity entity, Holder<Attribute> attribute, double value, String idName) {
        var instance = entity.getAttributes().getInstance(attribute);
        if (instance == null) return;

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("cataclysm_spellbooks", idName);

        // Avoid duplicates
        if (instance.getModifiers().stream().noneMatch(mod -> mod.id().equals(id))) {
            instance.addPermanentModifier(new AttributeModifier(id, value, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    /* Old event system for entities
    // Using same code from ISS for dealing with mob attributes, please forgive me
    private static void addIfNonNull(LivingEntity entity, Holder<Attribute> attribute, double value)
    {
        var instance = entity.getAttributes().getInstance(attribute);
        if (instance != null)
        {
            instance.setBaseValue(value);
        }
    }
     */

    // Modify Spell Event
    @SubscribeEvent
    public static void onSpellModifyEvent(ModifySpellLevelEvent event)
    {
        /*
        if (event.getEntity().getItemBySlot(EquipmentSlot.MAINHAND).is(ItemRegistries.BLOOM_STONE_STAFF.get()))
        {
            if (event.getSpell().equals(SpellRegistries.AMETHYST_PUNCTURE.get()))
            {
                event.addLevels(1);
                //System.out.println("Added spell level");
                //System.out.println("spell level: " + event.getLevel());
            }
        }
         */
    }

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event)
    {
        /*
        Entity entity = event.getEntity();
        MobEffect effect = event.getEffect();
        if (entity instanceof LivingEntity livingEntity)
        {
            if (effect instanceof WrathfulPotionEffect)
            {
                if (livingEntity.hasEffect(effect) && livingEntity instanceof Player player)
                {
                    player.getCapability(PlayerWrathProvider.PLAYER_WRATH).ifPresent(wrath -> {

                        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false, false));
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10*20, 1 + wrath.getWrath(), false, true, true));
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10*20, 1 + wrath.getWrath(), false, true, true));

                        wrath.resetWrath();
                    });
                    //System.out.println("Poof!");
                }
            }
        }

         */
    }

    @SubscribeEvent
    public static void onEffectExpire(MobEffectEvent.Expired event)
    {

        Entity entity = event.getEntity();
        Holder<MobEffect> effect = event.getEffectInstance().getEffect();
        /*
        if (entity instanceof LivingEntity livingEntity)
        {
            // Wrathful
            if (effect instanceof WrathfulPotionEffect)
            {
                if (livingEntity.hasEffect(effect) && livingEntity instanceof Player player)
                {
                    player.getCapability(PlayerWrathProvider.PLAYER_WRATH).ifPresent(wrath -> {

                        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false, false));
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10*20, 1 + wrath.getWrath(), false, true, true));
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10*20, 1 + wrath.getWrath(), false, true, true));

                        wrath.resetWrath();
                    });

                    //System.out.println("Poof!");
                }
            }
            */

        // Cursed Frenzy
        if (effect instanceof CursedFrenzyEffect)
        {
            if (!entity.level().isClientSide())
            {
                System.out.println("Potion Effect!");
                CSUtils.spawnHalberdWindmill(5, 5, 1.0F, 0.5F, 0.5F, 1, (LivingEntity) entity, entity.level(), 5, 1);
            }
        }
    }

    @SubscribeEvent
    public static void onFallEvent(LivingFallEvent event)
    {
        Entity entity = event.getEntity();

        // Cursium Boots
        if (entity instanceof LivingEntity livingEntity)
        {
            if (!livingEntity.getItemBySlot(EquipmentSlot.FEET).isEmpty() &&
                    livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemRegistries.CURSIUM_MAGE_BOOTS.get())
            {
                event.setDistance(event.getDistance() * 0.3F);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event)
    {
        DamageSource damageSource = event.getSource();
        Entity entity = event.getEntity();

        // Cursium Chestplate
        if (entity instanceof LivingEntity livingEntity)
        {
            if
            (
                    !livingEntity.level().isClientSide &&
                            !damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) &&
                            CSUtils.tryCurisumChestplateRebirth(livingEntity)
            )
            {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingAttackEvent(LivingIncomingDamageEvent event) {
        Entity entity = event.getEntity();

        // Cursium Legs
        if (entity instanceof LivingEntity livingEntity) {
            if (!livingEntity.getItemBySlot(EquipmentSlot.LEGS).isEmpty() &&
                    livingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemRegistries.CURSIUM_MAGE_LEGGINGS.get()) {
                if (event.getSource().is(DamageTypeTags.IS_PROJECTILE)) {
                    if (livingEntity.getRandom().nextFloat() < 0.15F) {
                        event.setCanceled(true);
                    }
                } else if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    if (livingEntity.getRandom().nextFloat() < 0.08F) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    // Capabilities
    /*
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player)
        {
            // Wrath
            if (!event.getObject().getCapability(PlayerWrathProvider.PLAYER_WRATH).isPresent())
            {
                event.addCapability(new ResourceLocation(CataclysmSpellbooks.MOD_ID, "wrath"), new PlayerWrathProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerWrath.class);
    }
    */
}