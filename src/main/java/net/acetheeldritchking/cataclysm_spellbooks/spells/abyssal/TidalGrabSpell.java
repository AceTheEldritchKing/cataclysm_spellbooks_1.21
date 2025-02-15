package net.acetheeldritchking.cataclysm_spellbooks.spells.abyssal;

import com.github.L_Ender.cataclysm.Attachment.TidalTentacleAttachment;
import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Tentacle_Entity;
import com.github.L_Ender.cataclysm.entity.util.TidalTentacleUtil;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSSchoolRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class TidalGrabSpell extends AbstractAbyssalSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "tidal_grab");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.cataclysm_spellbooks.range",
                        Utils.stringTruncation(getRange(spellLevel, caster)/10, 2)));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(CSSchoolRegistry.ABYSSAL_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(50)
            .build();

    public TidalGrabSpell()
    {
        this.manaCostPerLevel = 1;
        this.baseSpellPower = 0;
        this.spellPowerPerLevel = 5;
        this.castTime = 100;
        this.baseManaCost = 10;
    }

    @Override
    public boolean canBeCraftedBy(Player player) {
        Item tidalClaws = ModItems.TIDAL_CLAWS.get();
        return player.getMainHandItem().is(tidalClaws);
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.CONTINUOUS;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(ModSounds.TIDAL_TENTACLE.get());
    }

    @Override
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        return Utils.preCastTargetHelper(level, entity, playerMagicData, this, (int)getRange(spellLevel, entity)/10, 0.15f);
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        //Vec3 casterEyePosition = entity.getEyePosition(1.0F);
        if (playerMagicData.getAdditionalCastData() instanceof TargetEntityCastData targetEntityCastData)
        {
            var targetEntity = targetEntityCastData.getTarget((ServerLevel) level);
            if (targetEntity != null)
            {
                Entity validTarget = null;
                var hitResult = Utils.raycastForEntity(level, entity, getRange(spellLevel, entity)/10, true, 0.25F);
                if (hitResult.getType() == HitResult.Type.ENTITY)
                {
                    Entity target = ((EntityHitResult)hitResult).getEntity();
                    if (!target.equals(entity) && !entity.isAlliedTo(target) &&
                            !target.isAlliedTo(entity) && target instanceof Mob &&
                            entity.hasLineOfSight(target))
                    {
                        //System.out.println("Hit Result");
                        validTarget = target;
                    }
                    else
                    {
                        Iterator<LivingEntity> iterator = level.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(10.0D)).iterator();

                        //System.out.println("Beginning of loop");
                        while (true)
                        {
                            Entity e;
                            // This should create the tentacles
                            do {
                                //System.out.println("Inside the loop, while target is in line of sight");
                                do {
                                    //System.out.println("Line of sight");
                                    do {
                                        //System.out.println("Instance of Mob");
                                        do {
                                            //System.out.println("Target allied to caster");
                                            do {
                                                //System.out.println("caster allied to target");
                                                do {
                                                    //System.out.println("If target is the target");
                                                    if (!iterator.hasNext())
                                                    {
                                                        //System.out.println("Launch tentacle");
                                                        this.launchTentacle(entity, (LivingEntity) validTarget, level);
                                                        return;
                                                    }

                                                    e = iterator.next();
                                                } while (e.equals(entity));
                                            } while (entity.isAlliedTo(e));
                                        } while (e.isAlliedTo(entity));
                                    } while (!(e instanceof Mob));
                                } while (!entity.hasLineOfSight(e));
                            }
                            while (validTarget != null && !(entity.distanceTo(e) < entity.distanceTo(validTarget)));

                            validTarget = e;
                        }
                    }

                    //System.out.println("Launch tentacle");
                    this.launchTentacle(entity, (LivingEntity) validTarget, level);
                }
            }
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private void launchTentacle(LivingEntity caster, LivingEntity target, Level level)
    {
        TidalTentacleAttachment attachment = caster.getData(ModDataAttachments.TIDAL_TENTACLE_ATTACHMENT);
        if (!attachment.hasTentacle() && TidalTentacleUtil.canLaunchTentacles(level, caster) && !level.isClientSide && target != null)
        {
            Tidal_Tentacle_Entity tentacle = ModEntities.TIDAL_TENTACLE.get().create(level);
            assert tentacle != null;
            tentacle.copyPosition(caster);
            level.addFreshEntity(tentacle);

            tentacle.setCreatorEntityUUID(caster.getUUID());
            tentacle.setFromEntityID(caster.getId());
            tentacle.setToEntityID(target.getId());
            tentacle.copyPosition(caster);
            tentacle.setProgress(0.0F);
            TidalTentacleUtil.setLastTentacle(caster, tentacle);
        }
    }

    private float getRange(int spellLevel, LivingEntity caster)
    {
        return getSpellPower(spellLevel, caster) * (2 * spellLevel);
    }
}
