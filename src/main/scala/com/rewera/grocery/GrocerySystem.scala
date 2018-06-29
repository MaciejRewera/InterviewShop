package com.rewera.grocery

sealed trait Fruit
case object Apple extends Fruit
case object Orange extends Fruit

object GrocerySystem {

  val productsPrices: Map[Fruit, BigDecimal] = Map(
    Apple -> BigDecimal(0.6),
    Orange -> BigDecimal(0.25)
  )

  def totalCost(products: Seq[Fruit]): BigDecimal = {
    products.map(productsPrices(_)).sum.setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
}
