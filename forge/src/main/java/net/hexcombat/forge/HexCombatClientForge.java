package net.hexcombat.forge;

import net.hexcombat.HexCombatClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class HexCombatClientForge {
    public static void init(FMLClientSetupEvent event) {
        HexCombatClient.init();
    }
}
