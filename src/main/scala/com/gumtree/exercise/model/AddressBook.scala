package com.gumtree.exercise.model

case class Name(value: String) extends AnyVal
case class Gender(value: String) extends AnyVal
case class DateOfBirth(value: String) extends AnyVal

case class Address(name: Name, gender: Gender, dateOfBirth: DateOfBirth)

case class AddressBook(addresses: Seq[Address])
