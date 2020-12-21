package com.fruit.hunter

import org.specs2.mutable.Specification

class ShoppingCartSpec extends Specification {

  "Checkout cost" should {
    "be zero for empty basket" in {
      ShoppingCart.checkout(null) === 0
      ShoppingCart.checkout() === 0
    }

    "be 60p for apples and 25p for oranges" in {
      ShoppingCart.checkout(Seq(Apple)) === 0.6
      ShoppingCart.checkout(Seq(Orange)) === 0.25
      ShoppingCart.checkout(Seq(Apple,Apple, Orange, Orange, Orange)) === 1.95
    }
  }
}
