package org.theplaceholder.crackedpearl.util;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.theplaceholder.crackedpearl.CrackedPearlMod;

public class Utils {
    public static ParticleEmitterInfo spawnAAAParticles(Vec3d pos, String id) {
        World world = MinecraftClient.getInstance().world;
        ParticleEmitterInfo info = ParticleEmitterInfo.create(world, CrackedPearlMod.id(id));
        info.position(pos);
        AAALevel.addParticle(world, true, info);
        return info;
    }
}
