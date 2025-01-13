package org.theplaceholder.crackedpearl.client.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.EntityTrackingSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class ClientUtils {
    public static void playSoundFromEntity(SoundEvent sound, SoundCategory category, float volume, float pitch, Entity entity) {
        MinecraftClient.getInstance().getSoundManager().play(new EntityTrackingSoundInstance(sound, category, volume, pitch, entity, entity.getWorld().random.nextInt()));
    }
}
