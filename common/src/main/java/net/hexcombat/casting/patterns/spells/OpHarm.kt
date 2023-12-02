package net.hexcombat.casting.patterns.spells

import at.petrak.hexcasting.api.misc.MediaConstants
import at.petrak.hexcasting.api.spell.*
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.mishaps.MishapBadEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.text.Text

class OpHarm : SpellAction {
    override val argc = 2

    override fun execute(args: List<Iota>, ctx: CastingContext): Triple<RenderedSpell, Int, List<ParticleSpray>>? {
        val target = args.getEntity(0, argc);
        val damage = args.getPositiveDouble(1, argc);
        ctx.assertEntityInRange(target);
        if(target.isInvulnerable || !target.isAttackable){
            throw MishapBadEntity(target,
                Text.translatable("text.hexcombat.harm.notvalidentity"))
        }
            val cost = MediaConstants.DUST_UNIT + (damage.toInt() * 2)
        return Triple(
            Spell(target, damage.toFloat()),
            cost,
            listOf(ParticleSpray.burst(target.pos, 1.0))
        )
    }

    private data class Spell(val entity: Entity, val damage: Float) : RenderedSpell{
        override fun cast(ctx: CastingContext) {
            val source = DamageSource(ctx.source.name);
            source.setUsesMagic()
            entity.damage(source, damage)
        }

    }
}