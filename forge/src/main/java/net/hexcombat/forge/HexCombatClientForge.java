package net.hexcombat.forge;

import net.hexcombat.hexcombatClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class hexcombatClientForge {
    public static void init(FMLClientSetupEvent event) {
        hexcombatClient.init();
    }
}
