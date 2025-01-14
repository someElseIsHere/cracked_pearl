package org.theplaceholder.crackedpearl.entity.attack;

import org.theplaceholder.crackedpearl.entity.BossEntity;
import org.theplaceholder.crackedpearl.util.RandomCollection;

import java.util.function.Function;

public class AttackManager {
    private final RandomCollection<Function<AttackManager, Action>> attacks;
    private Action currentAttack;
    private final BossEntity boss;

    public AttackManager(BossEntity boss) {
        this.boss = boss;
        this.attacks = new RandomCollection<>(this.boss.getRandom());
        this.currentAttack = new Idle(this);
        this.attacks.add(1d, LaserAttack::new);
    }

    public void tick() {
        this.currentAttack.tick();
    }

    public BossEntity getBoss() {
        return this.boss;
    }

    public Action getNextAction() {
        return attacks.next().apply(this);
    }

    public String getAnimation() {
        return this.currentAttack.getAnimation();
    }

    public void nextAction() {
        this.currentAttack = getNextAction();
    }

    public void setIdle() {
        this.currentAttack = new Idle(this);
    }
}
