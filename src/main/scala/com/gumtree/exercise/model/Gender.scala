package com.gumtree.exercise.model

sealed trait Gender {
  def value: String
}
case object Male extends Gender {
  val value = "Male"
}

case object Female extends Gender {
  val value = "Female"
}

case object Other extends Gender {
  val value = "Other"
}

object Gender {
  val genders = List(Male, Female)

  def apply(value: String): Gender = genders.find(_.value == value.trim).getOrElse(Other)
}
