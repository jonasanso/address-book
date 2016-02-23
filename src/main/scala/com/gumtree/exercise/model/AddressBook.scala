package com.gumtree.exercise.model

import scala.io.Source

case class Name(value: String) extends AnyVal

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

class DateOfBirth(val value: String) extends AnyVal
object DateOfBirth {
  def apply(value: String): DateOfBirth = new DateOfBirth(value.trim)
}

case class Address(name: Name, gender: Gender, dateOfBirth: DateOfBirth)

case class AddressBook(addresses: Seq[Address]) {

  def countMales = addresses.count(_.gender == Male)
}

object AddressBook {

  def read(source: Source): AddressBook = {
    val addresses = source.getLines().toList.map(_.split(",")).map {
      case Array(name, gender, dateOfBirth) =>
        Address(Name(name), Gender(gender), DateOfBirth(dateOfBirth))
    }

    AddressBook(addresses.toSeq)
  }

}