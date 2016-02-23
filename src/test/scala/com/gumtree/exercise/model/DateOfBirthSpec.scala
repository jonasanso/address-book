package com.gumtree.exercise.model

import java.time.LocalDate

import org.specs2.mutable.Specification

class DateOfBirthSpec extends Specification {

  "DateOfBirth" should {
    "be 13/07/77" in {
      DateOfBirth("13/07/77").value mustEqual LocalDate.of(1977, 7, 13)
    }

    "order dates asccending" in {
      val unordered = List(DateOfBirth("13/07/77"), DateOfBirth("13/07/37"), DateOfBirth("13/07/87"), DateOfBirth("13/07/27"))
      val ordered   = List(DateOfBirth("13/07/27"), DateOfBirth("13/07/37"), DateOfBirth("13/07/77"), DateOfBirth("13/07/87"))

      unordered.sorted(DateOfBirth.orderAsc) mustEqual ordered
    }
  }

}