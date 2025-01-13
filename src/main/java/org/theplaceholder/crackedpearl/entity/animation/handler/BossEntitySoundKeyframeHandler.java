package org.theplaceholder.crackedpearl.entity.animation.handler;

import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.theplaceholder.crackedpearl.client.util.ClientUtils;
import org.theplaceholder.crackedpearl.entity.BossEntity;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.keyframe.event.SoundKeyframeEvent;

public class BossEntitySoundKeyframeHandler implements AnimationController.SoundKeyframeHandler<BossEntity> {

    @Override
    public void handle(SoundKeyframeEvent<BossEntity> event) {
        String[] segments = event.getKeyframeData().getSound().split("\\|");
        SoundEvent sound = Registries.SOUND_EVENT.get(Identifier.tryParse(segments[0]));
        if (sound != null) {
            ClientUtils.playSoundFromEntity(sound, SoundCategory.HOSTILE, 1f, 1f, event.getAnimatable());
        }
    }
}
