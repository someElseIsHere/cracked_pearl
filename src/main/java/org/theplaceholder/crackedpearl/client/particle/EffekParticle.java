package org.theplaceholder.crackedpearl.client.particle;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;

public class EffekParticle extends Particle {
    private boolean effekStarted;
    private final ParticleEmitterInfo emitterInfo;

    public EffekParticle(ClientWorld world, Vec3d pos, ParticleEmitterInfo emitterInfo) {
        this(world, pos.x, pos.y, pos.z, emitterInfo);
    }

    public EffekParticle(ClientWorld world, double x, double y, double z, ParticleEmitterInfo emitterInfo) {
        super(world, x, y, z, 0, 0, 0);
        this.emitterInfo = emitterInfo.clone().position(x, y, z);
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {}

    @Override
    public void tick() {
        if (!this.effekStarted) {
            this.effekStarted = true;
            AAALevel.addParticle(world, true, this.emitterInfo);
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.NO_RENDER;
    }
}
