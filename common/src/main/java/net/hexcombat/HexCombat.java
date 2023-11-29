package net.hexcombat;

import net.hexcombat.registry.HexCombatIotaTypeRegistry;
import net.hexcombat.registry.HexCombatItemRegistry;
import net.hexcombat.registry.HexCombatPatternRegistry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class HexCombat {
    public static final String MOD_ID = "hexcombat";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("Hex Dummy says hello!");

        HexCombatItemRegistry.init();
        HexCombatIotaTypeRegistry.init();
        HexCombatPatternRegistry.init();

        LOGGER.info(DummyAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static Identifier id(String string) {
        return new Identifier(MOD_ID, string);
    }
}
