package com.fruit.hunter

import org.specs2.mutable.Specification

class ShoppingCartSpec extends Specification {

  "Checkout cost" should {
    "be zero for empty basket" in {
      ShoppingCart.checkout(null) === 0
      ShoppingCart.checkout() === 0
    }
  }
}
