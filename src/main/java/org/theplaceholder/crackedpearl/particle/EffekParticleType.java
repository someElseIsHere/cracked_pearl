package org.theplaceholder.crackedpearl.particle;

import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.particle.DefaultParticleType;

public class EffekParticleType extends DefaultParticleType {
    private ParticleEmitterInfo info;

    public EffekParticleType(ParticleEmitterInfo info) {
        super(true);
        this.info = info;
    }

    public ParticleEmitterInfo getInfo() {
        return this.info.clone();
    }
}
