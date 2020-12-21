package com.fruit.hunter

import org.specs2.mutable.Specification

class ShoppingCartSpec extends Specification with ShoppingCartFixture {

  "Checkout cost" should {

    "be zero for empty basket" in {
      ShoppingCart.checkout(null) === 0
      ShoppingCart.checkout() === 0
    }

    "be 60p for apples and 25p for oranges" in {
      ShoppingCart.checkout(1 apple) === 0.6
      ShoppingCart.checkout(1 orange) === 0.25
      ShoppingCart.checkout(1.apple and 1.orange) === 0.85
      ShoppingCart.checkout(2.apples and 3.oranges) === 1.35
    }

    "support buy one, get one free on Apples" in {
      ShoppingCart.checkout(1 apple) === 0.6
      ShoppingCart.checkout(2 apples) === 0.6
      ShoppingCart.checkout(3 apples) === 1.2
    }

    "support 3 for the price of 2 on Oranges" in {
      ShoppingCart.checkout(3 oranges) === 0.50
      ShoppingCart.checkout(4 oranges) === 0.75
    }
  }
}
