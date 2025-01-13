package org.theplaceholder.crackedpearl.entity.animation.handler;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.theplaceholder.crackedpearl.entity.BossEntity;
import org.theplaceholder.crackedpearl.util.Utils;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.keyframe.event.CustomInstructionKeyframeEvent;

public class BossEntityKeyframeHandler implements AnimationController.CustomKeyframeHandler<BossEntity> {
    @Override
    public void handle(CustomInstructionKeyframeEvent<BossEntity> event) {
        String instruction = event.getKeyframeData().getInstructions();
        if (instruction.equals("invoke")) {
            Entity entity = event.getAnimatable();
            Vec3d vec3d = entity.getPos().add(0, 2.75, 0);
            Utils.spawnAAAParticles(vec3d, "laser0").bindOnEntity(entity);
        }
    }
}
