package com.fruit.hunter

sealed trait Fruit {
  def price: BigDecimal
}

case object Apple extends Fruit {
  override def price: BigDecimal = 0.60
}

case object Orange extends Fruit {
  override def price: BigDecimal = 0.25
}

object ShoppingCart {
  def checkout(fruits: Seq[Fruit] = Seq()): BigDecimal = {
    if (fruits == null || fruits.isEmpty) 0
    else fruits.map(_.price).sum
  }
}
