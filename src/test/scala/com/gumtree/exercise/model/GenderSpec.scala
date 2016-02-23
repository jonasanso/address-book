package com.gumtree.exercise.model

import org.specs2.mutable.Specification

class GenderSpec extends Specification {

  "Gender" should {
    "be male " in {
      Gender("Male") mustEqual Male
    }

    "be female " in {
      Gender("Female") mustEqual Female
    }

    "be other " in {
      Gender("Transexual") mustEqual Other
      Gender("Transgender") mustEqual Other
      Gender("Transvestite") mustEqual Other
      Gender("Other") mustEqual Other
    }
  }
}
