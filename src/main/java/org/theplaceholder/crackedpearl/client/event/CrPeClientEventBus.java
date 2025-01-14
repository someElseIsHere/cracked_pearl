package org.theplaceholder.crackedpearl.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.theplaceholder.crackedpearl.CrackedPearlMod;
import org.theplaceholder.crackedpearl.client.model.entity.BossEntityModel;
import org.theplaceholder.crackedpearl.client.particle.EffekParticle;
import org.theplaceholder.crackedpearl.client.render.entity.BossEntityRenderer;
import org.theplaceholder.crackedpearl.entity.CrPeEntityTypes;
import org.theplaceholder.crackedpearl.particle.CrPeParticleTypes;
import org.theplaceholder.crackedpearl.particle.EffekParticleType;

@Mod.EventBusSubscriber(modid = CrackedPearlMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CrPeClientEventBus {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CrPeEntityTypes.BOSS.get(), BossEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BossEntityModel.LAYER_ID, BossEntityModel::getTexturedModelData);
    }

    @SubscribeEvent
    public static void onRegisterParticleProviders(RegisterParticleProvidersEvent event) {
        CrPeParticleTypes.PARTICLE_TYPES.getEntries().forEach(particleObject -> {
            if (particleObject.get() instanceof EffekParticleType effekParticleType) {
                event.registerSpecial(effekParticleType,
                        (parameters, world, x, y, z, vX, vY, vZ)
                                -> new EffekParticle(world, x, y, z, ((EffekParticleType) parameters).getInfo())
                );
            }
        });
    }
}
