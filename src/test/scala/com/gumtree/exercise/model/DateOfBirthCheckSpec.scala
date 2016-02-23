package com.gumtree.exercise.model

import java.time.LocalDate

import org.scalacheck.{Gen, Prop}
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class DateOfBirthCheckSpec extends Specification with ScalaCheck {

  "DateOfBirth" should {

    val dateGenerator: Gen[String] = Gen.choose(0, 99).map(n => f"01/01/$n%02d")
    "parse dates from 1920" in {
      Prop.forAll(dateGenerator){ date: String =>
        DateOfBirth(date).value.isAfter(LocalDate.of(1919, 12, 31)) must beTrue
        DateOfBirth(date).value.isBefore(LocalDate.of(2019, 1,  2)) must beTrue
      }
    }

    "parse dates until 2019 " in {
      Prop.forAll(dateGenerator){ date: String =>
        DateOfBirth(date).value.isAfter(LocalDate.of(1919, 12, 31)) must beTrue
        DateOfBirth(date).value.isBefore(LocalDate.of(2019, 1,  2)) must beTrue
      }
    }
  }

}