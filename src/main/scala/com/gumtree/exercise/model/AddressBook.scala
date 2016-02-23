package com.gumtree.exercise.model

import scala.io.Source

case class Name(value: String) extends AnyVal

case class Address(name: Name, gender: Gender, dateOfBirth: DateOfBirth)

case class AddressBook(addresses: Seq[Address]) {

  def countMales: Int = addresses.count(_.gender == Male)

  def findOldest: Option[Address] = addresses.sortBy(_.dateOfBirth)(DateOfBirth.orderAsc).headOption

  def findBy(name: Name): Option[Address] = addresses.find(_.name == name)

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