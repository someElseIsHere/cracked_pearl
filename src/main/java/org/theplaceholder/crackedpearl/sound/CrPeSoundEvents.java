package org.theplaceholder.crackedpearl.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.theplaceholder.crackedpearl.CrackedPearlMod;

public class CrPeSoundEvents {
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CrackedPearlMod.MOD_ID);

    public static final RegistryObject<SoundEvent> LASER0 = register("laser0");

    private static RegistryObject<SoundEvent> register(String id) {
        return SOUND_EVENTS.register(id, () -> SoundEvent.of(CrackedPearlMod.id(id)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
