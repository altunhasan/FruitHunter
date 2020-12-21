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
    lazy val calculate = {
      val (appleOfferPrice, remainingFruits) = applyAppleOffer(fruits)
      val (orangeOfferPrice, remainingFruitsNotUnderOffer) = applyOrangeOffer(remainingFruits)
      appleOfferPrice + orangeOfferPrice + remainingFruitsNotUnderOffer.map(_.price).sum
    }

    if (fruits == null || fruits.isEmpty) 0 else calculate
  }

  private def applyAppleOffer(fruits: Seq[Fruit]) = {
    val (apples, otherFruits) = fruits.partition(_ == Apple)
    val offerPrice = apples.size / 2 * Apple.price
    val remainingFruits = List.tabulate(apples.size % 2)(_ => Apple) ::: otherFruits.toList
    offerPrice -> remainingFruits
  }

  private def applyOrangeOffer(fruits: Seq[Fruit]) = {
    val (oranges, otherFruits) = fruits.partition(_ == Orange)
    val offerPrice = oranges.size / 3 * Orange.price * 2
    val remainingFruits = List.tabulate(oranges.size % 3)(_ => Orange) ::: otherFruits.toList
    offerPrice -> remainingFruits
  }

}
