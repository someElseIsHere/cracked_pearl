package org.theplaceholder.crackedpearl.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Pair;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.theplaceholder.crackedpearl.CrackedPearlMod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CrPeEntityTypes {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CrackedPearlMod.MOD_ID);
    public static final List<Pair<RegistryObject<?>, Supplier<DefaultAttributeContainer>>> ENTITY_ATTRIBUTES = new ArrayList<>();

    public static final RegistryObject<EntityType<BossEntity>> BOSS = register(
            "boss",
            EntityType.Builder.create(BossEntity::new, SpawnGroup.MISC)
                    .makeFireImmune()
                    .setDimensions(0.6F, 1.8F)
                    .maxTrackingRange(32)
                    .trackingTickInterval(2),
            () -> MobEntity.createMobAttributes()
                    .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 24)
                    .add(EntityAttributes.GENERIC_MAX_HEALTH, 2e6)
                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.75)
                    .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32)
                    .build()
    );

    private static <T extends LivingEntity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> entityBuilder, Supplier<DefaultAttributeContainer> attribute) {
        RegistryObject<EntityType<T>> entityType = register(id, entityBuilder);
        ENTITY_ATTRIBUTES.add(new Pair<>(entityType, attribute));
        return entityType;
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> entityBuilder) {
        return ENTITY_TYPES.register(id, () -> entityBuilder.build(CrackedPearlMod.MOD_ID + ":" + id));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
