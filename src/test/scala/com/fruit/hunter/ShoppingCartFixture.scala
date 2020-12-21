package com.fruit.hunter

trait ShoppingCartFixture {

  implicit class FruitCountOps(count: Int) {
    def apple = fruits(Apple)

    def apples = fruits(Apple)

    def orange = fruits(Orange)

    def oranges = fruits(Orange)

    private def fruits(f: Fruit) = List.fill(count)(f)
  }

  implicit class SeqOfFruitOps(fruits: List[Fruit]) {
    def and(others: List[Fruit]) = fruits ::: others
  }

}
