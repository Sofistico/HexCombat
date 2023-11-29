package net.hexcombat.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexcombat.HexCombat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(HexCombat.MOD_ID)
public class HexCombatForge {
    public HexCombatForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(HexCombat.MOD_ID, bus);
        bus.addListener(HexCombatClientForge::init);
        HexCombat.init();
    }
}
