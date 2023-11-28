package net.hexcombat.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexcombat.hexcombat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(hexcombat.MOD_ID)
public class HexCombatForge {
    public hexcombatForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(hexcombat.MOD_ID, bus);
        bus.addListener(hexcombatClientForge::init);
        hexcombat.init();
    }
}
