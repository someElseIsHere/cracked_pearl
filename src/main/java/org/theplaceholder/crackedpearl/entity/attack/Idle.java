package org.theplaceholder.crackedpearl.entity.attack;

public class Idle extends Action {
    private int ticks;

    public Idle(AttackManager manager) {
        super(manager);
        this.ticks = manager.getBoss().getRandom().nextInt(90) + 10;
    }

    @Override
    public void tick() {
        if (this.ticks <= 0) {
            this.manager.nextAction();
        }
        this.ticks--;
    }

    @Override
    public String getAnimation() {
        return "cracked_pearl.animation.boss.idle";
    }
}
