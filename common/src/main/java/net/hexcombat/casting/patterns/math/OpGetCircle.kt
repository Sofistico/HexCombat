// Credits go to Sonunte from HexKinetics, copied from:
// https://github.com/Sonunte/HexKinetics/blob/master/Common/src/main/java/net/sonunte/hexkinetics/common/casting/actions/math/OpGetVectorsBy.kt

package net.hexcombat.casting.patterns.math

import at.petrak.hexcasting.api.spell.ConstMediaAction
import at.petrak.hexcasting.api.spell.*
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.*
import net.minecraft.util.math.Vec3d

class OpGetCircle : ConstMediaAction {
    override val argc = 2
    override fun execute(args: List<Iota>, ctx: CastingContext): List<Iota> {
        val pos = args.getVec3(0, argc)
        val radius = args.getPositiveDouble(1, argc)
        ctx.assertVecInRange(pos)

        val blockPositions = getBlockPositionsSphere(pos, radius)

        return blockPositions.map(::Vec3Iota).asActionResult
    }
    private fun getBlockPositionsSphere(pos: Vec3d, radius: Double): List<Vec3d> {
        val blockPositions = ArrayList<Vec3d>()
        val radiusInt = radius.toInt()
        val innerRadiusInt = radius - 1

        for (x in -radiusInt..radiusInt) {
            for (y in -radiusInt..radiusInt) {
                for (z in -radiusInt..radiusInt) {
                    val distanceSq = x * x + y * y + z * z
                    if (distanceSq <= radius * radius && distanceSq >= innerRadiusInt * innerRadiusInt) {
                        blockPositions.add(pos.add(x.toDouble(), y.toDouble(), z.toDouble()))
                    }
                }
            }
        }

        return blockPositions
    }
}