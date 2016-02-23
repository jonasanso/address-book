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

      def  toCSV(address: Address) = s"${address.name.value}, ${address.gender.value}, ${address.dateOfBirth.value}"

      addressBook.addresses.map(toCSV).mkString("\n") mustEqual data
    }

  }
}
