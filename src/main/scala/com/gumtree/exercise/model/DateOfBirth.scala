package com.gumtree.exercise.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateOfBirth(val value: LocalDate) extends AnyVal

object DateOfBirth {
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy")

  def apply(value: String): DateOfBirth = new DateOfBirth(parseDate(value.trim))

  private def parseDate(date: String): LocalDate = {
    LocalDate.parse(date, formatter)
  }
}

