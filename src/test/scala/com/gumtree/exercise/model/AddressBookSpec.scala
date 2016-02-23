package com.gumtree.exercise.model

import org.specs2.mutable.Specification

import scala.io.Source

class AddressBookSpec extends Specification {

  val data =
    """Bill McKnight, Male, 16/03/77
      |Paul Robinson, Male, 15/01/85
      |Gemma Lane, Female, 20/11/91
      |Sarah Stone, Female, 20/09/80
      |Wes Jackson, Male, 14/08/74""".stripMargin

  "AddressBook" should {
    "read an AddressBook" in {
      val addressBook = AddressBook.read(Source.fromString(data))

      def  toCSV(address: Address) = s"${address.name.value}, ${address.gender.value}, ${address.dateOfBirth.value.format(DateOfBirth.formatter)}"

      addressBook.addresses.map(toCSV).mkString("\n") mustEqual data
    }

    "count the number of males" in {
      def createAddress(gender: Gender) = Address(Name("name"), gender, DateOfBirth("16/03/77"))

      new AddressBook(Seq.empty).countMales mustEqual 0

      new AddressBook(Seq(createAddress(Male))).countMales mustEqual 1

      new AddressBook(Seq(createAddress(Female))).countMales mustEqual 0

      new AddressBook(
        Seq(createAddress(Female),
            createAddress(Female),
            createAddress(Male),
            createAddress(Male))).countMales mustEqual 2
    }

    "find oldest" in {
      def createAddress(dateOfBirth: DateOfBirth) = Address(Name("name"), Other, dateOfBirth)

      new AddressBook(
        Seq(createAddress(DateOfBirth("16/03/77")),
          createAddress(DateOfBirth("15/01/85")),
          createAddress(DateOfBirth("20/11/91")),
          createAddress(DateOfBirth("14/08/74")))).findOldest mustEqual Some(createAddress(DateOfBirth("14/08/74")))


    }
  }
}
