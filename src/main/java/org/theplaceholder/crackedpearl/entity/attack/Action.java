package org.theplaceholder.crackedpearl.entity.attack;

public abstract class Action {
    protected final AttackManager manager;

    public Action(AttackManager manager) {
        this.manager = manager;
    }

    public abstract void tick();
    public abstract String getAnimation();
}
