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
    val priceBeforeDiscount =
      products.map(productsPrices(_)).sum.setScale(2, BigDecimal.RoundingMode.HALF_UP)

    priceBeforeDiscount - calcDiscount(products)
  }

  def calcDiscount(products: Seq[Fruit]): BigDecimal = {
    val applesAmount = products.count(_.equals(Apple))
    val orangesAmount = products.count(_.equals(Orange))

    val applesDiscount = ((applesAmount / 2) * productsPrices(Apple)).setScale(2, BigDecimal.RoundingMode.HALF_UP)
    val orangesDiscount = ((orangesAmount / 3) * productsPrices(Orange))setScale(2, BigDecimal.RoundingMode.HALF_UP)

    applesDiscount + orangesDiscount
  }
}
