package org.theplaceholder.crackedpearl.particle;

import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.particle.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.theplaceholder.crackedpearl.CrackedPearlMod;

public class CrPeParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CrackedPearlMod.MOD_ID);

    public static final RegistryObject<EffekParticleType> LASER0 = register("laser0");

    private static RegistryObject<EffekParticleType> register(String id) {
        return PARTICLE_TYPES.register(id, () -> new EffekParticleType(new ParticleEmitterInfo(CrackedPearlMod.id(id))));
    }

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
