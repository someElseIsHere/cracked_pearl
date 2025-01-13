package org.theplaceholder.crackedpearl.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.theplaceholder.crackedpearl.CrackedPearlMod;
import org.theplaceholder.crackedpearl.client.model.entity.BossEntityModel;
import org.theplaceholder.crackedpearl.client.render.entity.BossEntityRenderer;
import org.theplaceholder.crackedpearl.entity.CrPeEntityTypes;

@Mod.EventBusSubscriber(modid = CrackedPearlMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CrPeClientEventBus {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CrPeEntityTypes.BOSS.get(), BossEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BossEntityModel.LAYER_ID, BossEntityModel::getTexturedModelData);
    }}
