package org.theplaceholder.crackedpearl.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.theplaceholder.crackedpearl.entity.attack.AttackManager;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;

public class BossEntity extends MobEntity implements GeoEntity {
    private final ServerBossBar bossBar;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private AttackManager manager;

    public BossEntity(EntityType<? extends BossEntity> type, World world) {
        super(type, world);
        this.bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.WHITE, BossBar.Style.PROGRESS);
        this.manager = new AttackManager(this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 0, this::predicate));
    }

    private PlayState predicate(AnimationState<BossEntity> animation) {
        AnimationController<BossEntity> controller = animation.getController();

        controller.setAnimation(RawAnimation.begin().then(this.manager.getAnimation(), Animation.LoopType.PLAY_ONCE));

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossBar.setPercent(this.getHealth());
        this.manager.tick();
    }
}
