package net.hexcombat.registry;

import at.petrak.hexcasting.api.PatternRegistry;
import at.petrak.hexcasting.api.misc.MediaConstants;
import at.petrak.hexcasting.api.spell.Action;
import at.petrak.hexcasting.api.spell.math.HexDir;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import at.petrak.hexcasting.common.casting.operators.spells.OpPotionEffect;
import kotlin.Triple;
import net.hexcombat.casting.patterns.math.OpGetCircle;
import net.hexcombat.casting.patterns.spells.OpShears;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.hexcombat.HexCombat.id;

public class HexCombatPatternRegistry {
    public static List<Triple<HexPattern, Identifier, Action>> PATTERNS = new ArrayList<>();
    public static List<Triple<HexPattern, Identifier, Action>> PER_WORLD_PATTERNS = new ArrayList<>();
    // IMPORTANT: be careful to keep the registration calls looking like this or be prepared to edit the regex pattern on line 199 of the docgen script (doc/collate_data.py)
    public static HexPattern SHEARS = register(HexPattern.fromAngles("eed", HexDir.WEST), "shears", new OpShears());
    public static HexPattern CIRCLE = register(HexPattern.fromAngles("qqqqadd", HexDir.EAST), "get-circle", new OpGetCircle());
    // great spells
    public static HexPattern SLOWFALL = registerPerWorld(HexPattern.fromAngles("aqqqqawwawawd", HexDir.EAST), "potion/slow-fall", new OpPotionEffect(StatusEffects.SLOW_FALLING, MediaConstants.DUST_UNIT / 3, true, true, true));
    public static HexPattern WATERBREATH = registerPerWorld(HexPattern.fromAngles("wawwqqawdwdw", HexDir.WEST), "potion/water-breath", new OpPotionEffect(StatusEffects.WATER_BREATHING, MediaConstants.DUST_UNIT / 5, true, true, true));
    public static HexPattern GLOW = registerPerWorld(HexPattern.fromAngles("aqqqqqeawaw", HexDir.NORTH_WEST), "potion/glowing", new OpPotionEffect(StatusEffects.GLOWING, MediaConstants.DUST_UNIT, false, false, true));

    public static void init() {
        try {
            for (Triple<HexPattern, Identifier, Action> patternTriple : PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird());
            }
            for (Triple<HexPattern, Identifier, Action> patternTriple : PER_WORLD_PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird(), true);
            }
        } catch (PatternRegistry.RegisterPatternException e) {
            e.printStackTrace();
        }
    }

    private static HexPattern register(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PATTERNS.add(triple);
        return pattern;
    }

    private static HexPattern registerPerWorld(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PER_WORLD_PATTERNS.add(triple);
        return pattern;
    }
}
