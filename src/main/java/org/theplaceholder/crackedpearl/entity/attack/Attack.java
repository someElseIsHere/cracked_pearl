package org.theplaceholder.crackedpearl.entity.attack;

public abstract class Attack extends Action {
    protected int ticks;

    public Attack(AttackManager manager) {
        super(manager);
    }

    @Override
    public void tick() {
        if (ticks >= getDuration()) {
            this.manager.setIdle();
        }
        ticks++;
    }

    public abstract int getDuration();
}
