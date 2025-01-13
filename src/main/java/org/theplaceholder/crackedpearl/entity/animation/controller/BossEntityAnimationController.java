package org.theplaceholder.crackedpearl.entity.animation.controller;

import org.theplaceholder.crackedpearl.entity.BossEntity;
import org.theplaceholder.crackedpearl.entity.animation.handler.BossEntityKeyframeHandler;
import org.theplaceholder.crackedpearl.entity.animation.handler.BossEntitySoundKeyframeHandler;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class BossEntityAnimationController extends AnimationController<BossEntity> {

    public BossEntityAnimationController(BossEntity animatable) {
        super(animatable, "controller", 0, BossEntityAnimationController::predicate);
        this.soundKeyframeHandler = new BossEntitySoundKeyframeHandler();
        this.customKeyframeHandler = new BossEntityKeyframeHandler();
    }

    private static PlayState predicate(AnimationState<BossEntity> animation) {
        AnimationController<BossEntity> controller = animation.getController();

        controller.setAnimation(RawAnimation.begin().then("cracked_pearl.animation.boss.invoke", Animation.LoopType.LOOP));

        return PlayState.CONTINUE;
    }
}
