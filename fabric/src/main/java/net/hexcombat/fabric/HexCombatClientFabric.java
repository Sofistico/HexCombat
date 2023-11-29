package net.hexcombat.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexcombat.HexCombatClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexCombatClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HexCombatClient.init();
    }
}
