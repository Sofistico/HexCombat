package net.hexcombat.casting.patterns.spells

import at.petrak.hexcasting.api.spell.*
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.Iota

class OpBeam : SpellAction {
    override val argc: Int
        get() = 2

    override fun execute(args: List<Iota>, ctx: CastingContext): Triple<RenderedSpell, Int, List<ParticleSpray>>? {
        val pos = args.getVec3(0, argc)
        val patterns = args.getPattern(1, argc)
        ctx.assertVecInRange(pos)
        return null
    }
}