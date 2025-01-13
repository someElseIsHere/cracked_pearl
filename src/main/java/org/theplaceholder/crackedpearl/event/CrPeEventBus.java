package org.theplaceholder.crackedpearl.event;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Pair;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;
import org.theplaceholder.crackedpearl.entity.CrPeEntityTypes;

import java.util.function.Supplier;

public class CrPeEventBus {

    @SubscribeEvent
    @SuppressWarnings("unchecked")
    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        for (Pair<RegistryObject<?>, Supplier<DefaultAttributeContainer>> pair : CrPeEntityTypes.ENTITY_ATTRIBUTES) {
            event.put(((RegistryObject<EntityType<? extends LivingEntity>>) pair.getLeft()).get(), pair.getRight().get());
        }
    }

    public static void register(IEventBus eventBus) {
        eventBus.register(new CrPeEventBus());
    }
}
