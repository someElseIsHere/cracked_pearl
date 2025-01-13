package org.theplaceholder.crackedpearl;

import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.theplaceholder.crackedpearl.entity.CrPeEntityTypes;
import org.theplaceholder.crackedpearl.event.CrPeEventBus;
import org.theplaceholder.crackedpearl.sound.CrPeSoundEvents;

@Mod(CrackedPearlMod.MOD_ID)
public final class CrackedPearlMod {
    public static final String MOD_ID = "cracked_pearl";

    public CrackedPearlMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CrPeEntityTypes.register(eventBus);
        CrPeSoundEvents.register(eventBus);
        CrPeEventBus.register(eventBus);
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
