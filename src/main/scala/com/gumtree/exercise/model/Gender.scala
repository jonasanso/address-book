package com.gumtree.exercise.model

sealed abstract class Gender(val value: String)

case object Male extends Gender("Male")

case object Female extends Gender("Female")

case object Other extends Gender("Other")

object Gender {
  val genders = List(Male, Female)

  def apply(value: String): Gender = genders.find(_.value == value.trim).getOrElse(Other)
}
