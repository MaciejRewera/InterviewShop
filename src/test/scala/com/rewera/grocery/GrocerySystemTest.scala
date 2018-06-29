package com.rewera.grocery

import org.scalatest.{FlatSpec, Matchers}

class GrocerySystemTest extends FlatSpec with Matchers {

  "A GrocerySystem" should "return 0.6 for Apple and 0.25 for Orange" in {
    GrocerySystem.totalCost(Seq(Apple)) shouldBe
      BigDecimal(0.6).setScale(2, BigDecimal.RoundingMode.HALF_UP)
    GrocerySystem.totalCost(Seq(Orange)) shouldBe
      BigDecimal(0.25).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
  it should "return 0 for an empty items list" in {
    GrocerySystem.totalCost(Seq()) shouldBe
      BigDecimal(0).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
  it should "return 2.05 for items [ Apple, Apple, Orange, Apple ]" in {
    val products = Seq(Apple, Apple, Orange, Apple)
    GrocerySystem.totalCost(products) shouldBe
      BigDecimal(2.05).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }


}
