package org.theplaceholder.crackedpearl.client.model.entity;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import org.theplaceholder.crackedpearl.CrackedPearlMod;
import org.theplaceholder.crackedpearl.entity.BossEntity;
import software.bernie.geckolib.model.GeoModel;

public class BossEntityModel extends GeoModel<BossEntity> {
    public static final EntityModelLayer LAYER_ID = new EntityModelLayer(CrackedPearlMod.id("boss"), "main");

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(PlayerEntityModel.getTexturedModelData(Dilation.NONE, false), 64, 64);
    }

    @Override
    public Identifier getModelResource(BossEntity bossEntity) {
        return CrackedPearlMod.id("geo/boss.json");
    }

    @Override
    public Identifier getTextureResource(BossEntity bossEntity) {
        return CrackedPearlMod.id("textures/entity/boss.png");
    }

    @Override
    public Identifier getAnimationResource(BossEntity bossEntity) {
        return CrackedPearlMod.id("animations/boss.json");
    }


}
