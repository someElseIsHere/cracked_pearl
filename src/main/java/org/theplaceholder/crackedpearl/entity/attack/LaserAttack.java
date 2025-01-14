package org.theplaceholder.crackedpearl.entity.attack;

import org.theplaceholder.crackedpearl.sound.CrPeSoundEvents;

public class LaserAttack extends Attack {

    public LaserAttack(AttackManager manager) {
        super(manager);
    }

    @Override
    public void tick() {
        if (this.ticks == 0) {
            this.manager.getBoss().playSound(CrPeSoundEvents.LASER0.get(), 1f, 1f);
        }
        super.tick();
    }

    @Override
    public String getAnimation() {
        return "cracked_pearl.animation.boss.laser0";
    }

    @Override
    public int getDuration() {
        return 45;
    }
}
