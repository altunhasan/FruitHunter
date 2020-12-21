package com.fruit.hunter

trait Fruit

object ShoppingCart {
  def checkout(fruits: Seq[Fruit] = Seq()): BigDecimal = {
    if (fruits == null || fruits.isEmpty) 0 else ???
  }
}
