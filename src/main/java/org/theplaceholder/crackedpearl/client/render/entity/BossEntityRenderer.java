package org.theplaceholder.crackedpearl.client.render.entity;

import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.theplaceholder.crackedpearl.CrackedPearlMod;
import org.theplaceholder.crackedpearl.client.model.entity.BossEntityModel;
import org.theplaceholder.crackedpearl.entity.BossEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BossEntityRenderer extends GeoEntityRenderer<BossEntity> {

    public BossEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BossEntityModel());
    }

    @Override
    public Identifier getTexture(BossEntity entity) {
        return CrackedPearlMod.id("textures/entity/boss.png");
    }

    @Override
    public void render(BossEntity entity, float tick, float yaw, MatrixStack matrixStack, VertexConsumerProvider vertexConsumer, int light) {
        super.render(entity, tick, yaw, matrixStack, vertexConsumer, LightmapTextureManager.MAX_LIGHT_COORDINATE);
    }
}
