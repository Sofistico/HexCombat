package net.hexcombat.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexcombat.hexcombatClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexCombatClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        hexcombatClient.init();
    }
}
