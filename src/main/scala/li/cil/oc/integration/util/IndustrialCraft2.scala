package li.cil.oc.integration.util

import li.cil.oc.integration.Mods
import net.minecraft.item.ItemStack

object IndustrialCraft2 {
  private lazy val miningLaser = try {
    val clazz = Class.forName("ic2.core.Ic2Items")
    val field = clazz.getField("miningLaser")
    Option(field.get(null).asInstanceOf[ItemStack])
  }
  catch {
    case _: Throwable => None
  }

  def isMiningLaser(stack: ItemStack) = stack != null && Mods.IndustrialCraft2API.isAvailable && (miningLaser match {
    case Some(laser) => laser.getItem == stack.getItem
    case _ => false
  })
}