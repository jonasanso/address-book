package com.gumtree.exercise

import java.io.File

import com.gumtree.exercise.model.{AddressBook, Name}

import scala.io.Source

/**
  * Created by jonas on 23/02/16.
  */
object Main {

  def main(args: Array[String]): Unit = {

    def howManyDaysIsBillOlderThanPaul(addressBook: AddressBook): Unit = {
      for {
        bill <- addressBook.findBy(Name("Bill McKnight"))
        paul <- addressBook.findBy(Name("Paul Robinson"))
      } yield {
        println(s"Bill is ${bill.dateOfBirth.daysOlder(paul.dateOfBirth)} days older than Paul")
      }
    }

    def showOldest(addressBook: AddressBook): Unit = {
      addressBook.findOldest match {
        case Some(oldest) =>
          println(s"Oldest person is ${oldest.name} born ${oldest.dateOfBirth.value}")
        case None =>
          println("Ups, the address book is empty, no oldest person found")
      }
    }

    def showMales(addressBook: AddressBook): Unit = {
      println(s"Found ${addressBook.countMales} males.")
    }

    args match {
      case Array(file) if new File(file).exists() =>
        val addressBook = AddressBook.read(Source.fromFile(file))

        showMales(addressBook)

        showOldest(addressBook)

        howManyDaysIsBillOlderThanPaul(addressBook)
      case Array(file) =>
        println(s"File $file not found.")
      case _ =>
        println("Usage sbt \"run file\" ")
    }
  }
}
