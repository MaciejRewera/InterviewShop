package com.rewera.grocery

import org.scalatest.{FlatSpec, Matchers}

class GrocerySystemTest extends FlatSpec with Matchers {

  "A GrocerySystem" should "return 0.6 for Apple and 0.25 for Orange" in {
    GrocerySystem.totalCost(List(Apple)) shouldBe
      BigDecimal(0.6).setScale(2, BigDecimal.RoundingMode.HALF_UP)
    GrocerySystem.totalCost(List(Orange)) shouldBe
      BigDecimal(0.25).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
  it should "return 0 for an empty items list" in {
    GrocerySystem.totalCost(List()) shouldBe
      BigDecimal(0).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
  it should "return 1.45 for items [ Apple, Apple, Orange, Apple ]" in {
    val products = List(Apple, Apple, Orange, Apple)
    GrocerySystem.totalCost(products) shouldBe
      BigDecimal(1.45).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }

  it should "return 0.6 for 2 Apples" in {
    val products = List(Apple, Apple)
    GrocerySystem.totalCost(products) shouldBe
      BigDecimal(0.6).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
  it should "return 0.5 for 3 Oranges" in {
    val products = List(Orange, Orange, Orange)
    GrocerySystem.totalCost(products) shouldBe
      BigDecimal(0.5).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }

}
